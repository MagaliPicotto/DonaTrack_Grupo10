package donaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bienes.Bien;
import enums.EstadoSegmento;
import necesidades.Necesidad;

public class SegmentoDonacion {
    private List<Bien> bienes;
    private Donacion donacion;
    private CriterioSegmentacion criterio;
    private Necesidad necesidad;
    private LocalDate fechaAsignacion;
    private EstadoSegmento estado;

    public SegmentoDonacion(List<Bien> bienes, Donacion donacion, CriterioSegmentacion criterio, Necesidad necesidad, LocalDate fechaAsignacion, EstadoSegmento estado) {
        this.bienes = bienes != null ? bienes : new ArrayList<>();
        this.donacion = donacion;
        this.criterio = criterio;
        this.necesidad = necesidad;
        this.fechaAsignacion = fechaAsignacion;
        this.estado = estado != null ? estado : EstadoSegmento.DISPONIBLE;
    }

    public List<Bien> getBienes() {
        return this.bienes;
    }

    public void setBienes(List<Bien> bienes) {
        this.bienes = bienes;
    }

    public Donacion getDonacion() {
        return this.donacion;
    }

    public void setDonacion(Donacion donacion) {
        this.donacion = donacion;
    }

    public CriterioSegmentacion getCriterio() {
        return this.criterio;
    }

    public void setCriterio(CriterioSegmentacion criterio) {
        this.criterio = criterio;
    }

    public Necesidad getNecesidad() {
        return this.necesidad;
    }

    public void setNecesidad(Necesidad necesidad) {
        this.necesidad = necesidad;
    }

    public LocalDate getFechaAsignacion() {
        return this.fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public EstadoSegmento getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoSegmento estado) {
        this.estado = estado;
    }

    public float cantidadTotal() {
        return (float) bienes.stream().mapToDouble(bien -> bien.getCantidad()).sum();
    }

    public boolean asignado() {
        return this.estado != EstadoSegmento.DISPONIBLE;
    }

    public void asignar(Necesidad necesidad) {
        this.necesidad = necesidad;
        this.fechaAsignacion = LocalDate.now();
        this.estado = EstadoSegmento.ASIGNADO;
    }
}