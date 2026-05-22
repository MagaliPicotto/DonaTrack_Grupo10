package personas;

import enums.TipoContacto;

public class Contacto {
    private TipoContacto tipo;
    private String detalle;
    
    public Contacto(TipoContacto tipo, String detalle) {
        this.tipo = tipo;
        this.detalle = detalle;
    }

    public TipoContacto getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoContacto tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return this.detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}