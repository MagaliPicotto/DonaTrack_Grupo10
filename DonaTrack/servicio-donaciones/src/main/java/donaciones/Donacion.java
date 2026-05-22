package donaciones;

import java.util.ArrayList;
import java.util.List;

import bienes.Bien;
import necesidades.Necesidad;
import personas.Donante;
import personas.PersonaHumana;

public class Donacion {
    private Donante donante;
    private PersonaHumana representante;
    private PersonaHumana admin;
    private String descripcion;
    private List<Bien> bienes;
    private List<SegmentoDonacion> segmentaciones;

    public Donacion(Donante donante, PersonaHumana representante, PersonaHumana admin, String descripcion, List<Bien> bienes,
        List<SegmentoDonacion> segmentaciones) {
        this.donante = donante;
        this.representante = representante;
        this.admin = admin;
        this.descripcion = descripcion;
        this.bienes = bienes != null ? bienes : new ArrayList<>();
        this.segmentaciones = segmentaciones != null ? segmentaciones : new ArrayList<>();
    }

    public Donante getDonante() {
        return this.donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    public PersonaHumana getRepresentante() {
        return this.representante;
    }

    public void setRepresentante(PersonaHumana representante) {
        this.representante = representante;
    }

    public PersonaHumana getAdmin() {
        return this.admin;
    }

    public void setAdmin(PersonaHumana admin) {
        this.admin = admin;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Bien> getBienes() {
        return this.bienes;
    }

    public void setBienes(List<Bien> bienes) {
        this.bienes = bienes;
    }

    public List<SegmentoDonacion> getSegmentaciones() {
        return this.segmentaciones;
    }

    public void setSegmentaciones(List<SegmentoDonacion> segmentaciones) {
        this.segmentaciones = segmentaciones;
    }

    public void segmentar() {
        this.segmentaciones = new ArrayList<>();

        for (Bien bien : this.bienes) {
            CriterioSegmentacion criterioBien = bien.obtenerCriterioSegmentacion();
            SegmentoDonacion segmentoExistente = null;

            for (SegmentoDonacion segmento : this.segmentaciones) {
                if (segmento.getCriterio().coincideCon(criterioBien)) {
                    segmentoExistente = segmento;
                    break;
                }
            }

            if (segmentoExistente == null) {
                List<Bien> bienesSegmento = new ArrayList<>();
                bienesSegmento.add(bien);

                SegmentoDonacion nuevoSegmento = new SegmentoDonacion(
                    bienesSegmento,
                    this,
                    criterioBien,
                    null,
                    null,
                    null
                );
                this.segmentaciones.add(nuevoSegmento);
            } else {
                segmentoExistente.getBienes().add(bien);
            }
        }
    }

    public List<SegmentoDonacion> obtenerSegmentosNecesitados(Necesidad necesidad) {
        List<SegmentoDonacion> segmentosNecesitados = new ArrayList<>();

        for (SegmentoDonacion segmento : this.segmentaciones) {
            if (!segmento.asignado()
                && segmento.getCriterio().getSubcategoria().equals(necesidad.getSubcategoria())) {
                segmentosNecesitados.add(segmento);
            }
        }

        return segmentosNecesitados;
    }
}
