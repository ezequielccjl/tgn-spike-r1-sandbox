package com.tgn.tgnmovil.models.Medicion;

import io.realm.RealmObject;

public class PlacaDetalle extends RealmObject {

    private String placa;
    private String borne;
    private String tipo;
    private String status;
    private String caneria;
    private String descCane;

    public PlacaDetalle() {
    }

    public PlacaDetalle(String placa, String borne, String tipo, String status, String caneria, String descCane) {
        this.placa = placa;
        this.borne = borne;
        this.tipo = tipo;
        this.status = status;
        this.caneria = caneria;
        this.descCane = descCane;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getBorne() {
        return borne;
    }

    public void setBorne(String borne) {
        this.borne = borne;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaneria() {
        return caneria;
    }

    public void setCaneria(String caneria) {
        this.caneria = caneria;
    }

    public String getDescCane() {
        return descCane;
    }

    public void setDescCane(String descCane) {
        this.descCane = descCane;
    }

    public String detailToString() {
        return this.placa + ", " +
        this.borne + ", " +
        this.tipo + ", " +
        this.status + ", " +
        this.caneria + ", " +
        this.descCane;
    }
}
