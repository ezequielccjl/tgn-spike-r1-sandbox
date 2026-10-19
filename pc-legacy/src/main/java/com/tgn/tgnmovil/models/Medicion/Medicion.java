package com.tgn.tgnmovil.models.Medicion;

import io.realm.RealmObject;

public class Medicion extends RealmObject {
    private String fechaTransm;
    private String horasTransm;
    private String placa;
    private String serie;
    private String macAdress;
    private String ubicTec;
    private String tipoMed;
    private String ot;
    private String obs;
    private String anON;
    private String anOFF;
    private String creus;
    private String crefe;
    private String mediciondet;
    private String detalle;

    public Medicion() {
    }

    public Medicion(String fechaTransm, String horasTransm, String placa, String serie, String macAdress, String ubicTec, String tipoMed, String ot, String obs, String anOn, String anOff, String creus, String crefe, String mediciondet) {
        this.fechaTransm = fechaTransm;
        this.horasTransm = horasTransm;
        this.placa = placa;
        this.serie = serie;
        this.macAdress = macAdress;
        this.ubicTec = ubicTec;
        this.tipoMed = tipoMed;
        this.ot = ot;
        this.obs = obs;
        this.anON = anOn;
        this.anOFF = anOff;
        this.creus = creus;
        this.crefe = crefe;
        this.mediciondet = mediciondet;
    }

    public String getFechaTransm() {
        return fechaTransm;
    }

    public void setFechaTransm(String fechaTransm) {
        this.fechaTransm = fechaTransm;
    }

    public String getHorasTransm() {
        return horasTransm;
    }

    public void setHorasTransm(String horasTransm) {
        this.horasTransm = horasTransm;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public String getUbicTec() {
        return ubicTec;
    }

    public void setUbicTec(String ubicTec) {
        this.ubicTec = ubicTec;
    }

    public String getTipoMed() {
        return tipoMed;
    }

    public void setTipoMed(String tipoMed) {
        this.tipoMed = tipoMed;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getAnON() {
        return anON;
    }

    public void setAnON(String anON) {
        this.anON = anON;
    }

    public String getAnOFF() {
        return anOFF;
    }

    public void setAnOFF(String anOFF) {
        this.anOFF = anOFF;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCreus() {
        return creus;
    }

    public void setCreus(String creus) {
        this.creus = creus;
    }

    public String getCrefe() {
        return crefe;
    }

    public void setCrefe(String crefe) {
        this.crefe = crefe;
    }

    public String getMediciondet() {
        return mediciondet;
    }

    public void setMediciondet(String mediciondet) {
        this.mediciondet = mediciondet;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
