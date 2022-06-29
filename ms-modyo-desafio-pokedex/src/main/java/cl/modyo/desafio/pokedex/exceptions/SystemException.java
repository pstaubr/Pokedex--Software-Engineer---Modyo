package cl.modyo.desafio.pokedex.exceptions;

/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */
public class SystemException extends CoreException {

    private Class context;
    private Throwable cause;
    private String codigo;
    private String mensaje;

    public SystemException(Class context, Throwable cause) {
        super();
        this.setContext(context);
        this.setCause(cause);
    }

    public SystemException(Class context, Throwable cause, String mensaje) {
        super();
        this.setContext(context);
        this.setCause(cause);
        this.setMensaje(mensaje);
    }

    public SystemException(String codigo, String mensaje) {
        super();
        this.setCodigo(codigo);
        this.setMensaje(mensaje);
    }

    public SystemException(String mensaje) {
        super();
        this.setMensaje(mensaje);
    }

    public SystemException(Class context, String codigo, String mensaje) {
        super();
        this.setContext(context);
        this.setCodigo(codigo);
        this.setMensaje(mensaje);
    }

    public Class getContext() {
        return context;
    }

    public void setContext(Class context) {
        this.context = context;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
