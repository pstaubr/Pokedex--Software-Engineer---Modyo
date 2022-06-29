package cl.modyo.desafio.pokedex.config;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

import static java.util.Arrays.stream;

@Service
public class Config {

    static Logger logger = LogManager.getLogger(Config.class);

    public static final String SPRING_CONFIG_NAME = "--spring.config.name=";
    private static String bundle = "application.properties";

    @Value("${properties.location:}")
    private String propertiesLocation;

    Properties userProperties;

    public static void args(String[] args) {

        for (String arg : args) {
            if (arg.startsWith(SPRING_CONFIG_NAME)) {
                bundle = arg.substring(SPRING_CONFIG_NAME.length()) + ".properties";
            }
        }
    }

    public Config() {

        final Resource[] possiblePropertiesResources = {new ClassPathResource(bundle),
                new PathResource("config/" + bundle), new PathResource(bundle)
                // ,new PathResource(getCustomPath())
        };
        InputStream inputStream = null;
        try {
            final Resource propertiesResource = stream(possiblePropertiesResources).filter(Resource::exists)
                    .reduce((previous, current) -> current).get();
            userProperties = new Properties();
            inputStream = propertiesResource.getInputStream();
            userProperties.load(inputStream);
        } catch (NoSuchElementException e) {
            String message = "No se encuentra archivo de configuracion: " + bundle;
            logger.log(Level.ERROR, message, e);
            throw new RuntimeException(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.log(Level.ERROR, "Problema al cerrar inputStream");
            }
        }
        logger.log(Level.INFO, "configurado");
    }

    public int getInt(String key) {
        Object o = userProperties.get(key);
        if (o == null) {
            return -1;
        }
        return Integer.parseInt(o.toString());
    }

    public String getString(String key) {
        return (String) userProperties.get(key);
    }
}