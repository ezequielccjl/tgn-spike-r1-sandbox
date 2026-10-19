package com.tgn.tgnmovil.ui.main.medicion.remote_monitoring.models;

import io.realm.RealmObject;

public class CPSSatoCan extends RealmObject {

    private String idSolicitud;
    private String codEquipo;
    private String moduloActivado;
    private String sistema;
    private String fecMedicion;
    private String horaMedicion;
    private String modulo;

    private String codTramo;
    private String modoC;
    private String volt;
    private String amper;
    private String potOn;
    private String potOff;
    private String horas;
    private String alarmCanalPot;

    public CPSSatoCan(String modulo, String moduloActivado, String sistema, String modoC, String volt, String amper, String alarmCanalPot, String potOn, String potOff, String horas) {
        this.modulo = modulo;
        this.moduloActivado = moduloActivado;
        this.sistema = sistema;
        this.modoC = modoC;
        this.volt = volt;
        this.amper = amper;
        this.alarmCanalPot = alarmCanalPot;
        this.potOn = potOn;
        this.potOff = potOff;
        this.horas = horas;
    }

    public CPSSatoCan() {

    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setFecMedicion(String fecMedicion) {
        this.fecMedicion = fecMedicion;
    }

    public String getFecMedicion() {
        return fecMedicion;
    }

    public void setModuloActivado(String moduloActivado) {
        this.moduloActivado = moduloActivado;
    }

    public String getModuloActivado() {
        return moduloActivado;
    }

    public void setHoraMedicion(String horaMedicion) {
        this.horaMedicion = horaMedicion;
    }

    public String getHoraMedicion() {
        return horaMedicion;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getSistema() {
        return sistema;
    }

    public void setCodTramo(String codTramo) {
        this.codTramo = codTramo;
    }

    public String getCodTramo() {
        return codTramo;
    }

    public void setModoC(String modoC) {
        this.modoC = modoC;
    }

    public String getModoC() {
        return modoC;
    }

    public void setVolt(String volt) {
        this.volt = volt;
    }

    public String getVolt() {
        return volt;
    }

    public void setAmper(String amper) {
        this.amper = amper;
    }

    public String getAmper() {
        return amper;
    }

    public void setPotOn(String potOn) {
        this.potOn = potOn;
    }

    public String getPotOn() {
        return potOn;
    }

    public void setPotOff(String potOff) {
        this.potOff = potOff;
    }

    public String getPotOff() {
        return potOff;
    }

    public void setAlarmCanalPot(String alarmCanalPot) {
        this.alarmCanalPot = alarmCanalPot;
    }

    public String getAlarmCanalPot() {
        return alarmCanalPot;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getHoras() {
        return horas;
    }
}
