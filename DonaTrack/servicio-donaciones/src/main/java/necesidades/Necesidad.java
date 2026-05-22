package necesidades;

import categorias.Subcategoria;
import donaciones.SegmentoDonacion;

public abstract class Necesidad {
    protected Subcategoria subcategoria;
    protected String descripcion;

    public Necesidad(Subcategoria subcategoria, String descripcion) {
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
    }

    public Subcategoria getSubcategoria() {
        return this.subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract float cantidadCubierta();

    public abstract float getCantidadSolicitada();

    public abstract void asignarSegmento(SegmentoDonacion segmento);

    public abstract boolean satisfecha();
}
