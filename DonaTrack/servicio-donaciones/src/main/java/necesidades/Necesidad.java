package necesidades;

import categorias.Subcategoria;
import donaciones.SegmentoDonacion;

public abstract class Necesidad {
    protected Subcategoria subcategoria;
    protected String descripcion;
    protected float cantidad;

    public Necesidad(Subcategoria subcategoria, String descripcion, float cantidad) {
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
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

    public float getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public abstract float cantidadCubierta();

    public abstract void asignarSegmento(SegmentoDonacion segmento);

    public abstract boolean satisfecha();
}