package com.tgn.tgnmovil.ui.main.medicion.gto.models;

import java.math.BigDecimal;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

import io.realm.RealmObject;

public class PmpGto extends RealmObject {

    private short State;
    private String Id;
    private String orden;
    private String testigo;
    private String eqClass;
    private String equipo;
    private String descEquipo;
    private String seccion;
    private String descSec;
    private String sistema;
    private String descSist;
    private String serie;
    private String tipo;
    private String tramo;
    private String probeta;
    private String conexion;
    private String mojon;
    private String metros;
    private String latitud;
    private String longitud;
    private boolean inMyRadious;
    private String NuPmpGto;
    private String descripcion;
    private String InPmp;
    private String mojonMetro;
    private double distance;
    private boolean hasAmper;
    private boolean hasVolts;
    private boolean hasPotEq;
    private boolean hasCanioCamisa;

    public PmpGto() {
        this.State =  PmpGtoState.PENDING;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getId() {
        return  this.Id;
    }

    public String getTestigo() {
        return testigo;
    }

    public String getNuPmp() {
        return NuPmpGto;
    }

    public void setNuPmpGto(String nuPMP) {
        this.NuPmpGto = nuPMP;
    }

    public void setTestigo(String testigo) {
        this.testigo = testigo;
    }

    public void setInPmp(String inPMP) {
        this.InPmp = inPMP;
    }

    public String getInPmp() {
         return this.InPmp;
    }

    public String getEquipo() {
        return equipo.replaceFirst("^0+(?!$)", "");
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setDescEqui(String desEqui) {
        this.descEquipo = desEqui;
    }

    public boolean hasEquip() {
        return !descEquipo.isEmpty() && !equipo.isEmpty();
    }

    public String getFormattedEquipAndDesc() {
        return String.format("%s - %s", getEquipo(), descEquipo);
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getDescSec() {
        return descSec;
    }

    public void setDescSec(String descSec) {
        this.descSec = descSec;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getDescSist() {
        return descSist;
    }

    public void setDescSist(String descSist) {
        this.descSist = descSist;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProbeta() {
        return probeta;
    }

    public void setProbeta(String probeta) {
        this.probeta = probeta;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getMojon() {
        return mojon;
    }

    public void setMojon(String mojon) {
        this.mojon = mojon;
    }

    public String getMetros() {
        return metros;
    }

    public String getValidMetros() {
        int indexDot = metros.indexOf(".");
        return indexDot < 0 ? metros : metros.substring(0, indexDot);
    }

    public void setMetros(@NonNull BigDecimal metros) {
        this.metros = metros.toString();
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(@NonNull BigDecimal latitud) {
        this.latitud = latitud.toString();
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(@NonNull BigDecimal longitud) {
        this.longitud = longitud.toString();
    }

    public short getState() {
        return State;
    }

    public void setState(short state) {
        this.State = state;
    }

    public void setComplete() {
        this.State = PmpGtoState.COMPLETE;
    }

    public void setSend() {
        this.State = PmpGtoState.SEND;
    }

    public boolean isInMyRadious() {
        return inMyRadious;
    }

    public void setInMyRadious(boolean inMyRadious) {
        this.inMyRadious = inMyRadious;
    }

    public void setMojonMetro(String mojonMet) {
        this.mojonMetro = mojonMet;
    }

    public String getMojonMetros()
    {
        return this.mojonMetro;
    }

    public String getNroPMP() {
        return  this.NuPmpGto;
    }

    public void setId() {
        this.Id = this.orden + this.NuPmpGto + this.InPmp;
    }

    @NonNull
    @Contract(pure = true)
    public static String generateId(String id, String nuPmp, String inPmp){
        return id + nuPmp + inPmp;
    }

    public void setNumPmp(String nuPMP) {
        this.NuPmpGto = nuPMP;
    }

    public int getPotOff() {
        return  0;
    }

    public int getPotOn() {
        return  0;
    }

    public int getComment() {
        return  0;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return this.distance;
    }

    public boolean hasAmper() {
        return hasAmper;
    }

    public void setHasAmper(boolean hasAmper) {
        this.hasAmper = hasAmper;
    }

    public boolean hasVolts() {
        return hasVolts;
    }

    public void setHasVolts(boolean hasVolts) {
        this.hasVolts = hasVolts;
    }

    public boolean hasPotEq() {
        return hasPotEq;
    }

    public void setHasPotEq(boolean hasPotEq) {
        this.hasPotEq = hasPotEq;
    }

    public String getEqClass() {
        return eqClass;
    }

    public void setEqClass(String eqClass) {
        this.eqClass = eqClass;
    }

    public boolean hasCanioCamisa() {
        return hasCanioCamisa;
    }

    public void setHasCanioCamisa(boolean hasCanioCamisa) {
        this.hasCanioCamisa = hasCanioCamisa;
    }
}


