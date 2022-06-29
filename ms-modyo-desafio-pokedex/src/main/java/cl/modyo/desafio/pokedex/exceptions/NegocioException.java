package cl.modyo.desafio.pokedex.exceptions;

/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */
public class NegocioException extends RuntimeException {

    private String code;
    private String message;

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException(String code, String message) {
        this.code = code;
        this.message = message;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
