package bienes;

import categorias.Subcategoria;
import donaciones.CriterioSegmentacion;

public class Bien {
    protected Subcategoria subcategoria;
    protected String descripcion;
    protected float cantidad;
    protected String rutaFoto;

    public Bien(Subcategoria subcategoria, String descripcion, float cantidad, String rutaFoto) {
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.rutaFoto = rutaFoto;
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

    public String getRutaFota() {
        return this.rutaFoto;
    }

    public void setRutaFota(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public CriterioSegmentacion obtenerCriterioSegmentacion() {
        return new CriterioSegmentacion(this.subcategoria, null, null);
    }
}

