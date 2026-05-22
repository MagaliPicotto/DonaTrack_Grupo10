package necesidades;

import java.util.ArrayList;
import java.util.List;

import categorias.Subcategoria;
import donaciones.SegmentoDonacion;

public class NecesidadRecurrente extends Necesidad {
    private List<PeriodoNecesidad> historialPeriodos;
    private PeriodoNecesidad periodoActual;

    public NecesidadRecurrente(Subcategoria subcategoria, String descripcion, float cantidad,
        List<PeriodoNecesidad> historialPeriodos, PeriodoNecesidad periodoActual) {
        super(subcategoria, descripcion, cantidad);
        this.historialPeriodos = historialPeriodos != null ? historialPeriodos : new ArrayList<>();
        this.periodoActual = periodoActual;
    }

    @Override
    public boolean satisfecha() {
        return this.periodoActual.satisfecha();
    }

    @Override
    public float cantidadCubierta() {
        return this.periodoActual.cantidadCubierta();
    }

    @Override
    public void asignarSegmento(SegmentoDonacion segmento) {
        this.periodoActual.getSegmentosPeriodo().add(segmento);
    }

    public boolean satisfechaPeriodo(PeriodoNecesidad periodo) {
        return periodo.satisfecha();
    }

    public void finalizarPeriodo() {
        this.historialPeriodos.add(this.periodoActual);

        this.periodoActual = new PeriodoNecesidad(
                this.periodoActual.calcularFinPeriodo().plusDays(1),
                this.periodoActual.getTipoPeriodo(),
                new ArrayList<>(),
                this.periodoActual.getCantidadSolicitada()
        );
    }

    public List<PeriodoNecesidad> getHistorialPeriodos() {
        return this.historialPeriodos;
    }

    public void setHistorialPeriodos(List<PeriodoNecesidad> historialPeriodos) {
        this.historialPeriodos = historialPeriodos;
    }

    public PeriodoNecesidad getPeriodoActual() {
        return this.periodoActual;
    }

    public void setPeriodoActual(PeriodoNecesidad periodoActual) {
        this.periodoActual = periodoActual;
    }
    
}
