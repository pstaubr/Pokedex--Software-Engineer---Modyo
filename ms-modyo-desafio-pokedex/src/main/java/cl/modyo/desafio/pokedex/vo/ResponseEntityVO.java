package cl.modyo.desafio.pokedex.vo;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */

import cl.modyo.desafio.pokedex.exceptions.CoreException;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@Setter
public class ResponseEntityVO<T> {

    static Logger logger = LogManager.getLogger(ResponseEntityVO.class);

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("mensaje")
    private String mensaje;

    @JsonProperty("body")
    private T body;

    public ResponseEntityVO() {
    }

    public ResponseEntityVO(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public ResponseEntityVO(String codigo, String mensaje, T body) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.body = body;
    }

    public static ResponseEntityVO getInstanceDefault(CoreException exception) {
        return new ResponseEntityVO(exception.getCodigo(), exception.getMensaje());
    }
}