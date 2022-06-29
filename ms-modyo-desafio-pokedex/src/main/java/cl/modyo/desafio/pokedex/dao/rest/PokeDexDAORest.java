package cl.modyo.desafio.pokedex.dao.rest;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */

import cl.modyo.desafio.pokedex.common.AbstractDAORest;
import cl.modyo.desafio.pokedex.dao.PokeDexDAO;
import cl.modyo.desafio.pokedex.exceptions.SystemException;
import cl.modyo.desafio.pokedex.util.Constantes;
import cl.modyo.desafio.pokedex.vo.PokeDexResponseVO;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class PokeDexDAORest extends AbstractDAORest<PokeDexResponseVO> implements PokeDexDAO {
    static Logger logger = LogManager.getLogger(PokeDexDAORest.class);

    /**
     * @param name
     * @param endPoint
     * @return
     * @throws SystemException
     */
    public PokeDexResponseVO obtInfoPokemon(String endPoint, String name) throws SystemException {
        logger.log(Level.INFO, "Inicio obtInfoPokemon");
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add(Constantes.USER_AGENT, Constantes.USER_AGENT_VALUE);
            HttpEntity<String> entity = new HttpEntity<>(Constantes.PARAMETERS, headers);

            ResponseEntity<PokeDexResponseVO> response = restTemplate.exchange(endPoint.concat(name), HttpMethod.GET, entity, PokeDexResponseVO.class);
            logger.log(Level.INFO, Constantes.MSJ_OK_POKE_API);
            logger.log(Level.INFO, "Fin obtInfoPokemon");
            return response.getBody();
        } catch (Exception exception) {
            logger.log(Level.ERROR, exception.getMessage().concat(Constantes.SPACE).concat(Constantes.MSJ_ERROR_POKE_API), exception.getLocalizedMessage());
            throw new SystemException(Constantes.COD_00025, Constantes.MSJ_ERROR_POKE_API);
        }
    }

    /**
     * @param name
     * @param endPoint
     * @return
     * @throws SystemException
     */
    public PokeDexResponseVO obtTipoPokemon(String endPoint, String name) throws SystemException {
        logger.log(Level.INFO, "Inicio obtTipoPokemon");
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add(Constantes.USER_AGENT, Constantes.USER_AGENT_VALUE);
            HttpEntity<String> entity = new HttpEntity<>(Constantes.PARAMETERS, headers);

            ResponseEntity<PokeDexResponseVO> response = restTemplate.exchange(endPoint.concat(name), HttpMethod.GET, entity, PokeDexResponseVO.class);
            logger.log(Level.INFO, Constantes.MSJ_OK_POKE_API);
            logger.log(Level.INFO, "Fin obtTipoPokemon");
            return response.getBody();
        } catch (Exception exception) {
            logger.log(Level.ERROR, exception.getMessage().concat(Constantes.SPACE).concat(Constantes.MSJ_ERROR_POKE_API), exception.getLocalizedMessage());
            throw new SystemException(Constantes.COD_00025, Constantes.MSJ_ERROR_POKE_API);
        }
    }

    /**
     * @param name
     * @param endPoint
     * @return
     * @throws SystemException
     */
    public PokeDexResponseVO obtDescPokemon(String endPoint, String name) throws SystemException {
        logger.log(Level.INFO, "Inicio obtDescPokemon");
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add(Constantes.USER_AGENT, Constantes.USER_AGENT_VALUE);
            HttpEntity<String> entity = new HttpEntity<>(Constantes.PARAMETERS, headers);

            ResponseEntity<PokeDexResponseVO> response = restTemplate.exchange(endPoint.concat(name), HttpMethod.GET, entity, PokeDexResponseVO.class);
            logger.log(Level.INFO, Constantes.MSJ_OK_POKE_API);
            logger.log(Level.INFO, "Fin obtDescPokemon");
            return response.getBody();
        } catch (Exception exception) {
            logger.log(Level.ERROR, exception.getMessage().concat(Constantes.SPACE).concat(Constantes.MSJ_ERROR_POKE_API), exception.getLocalizedMessage());
            throw new SystemException(Constantes.COD_00025, Constantes.MSJ_ERROR_POKE_API);
        }
    }

    /**
     * @param name
     * @param endPoint
     * @return
     * @throws SystemException
     */
    public PokeDexResponseVO obtEvolucionPokemon(String endPoint, String name) throws SystemException {
        logger.log(Level.INFO, "Inicio obtEvolucionPokemon");
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add(Constantes.USER_AGENT, Constantes.USER_AGENT_VALUE);
            HttpEntity<String> entity = new HttpEntity<>(Constantes.PARAMETERS, headers);

            ResponseEntity<PokeDexResponseVO> response = restTemplate.exchange(endPoint.concat(name), HttpMethod.GET, entity, PokeDexResponseVO.class);
            logger.log(Level.INFO, Constantes.MSJ_OK_POKE_API);
            logger.log(Level.INFO, "Fin obtEvolucionPokemon");
            return response.getBody();
        } catch (Exception exception) {
            logger.log(Level.ERROR, exception.getMessage().concat(Constantes.SPACE).concat(Constantes.MSJ_ERROR_POKE_API), exception.getLocalizedMessage());
            throw new SystemException(Constantes.COD_00025, Constantes.MSJ_ERROR_POKE_API);
        }
    }
}