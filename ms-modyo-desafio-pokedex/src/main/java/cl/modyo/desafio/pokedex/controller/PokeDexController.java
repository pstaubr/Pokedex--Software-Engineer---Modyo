package cl.modyo.desafio.pokedex.controller;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */


import cl.modyo.desafio.pokedex.exceptions.BusinessException;
import cl.modyo.desafio.pokedex.exceptions.SystemException;
import cl.modyo.desafio.pokedex.helper.PokeDexHelper;
import cl.modyo.desafio.pokedex.util.Constantes;
import cl.modyo.desafio.pokedex.vo.ResponseEntityVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(info = @Info(title = "Desafío Software Engineer - Modyo", version = "v1"
        , description = "API encargada de consumir API PokeApi",
        license = @License(name = "Desafío Software Engineer - Modyo", url = "https://www.modyo.com/")
        , contact = @Contact(name = "Desarrollador: Pablo Staub Ramírez Contacto: pablo.staubr@gmail.com " +
        "Celular: +56966495190")))
@RestController
public class PokeDexController {


    static Logger logger = LogManager.getLogger(PokeDexController.class);

    @Autowired
    PokeDexHelper pokeDexHelper;

    /**
     * Metodo encargado consultar informacion basica, tipo , peso, listado de habilidades, descripción y evoluciones de un pokemon por id o name
     *
     * @param name
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/pokedex/{name}")
    public ResponseEntity<Object> obtInfoPokemon(@PathVariable String name) {
        Object rsp = null;
        try {
            rsp = pokeDexHelper.obtInfoPokemon(name);
        } catch (BusinessException businessException) {
            logger.log(Level.ERROR, Constantes.MSG_ERROR, businessException.getMessage(), businessException);
            return new ResponseEntity<>(ResponseEntityVO.getInstanceDefault(businessException), HttpStatus.OK);
        } catch (SystemException systemException) {
            logger.log(Level.ERROR, Constantes.MSG_ERROR, systemException.getMessage(), systemException);
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(systemException.getLocalizedMessage());
        } catch (Exception e) {
            logger.log(Level.ERROR, Constantes.MSG_ERROR, e.getMessage(), e);
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(rsp);
    }
}