package cl.modyo.desafio.pokedex.controller;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LivenessController {

    private static final Logger logger = LogManager.getLogger(LivenessController.class);

    @GetMapping("/liveness")
    public @ResponseBody
    ResponseEntity<Object> testLiveness() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception e) {
            logger.log(Level.ERROR, "Ocurrio un error al llamar al metodo testLiveness"
                    .concat(" : ".concat(e.getMessage().concat(e.getLocalizedMessage()))));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
    }
}