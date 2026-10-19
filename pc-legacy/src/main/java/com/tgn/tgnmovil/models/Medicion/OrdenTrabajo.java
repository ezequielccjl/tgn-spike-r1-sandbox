package com.tgn.tgnmovil.models.Medicion;

import io.realm.RealmObject;

public class OrdenTrabajo extends RealmObject {

    private String ot;
    private String descOt;
    private String seccion;
    private String clase;
    private String ubicTec;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(String ot, String descOt, String seccion, String clase, String ubicTec) {
        this.ot = ot;
        this.descOt = descOt;
        this.seccion = seccion;
        this.clase = clase;
        this.ubicTec = ubicTec;
    }

    public String getOt() {
        return ot;
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getUbicTec() {
        return ubicTec;
    }

    public void setUbicTec(String ubicTec) {
        this.ubicTec = ubicTec;
    }
}
