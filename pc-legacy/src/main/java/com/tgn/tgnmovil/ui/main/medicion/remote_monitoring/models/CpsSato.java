package com.tgn.tgnmovil.ui.main.medicion.remote_monitoring.models;

import io.realm.RealmObject;

public class CpsSato extends RealmObject {

    private String idCom;
    private String tensionACE;
    private String tensionACT;
    private String tempTrafo;
    private String ensayoSat;
    private String ensayoSin;
    private String ensayoHab;
    private String ensayoEsp;

    public void setIdCom(String idCom) {
        this.idCom = idCom;
    }

    public String getIdCom() {
        return idCom;
    }

    public void setTensionACE(String tensionACE) {
        this.tensionACE = tensionACE;
    }

    public String getTensionACE() {
        return tensionACE;
    }

    public void setTensionACT(String tensionACT) {
        this.tensionACT = tensionACT;
    }

    public String getTensionACT() {
        return tensionACT;
    }

    public void setTempTrafo(String tempTrafo) {
        this.tempTrafo = tempTrafo;
    }

    public String getTempTrafo() {
        return tempTrafo;
    }

    public void setEnsayoSat(String ensayoSat) {
        this.ensayoSat = ensayoSat;
    }

    public String getEnsayoSat() {
        return ensayoSat;
    }

    public void setEnsayoSin(String ensayoSin) {
        this.ensayoSin = ensayoSin;
    }

    public String getEnsayoSin() {
        return ensayoSin;
    }

    public void setEnsayoHab(String ensayoHab) {
        this.ensayoHab = ensayoHab;
    }

    public String getEnsayoHab() {
        return ensayoHab;
    }

    public void setEnsayoEsp(String ensayoEsp) {
        this.ensayoEsp = ensayoEsp;
    }

    public String getEnsayoEsp() {
        return ensayoEsp;
    }
}
