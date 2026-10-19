package com.tgn.tgnmovil.models.Medicion;

import java.math.BigDecimal;

import io.realm.RealmList;
import io.realm.RealmObject;

public class PlacaCabecera extends RealmObject {

    private String nroserie;
    private String ubicTec;
    private String descUbicTec;
    private String placa;
    private String descPlaca;
    private String macAddress;
    private String seccion;
    private String descSeccion;
    private String caja;
    private String descCaja;
    private String coorx;
    private String coory;
    private RealmList<PlacaDetalle> conexionado;


    public PlacaCabecera() {
    }

    public PlacaCabecera(String nroserie, String ubicTec, String descUbicTec, String placa, String descPlaca, String macAddress, String seccion, String descSeccion, String caja, String descCaja, String coorx, String coory, RealmList<PlacaDetalle> conexionado) {
        this.nroserie = nroserie;
        this.ubicTec = ubicTec;
        this.descUbicTec = descUbicTec;
        this.placa = placa;
        this.descPlaca = descPlaca;
        this.macAddress = macAddress;
        this.seccion = seccion;
        this.descSeccion = descSeccion;
        this.caja = caja;
        this.descCaja = descCaja;
        this.coorx = coorx;
        this.coory = coory;
        this.conexionado = conexionado;
    }

    public String getDescPlaca() {
        return descPlaca;
    }

    public void setDescPlaca(String descPlaca) {
        this.descPlaca = descPlaca;
    }

    public String getDescSeccion() {
        return descSeccion;
    }

    public void setDescSeccion(String descSeccion) {
        this.descSeccion = descSeccion;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getDescCaja() {
        return descCaja;
    }

    public void setDescCaja(String descCaja) {
        this.descCaja = descCaja;
    }

    public String getNroserie() {
        return nroserie;
    }

    public void setNroserie(String nroserie) {
        this.nroserie = nroserie;
    }

    public String getUbicTec() {
        return ubicTec;
    }

    public void setUbicTec(String ubicTec) {
        this.ubicTec = ubicTec;
    }

    public String getDescUbicTec() {
        return descUbicTec;
    }

    public void setDescUbicTec(String descUbicTec) {
        this.descUbicTec = descUbicTec;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCoorx() {
        return coorx;
    }

    public void setCoorx(BigDecimal coorx) {
        this.coorx = coorx.toString();
    }

    public String getCoory() {
        return coory;
    }

    public void setCoory(BigDecimal coory) {

        this.coory = coory.toString();
    }

    public RealmList<PlacaDetalle> getConexionado() {
        return conexionado;
    }

    public void setConexionado(RealmList<PlacaDetalle> conexionado) {
        this.conexionado = conexionado;
    }
}
