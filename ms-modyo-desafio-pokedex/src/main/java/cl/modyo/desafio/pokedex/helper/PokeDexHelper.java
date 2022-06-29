package cl.modyo.desafio.pokedex.helper;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */


import cl.modyo.desafio.pokedex.dao.PokeDexDAO;
import cl.modyo.desafio.pokedex.exceptions.BusinessException;
import cl.modyo.desafio.pokedex.exceptions.SystemException;
import cl.modyo.desafio.pokedex.util.Constantes;
import cl.modyo.desafio.pokedex.vo.PokeDexResponseVO;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class PokeDexHelper {
    static Logger logger = LogManager.getLogger(PokeDexHelper.class);


    @Autowired
    PokeDexDAO pokeDexDAO;

    @Value("${api.rest.pokedex.endpoint}")
    private String pathPokeDex;


    /**
     * Metodo encargado consultar informacion basica, tipo , peso, listado de habilidades,
     * descripción y evoluciones de un pokemon por id o name
     *
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public PokeDexResponseVO obtInfoPokemon(String name) throws BusinessException, SystemException {
        logger.log(Level.INFO, "Inicio metodo helper obtInfoPokemon");
        logger.log(Level.INFO, "Valor entrada name: ");
        logger.log(Level.INFO, name);
        try {
            logger.log(Level.INFO, "Inicio llamado metodo path pokemon");
            PokeDexResponseVO rspInfoPokemon = pokeDexDAO.obtInfoPokemon(pathPokeDex.concat("/pokemon/"), name);

            final String concat = Constantes.MSJ_ERROR_NO_EXISTE.concat(Constantes.SPACE.concat(name.trim()));
            if (rspInfoPokemon == null || Constantes.EMPTY.equalsIgnoreCase(rspInfoPokemon.toString())) {
                logger.log(Level.INFO, rspInfoPokemon);
                throw new BusinessException(Constantes.COD_00019, concat);
            }

            logger.log(Level.INFO, "Inicio llamado metodo path type");
            PokeDexResponseVO rspTipoPokemon = pokeDexDAO.obtTipoPokemon(pathPokeDex.concat("/type/"), rspInfoPokemon.getId().toString());

            if (rspTipoPokemon == null || Constantes.EMPTY.equalsIgnoreCase(rspInfoPokemon.toString())) {
                logger.log(Level.INFO, rspInfoPokemon);
                throw new BusinessException(Constantes.COD_00019, concat);
            } else {
                rspInfoPokemon.setDamage_relations(rspTipoPokemon.getDamage_relations());
                logger.log(Level.INFO, "Fin llamado metodo path type");
            }
            logger.log(Level.INFO, "Inicio llamado metodo path characteristic");
            PokeDexResponseVO rspDescPokemon = pokeDexDAO.obtDescPokemon(pathPokeDex.concat("/characteristic/"), name);

            if (rspDescPokemon == null || Constantes.EMPTY.equalsIgnoreCase(rspInfoPokemon.toString())) {
                logger.log(Level.INFO, rspInfoPokemon);
                throw new BusinessException(Constantes.COD_00019, concat);
            } else {
                rspInfoPokemon.setDescriptions(rspDescPokemon.getDescriptions());
                logger.log(Level.INFO, "Fin llamado metodo path characteristic");
            }

            logger.log(Level.INFO, "Inicio llamado metodo path evolution-chain");
            PokeDexResponseVO rspEvolucionPokemon = pokeDexDAO.obtEvolucionPokemon(pathPokeDex.concat("/evolution-chain/"), rspInfoPokemon.getId().toString());

            if (rspEvolucionPokemon == null || Constantes.EMPTY.equalsIgnoreCase(rspInfoPokemon.toString())) {
                logger.log(Level.INFO, rspInfoPokemon);
                throw new BusinessException(Constantes.COD_00019, concat);
            } else {
                rspInfoPokemon.setChain(rspEvolucionPokemon.getChain());
                logger.log(Level.INFO, "Fin llamado metodo path evolution-chain");
            }
            logger.log(Level.INFO, "Fin metodo helper obtInfoPokemon");
            return rspInfoPokemon;
        } catch (Exception exception) {
            logger.log(Level.ERROR, exception.getMessage().concat(Constantes.SPACE).concat(Constantes.MSJ_ERROR_POKE_API), exception.getLocalizedMessage());
            throw new SystemException(Constantes.COD_00025, Constantes.MSJ_ERROR_POKE_API);
        }
    }
}