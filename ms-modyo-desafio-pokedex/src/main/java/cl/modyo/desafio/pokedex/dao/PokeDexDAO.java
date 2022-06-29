package cl.modyo.desafio.pokedex.dao;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */

import cl.modyo.desafio.pokedex.exceptions.SystemException;
import cl.modyo.desafio.pokedex.vo.PokeDexResponseVO;

public interface PokeDexDAO {

    PokeDexResponseVO obtInfoPokemon(String name, String endPoint) throws SystemException;

    PokeDexResponseVO obtTipoPokemon(String name, String endPoint) throws SystemException;

    ;

    PokeDexResponseVO obtDescPokemon(String name, String endPoint) throws SystemException;

    ;

    PokeDexResponseVO obtEvolucionPokemon(String name, String endPoint) throws SystemException;

    ;

}