package categorias;

import enums.Unidad;

public class Subcategoria {
    private String nombre;
    private Categoria categoria;
    private Unidad unidad;

    public Subcategoria(String nombre, Categoria categoria, Unidad unidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.unidad = unidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Unidad getUnidad() {
        return this.unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}

