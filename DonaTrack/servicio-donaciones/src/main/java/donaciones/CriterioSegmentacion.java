package donaciones;

import java.time.LocalDate;
import java.util.Objects;

import categorias.Subcategoria;

public class CriterioSegmentacion {
    private Subcategoria subcategoria;
    private LocalDate fechaVencimiento;
    private Boolean usado;

    public CriterioSegmentacion(Subcategoria subcategoria, LocalDate fechaVencimiento, Boolean usado) {
        this.subcategoria = subcategoria;
        this.fechaVencimiento = fechaVencimiento;
        this.usado = usado;
    }

    public Subcategoria getSubcategoria() {
        return this.subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public LocalDate getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Boolean getUsado() {
        return this.usado;
    }

    public void setUsado(Boolean usado) {
        this.usado = usado;
    }

    public boolean coincideCon(CriterioSegmentacion criterio) {
        return Objects.equals(this.subcategoria, criterio.subcategoria)
            && Objects.equals(this.fechaVencimiento, criterio.fechaVencimiento)
            && Objects.equals(this.usado, criterio.usado);
    }
}