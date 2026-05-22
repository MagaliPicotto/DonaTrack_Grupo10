package necesidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import donaciones.SegmentoDonacion;
import enums.TipoPeriodo;

public class PeriodoNecesidad {
    private LocalDate inicioPeriodo;
    private TipoPeriodo tipoPeriodo;
    private List<SegmentoDonacion> segmentosPeriodo;
    private float cantidadSolicitada;

    public PeriodoNecesidad(LocalDate inicioPeriodo, TipoPeriodo tipoPeriodo, List<SegmentoDonacion> segmentosPeriodo,
        float cantidadSolicitada) {
        this.inicioPeriodo = inicioPeriodo;
        this.tipoPeriodo = tipoPeriodo;
        this.segmentosPeriodo = segmentosPeriodo != null ? segmentosPeriodo : new ArrayList<>();
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public LocalDate getInicioPeriodo() {
        return this.inicioPeriodo;
    }

    public void setInicioPeriodo(LocalDate inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public TipoPeriodo getTipoPeriodo() {
        return this.tipoPeriodo;
    }

    public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public List<SegmentoDonacion> getSegmentosPeriodo() {
        return this.segmentosPeriodo;
    }

    public void setSegmentosPeriodo(List<SegmentoDonacion> segmentosPeriodo) {
        this.segmentosPeriodo = segmentosPeriodo;
    }

    public float getCantidadSolicitada() {
        return this.cantidadSolicitada;
    }

    public void setCantidadSolicitada(float cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public float cantidadCubierta() {
        return (float) this.segmentosPeriodo.stream()
                .mapToDouble(SegmentoDonacion::cantidadTotal)
                .sum();
    }

    public boolean satisfecha() {
        return this.cantidadCubierta() >= this.cantidadSolicitada;
    }

    public LocalDate calcularFinPeriodo() {
        return switch (this.tipoPeriodo) {
            case SEMANAL -> this.inicioPeriodo.plusWeeks(1);
            case MENSUAL -> this.inicioPeriodo.plusMonths(1);
            case ANUAL -> this.inicioPeriodo.plusYears(1);
        };
    }
}
