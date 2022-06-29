package cl.modyo.desafio.pokedex.exceptions;

/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */
public class BusinessException extends CoreException {

    public BusinessException(String codigo, String mensaje) {
        super(codigo, mensaje);
    }
}
