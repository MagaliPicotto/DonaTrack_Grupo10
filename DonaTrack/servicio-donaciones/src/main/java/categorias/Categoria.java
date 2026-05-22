package categorias;

import enums.TipoBien;

public class Categoria {
    private String nombre;
    private TipoBien tipoBien;

    public Categoria(String nombre, TipoBien tipoBien) {
        this.nombre = nombre;
        this.tipoBien = tipoBien;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoBien getTipoBien() {
        return this.tipoBien;
    }

    public void setTipoBien(TipoBien tipoBien) {
        this.tipoBien = tipoBien;
    }
}

