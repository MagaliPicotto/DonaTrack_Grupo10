package personas;

import donaciones.Donacion;
import java.util.ArrayList;
import java.util.List;

public class Donante {
    private Persona persona;
    private List<Donacion> donaciones;

    public Donante(Persona persona, List<Donacion> donaciones) {
        this.persona = persona;
        this.donaciones = donaciones != null ? donaciones : new ArrayList<>();
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Donacion> getDonaciones() {
        return this.donaciones;
    }

    public void setDonaciones(List<Donacion> donaciones) {
        this.donaciones = donaciones;
    }

    public void donar(Donacion donacion) {
        this.donaciones.add(donacion);
    }
}

