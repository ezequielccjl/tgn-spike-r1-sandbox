package com.tgn.tgnmovil.ui.main.medicion.gto.models;

import androidx.annotation.Nullable;
import io.realm.RealmObject;

public class OrderPmpGto extends RealmObject {

    private String ot;
    private String descOt;
    private String seccion;
    private String actividad;
    private String clase;
    private String medicion;
    private String fechaLiberacion;
    private String ubicTecnica;

    public OrderPmpGto() {}

    public String getOt() {
        return  this.ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getDescOt() {
        return descOt;
    }

    public void setDescOt(String descOt) {
        this.descOt = descOt;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void setMedicion(String medicion) {
        this.medicion = medicion;
    }

    public MeasurePmpGtoType.Type getMedicion() {
        return MeasurePmpGtoType.Type.valueOf(this.medicion);
    }

    public String getMedicionType() {
        return MeasurePmpGtoType.Type.valueOf(this.medicion).toString();
    }

    @Nullable
    public String getFechaLiberacion() {
        return fechaLiberacion;
    }

    public void setFechaLiberacion(String fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
    }

    public String getUbicTecnica() {
        return ubicTecnica;
    }

    public void setUbicTecnica(String ubicTecnica) {
        this.ubicTecnica = ubicTecnica;
    }
}

