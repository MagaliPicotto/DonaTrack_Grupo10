package personas;

import necesidades.Necesidad;
import java.util.ArrayList;
import java.util.List;

public class EntidadBeneficiaria {
    private PersonaJuridica personaJuridica;
    private List<Necesidad> necesidades;

    public EntidadBeneficiaria(PersonaJuridica personaJuridica, List<Necesidad> necesidades) {
        this.personaJuridica = personaJuridica;
        this.necesidades = necesidades != null ? necesidades : new ArrayList<>();
    }

    public PersonaJuridica getPersonaJuridica() {
        return this.personaJuridica;
    }

    public void setPersonaJuridica(PersonaJuridica personaJuridica) {
        this.personaJuridica = personaJuridica;
    }

    public List<Necesidad> getNecesidades() {
        return this.necesidades;
    }

    public void setNecesidades(List<Necesidad> necesidades) {
        this.necesidades = necesidades;
    }

    public void registrarNecesidad(Necesidad necesidad){
        this.necesidades.add(necesidad);
    }

    public List<Necesidad> obtenerNecesidadesInsatisfechas() {
        List<Necesidad> necesidadesNoSatisfechas = new ArrayList<>();

        for (Necesidad necesidad : this.necesidades) {
            if (!necesidad.satisfecha()) {
                necesidadesNoSatisfechas.add(necesidad);
            }
        }

        return necesidadesNoSatisfechas;
    }
}

