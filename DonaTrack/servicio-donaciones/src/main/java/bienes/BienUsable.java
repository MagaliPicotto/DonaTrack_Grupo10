package bienes;

import categorias.Subcategoria;
import donaciones.CriterioSegmentacion;

public class BienUsable extends Bien {
    private boolean usado;

    public BienUsable(Subcategoria subcategoria, String descripcion, float cantidad, String rutaFoto, boolean usado) {
        super(subcategoria, descripcion, cantidad, rutaFoto);
        this.usado = usado;
    }

    @Override
    public CriterioSegmentacion obtenerCriterioSegmentacion() {
        return new CriterioSegmentacion(this.subcategoria, null, usado);
    }

    public boolean getUsado() {
        return this.usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
}

