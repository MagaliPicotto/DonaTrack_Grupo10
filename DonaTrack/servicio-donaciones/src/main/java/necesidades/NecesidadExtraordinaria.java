package necesidades;

import java.util.ArrayList;
import java.util.List;

import categorias.Subcategoria;
import donaciones.SegmentoDonacion;

public class NecesidadExtraordinaria extends Necesidad {
    private List<SegmentoDonacion> segmentos;
    private String situacion;
    private float cantidadSolicitada;

    public NecesidadExtraordinaria(Subcategoria subcategoria, String descripcion, float cantidadSolicitada,
        List<SegmentoDonacion> segmentos, String situacion) {
        super(subcategoria, descripcion);
        this.segmentos = segmentos != null ? segmentos : new ArrayList<>();
        this.situacion = situacion;
        this.cantidadSolicitada = cantidadSolicitada;
    }

    @Override
    public boolean satisfecha() {
        return cantidadCubierta() >= this.cantidadSolicitada;
    }

    @Override
    public float cantidadCubierta() {
        return (float) this.segmentos.stream().mapToDouble(SegmentoDonacion::cantidadTotal).sum();
    }

    @Override
    public float getCantidadSolicitada() {
        return this.cantidadSolicitada;
    }

    @Override
    public void asignarSegmento(SegmentoDonacion segmento) {
        this.segmentos.add(segmento);
    }

    public List<SegmentoDonacion> getSegmentos() {
        return this.segmentos;
    }

    public void setSegmentos(List<SegmentoDonacion> segmentos) {
        this.segmentos = segmentos;
    }

    public String getSituacion() {
        return this.situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public void setCantidadSolicitada(float cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }
}
