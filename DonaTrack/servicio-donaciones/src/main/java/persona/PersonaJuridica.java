package personas;

import java.util.ArrayList;
import java.util.List;

import enums.TipoDocumento;
import enums.TipoJuridico;

public class PersonaJuridica extends Persona {
    private String razonSocial;
    private List<PersonaHumana> representantes;
    private TipoJuridico tipo;
    private String rubro;

    public PersonaJuridica(List<Contacto> contactos, Contacto contactoPredeterminado, TipoDocumento tipoDocumento, String documento,
        String razonSocial, List<PersonaHumana> representantes, TipoJuridico tipo, String rubro) {
        super(contactos, contactoPredeterminado, tipoDocumento, documento);
        this.razonSocial = razonSocial;
        this.representantes = representantes != null ? representantes : new ArrayList<>();
        this.tipo = tipo;
        this.rubro = rubro;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<PersonaHumana> getRepresentantes() {
        return this.representantes;
    }

    public void setRepresentantes(List<PersonaHumana> representantes) {
        this.representantes = representantes;
    }

    public TipoJuridico getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoJuridico tipo) {
        this.tipo = tipo;
    }

    public String getRubro() {
        return this.rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public void agregarRepresentante(PersonaHumana representante) {
        this.representantes.add(representante);
    }

    public void eliminarRepresentante(PersonaHumana representante) {
        this.representantes.remove(representante);
    }
}