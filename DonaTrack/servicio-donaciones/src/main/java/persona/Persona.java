package personas;

import java.util.ArrayList;
import java.util.List;

import enums.TipoDocumento;

public abstract class Persona {
    private List<Contacto> contactos;
    private Contacto contactoPredeterminado;
    private TipoDocumento tipoDocumento;
    private String documento;

    public Persona(List<Contacto> contactos, Contacto contactoPredeterminado, TipoDocumento tipoDocumento, String documento) {
        this.contactos = contactos != null ? contactos : new ArrayList<>();
        this.contactoPredeterminado = contactoPredeterminado;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    public List<Contacto> getContactos() {
        return this.contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public Contacto getContactoPredeterminado() {
        return this.contactoPredeterminado;
    }

    public void setContactoPredeterminado(Contacto contactoPredeterminado) {
        this.contactoPredeterminado = contactoPredeterminado;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void agregarContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

    public void eliminarContacto(Contacto contacto) {
        this.contactos.remove(contacto);
    }
}