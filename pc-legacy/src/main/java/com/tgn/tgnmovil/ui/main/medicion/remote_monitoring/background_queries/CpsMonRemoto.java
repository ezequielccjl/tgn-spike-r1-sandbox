package com.tgn.tgnmovil.ui.main.medicion.remote_monitoring.background_queries;

import java.math.BigDecimal;

import io.realm.RealmObject;

public class CpsMonRemoto extends RealmObject {

    private String codEquipo;
    private String descEquipo;
    private String descSeccion;
    private String seccion;
    private String longitud;
    private String latitud;

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }
    public String getCodigoEquipo(){
        return codEquipo;
    }

    public void setDescEquipo(String descEquipo) {
        this.descEquipo = descEquipo;
    }

    public String getDescEquipo() {
        return descEquipo;
    }

    public void setDescSeccion(String descSeccion) {
        this.descSeccion = descSeccion;
    }

    public String getDescSeccion(){
        return descSeccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLongitud() {
        return longitud;
    }
}
