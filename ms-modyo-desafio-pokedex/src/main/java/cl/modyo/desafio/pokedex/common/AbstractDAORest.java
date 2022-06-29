package cl.modyo.desafio.pokedex.common;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbstractDAORest<T> {

    static Logger logger = LogManager.getLogger(AbstractDAORest.class);

    /**
     * Forma generica de consumir servicios rest post
     *
     * @param url
     * @param classAux
     * @return
     */
    public <T> T callGet(String url, Class<T> classAux) {

        logger.log(Level.INFO, "Inicio  get url {}. ", url);

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_JSON);
        /**
         * Validacion api-key
         */
        HttpEntity<Object> request = new HttpEntity(headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, classAux);
        return responseEntity.getBody();
    }


    /**
     * Forma generaica de consumir servicios rest get
     *
     * @return
     */
    private RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}