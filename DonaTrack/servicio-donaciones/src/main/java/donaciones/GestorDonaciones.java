package donaciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import categorias.Categoria;
import enums.Genero;
import enums.TipoContacto;
import enums.TipoDocumento;
import enums.TipoJuridico;
import necesidades.Necesidad;
import personas.Contacto;
import personas.Direccion;
import personas.Donante;
import personas.EntidadBeneficiaria;
import personas.Persona;
import personas.PersonaHumana;
import personas.PersonaJuridica;

public class GestorDonaciones {
    private List<Donante> donantes;
    private List<EntidadBeneficiaria> entidadesBeneficiarias;
    private List<Categoria> categorias;

    public GestorDonaciones() {
        this.donantes = new ArrayList<>();
        this.entidadesBeneficiarias = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public void registrarDonante(Donante donante) {
        this.donantes.add(donante);
    }

    public void registrarEntidadBeneficiaria(EntidadBeneficiaria entidad) {
        this.entidadesBeneficiarias.add(entidad);
    }

    public void registrarDonacion(Donante donante, Donacion donacion) {
        donante.donar(donacion);
    }

    public void registrarNecesidad(EntidadBeneficiaria entidad, Necesidad necesidad) {
        entidad.registrarNecesidad(necesidad);
    }

    public List<SegmentoDonacion> obtenerSegmentosDisponibles(Necesidad necesidad) {
        List<SegmentoDonacion> segmentosDisponibles = new ArrayList<>();

        for (Donante donante : this.donantes) {
            for (Donacion donacion : donante.getDonaciones()) {
                segmentosDisponibles.addAll(donacion.obtenerSegmentosNecesitados(necesidad));
            }
        }

        return segmentosDisponibles;
    }

    public List<Necesidad> obtenerNecesidadesInsatisfechas() {
        List<Necesidad> necesidadesInsatisfechas = new ArrayList<>();

        for (EntidadBeneficiaria entidad : this.entidadesBeneficiarias) {
            necesidadesInsatisfechas.addAll(entidad.obtenerNecesidadesInsatisfechas());
        }

        return necesidadesInsatisfechas;
    }

    public void cubrirNecesidad(Necesidad necesidad) {
        for (SegmentoDonacion segmento : this.obtenerSegmentosDisponibles(necesidad)) {
            if (necesidad.satisfecha()) {
                break;
            }

            segmento.asignar(necesidad);
            necesidad.asignarSegmento(segmento);
        }
    }

    public void finalizarPeriodosNecesidadesVencidos() {
        LocalDate hoy = LocalDate.now();

        for (EntidadBeneficiaria entidad : this.entidadesBeneficiarias) {
            for (Necesidad necesidad : entidad.getNecesidades()) {
                if (necesidad instanceof necesidades.NecesidadRecurrente necesidadRecurrente) {
                    if (!necesidadRecurrente.getPeriodoActual().calcularFinPeriodo().isAfter(hoy)) {
                        necesidadRecurrente.finalizarPeriodo();
                    }
                }
            }
        }
    }

    public void importarDonantesCSV(String archivo) throws IOException {
        List<String> lineas = Files.readAllLines(Path.of(archivo));

        for (int i = 1; i < lineas.size(); i++) {
            String linea = lineas.get(i).trim();
            if (linea.isEmpty()) {
                continue;
            }

            String[] columnas = linea.split(",");
            if (columnas.length < 5) {
                continue;
            }

            String tipoPersona = columnas[0].trim().toUpperCase();
            TipoDocumento tipoDocumento = TipoDocumento.valueOf(columnas[1].trim().toUpperCase());
            String documento = columnas[2].trim();
            String nombreORazonSocial = columnas[3].trim();
            String email = columnas[4].trim();

            Contacto mail = new Contacto(TipoContacto.MAIL, email);
            List<Contacto> contactos = new ArrayList<>();
            contactos.add(mail);

            Persona persona;
            if ("HUMANA".equals(tipoPersona)) {
                String[] partesNombre = nombreORazonSocial.split(" ", 2);
                String nombre = partesNombre[0];
                String apellido = partesNombre.length > 1 ? partesNombre[1] : "";

                persona = new PersonaHumana(
                    contactos,
                    mail,
                    tipoDocumento,
                    documento,
                    nombre,
                    apellido,
                    LocalDate.now(),
                    Genero.OTRO,
                    new Direccion("", 0, "", "", "", "", "")
                );
            } else {
                persona = new PersonaJuridica(
                    contactos,
                    mail,
                    tipoDocumento,
                    documento,
                    nombreORazonSocial,
                    new ArrayList<>(),
                    TipoJuridico.ONG,
                    ""
                );
            }

            this.registrarDonante(new Donante(persona, new ArrayList<>()));
        }
    }

    public List<Donante> getDonantes() {
        return this.donantes;
    }

    public void setDonantes(List<Donante> donantes) {
        this.donantes = donantes;
    }

    public List<EntidadBeneficiaria> getEntidadesBeneficiarias() {
        return this.entidadesBeneficiarias;
    }

    public void setEntidadesBeneficiarias(List<EntidadBeneficiaria> entidadesBeneficiarias) {
        this.entidadesBeneficiarias = entidadesBeneficiarias;
    }

    public List<Categoria> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
