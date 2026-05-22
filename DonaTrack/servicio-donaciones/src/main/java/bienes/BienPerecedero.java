package bienes;

import java.time.LocalDate;

import categorias.Subcategoria;
import donaciones.CriterioSegmentacion;

public class BienPerecedero extends Bien {
    private LocalDate fechaVencimiento;

    public BienPerecedero(Subcategoria subcategoria, String descripcion, float cantidad, String rutaFoto, LocalDate fechaVencimiento) {
        super(subcategoria, descripcion, cantidad, rutaFoto);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public CriterioSegmentacion obtenerCriterioSegmentacion() {
        return new CriterioSegmentacion(this.subcategoria, fechaVencimiento, null);
    }

    public LocalDate getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}

