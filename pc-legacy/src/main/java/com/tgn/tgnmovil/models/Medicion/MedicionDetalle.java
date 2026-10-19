package com.tgn.tgnmovil.models.Medicion;

import io.realm.RealmObject;

public class MedicionDetalle extends RealmObject {
    private String fechaTransm;
    private String horasTransm;
    private String placa;
    private String borne;
    private String fechaMed;
    private String caneria;
    private String corrInd;
    private String meons;
    private String meoff;
    private String obs;
    private String status;
    private String coorx;
    private String coory;
    private String creus;
    private String crefe;

    public MedicionDetalle() {
    }

    public MedicionDetalle(String fechaTransm, String horasTransm, String placa, String borne, String fechaMed, String caneria, String corrInd, String meons, String meoff, String obs, String status, String coorx, String coory, String creus, String crefe) {
        this.fechaTransm = fechaTransm;
        this.horasTransm = horasTransm;
        this.placa = placa;
        this.borne = borne;
        this.fechaMed = fechaMed;
        this.caneria = caneria;
        this.corrInd = corrInd;
        this.meons = meons;
        this.meoff = meoff;
        this.obs = obs;
        this.status = status;
        this.coorx = coorx;
        this.coory = coory;
        this.creus = creus;
        this.crefe = crefe;
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

    public String getBorne() {
        return borne;
    }

    public void setBorne(String borne) {
        this.borne = borne;
    }

    public String getFechaMed() {
        return fechaMed;
    }

    public void setFechaMed(String fechaMed) {
        this.fechaMed = fechaMed;
    }

    public String getCaneria() {
        return caneria;
    }

    public void setCaneria(String caneria) {
        this.caneria = caneria;
    }

    public String getCorrInd() {
        return corrInd;
    }

    public void setCorrInd(String corrInd) {
        this.corrInd = corrInd;
    }

    public String getMeons() {
        return meons;
    }

    public void setMeons(String meons) {
        this.meons = meons;
    }

    public String getMeoff() {
        return meoff;
    }

    public void setMeoff(String meoff) {
        this.meoff = meoff;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCoorx() {
        return coorx;
    }

    public void setCoorx(String coorx) {
        this.coorx = coorx;
    }

    public String getCoory() {
        return coory;
    }

    public void setCoory(String coory) {
        this.coory = coory;
    }
}
