package personas;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import enums.Genero;
import enums.TipoDocumento;

public class PersonaHumana extends Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Genero genero;
    private Direccion direccion;

    public PersonaHumana(List<Contacto> contactos, Contacto contactoPredeterminado, TipoDocumento tipoDocumento, String documento, 
        String nombre, String apellido, LocalDate fechaNacimiento, Genero genero, Direccion direccion) {
        super(contactos, contactoPredeterminado, tipoDocumento, documento);
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    

    public int calcularEdad() {
        if (fechaNacimiento == null) {
            return 0;
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

}