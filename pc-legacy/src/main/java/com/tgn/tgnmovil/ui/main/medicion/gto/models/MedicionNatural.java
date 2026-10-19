package com.tgn.tgnmovil.ui.main.medicion.gto.models;

import java.util.Date;

import androidx.annotation.NonNull;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MedicionNatural extends RealmObject implements IMeasurePmpGto {

    // read only
    @PrimaryKey
    private String id;
    private String orden;
    private String nuPmp;
    private String inPmp;

    // read & write
    private String potNatural;
    private String potAc;

    private String amper;
    private String volts;
    private String potOnEq;
    private String potOffEq;
    private String potCcOffExtraEq;
    private String potAcOffExtraEq;

    private String comment;
    private Date date;
    private String obsCode;

    // error on pmp-gto location
    private boolean notifyLocationError;

    public MedicionNatural() {}

    public MedicionNatural(String orden, String nuPmp, String inPmp) {
        this.orden = orden;
        this.nuPmp = nuPmp;
        this.inPmp = inPmp;
        this.id = this.orden + this.nuPmp + this.inPmp;
        notifyLocationError = false;
    }

    @Override
    public void save(@NonNull Realm realm) {
        realm.beginTransaction();
        realm.insertOrUpdate(this);
        realm.commitTransaction();
    }

    @Override
    public IMeasurePmpGto duplicate() {
        MedicionNatural newMedicion = new MedicionNatural(orden, nuPmp, inPmp);
        newMedicion.setPotNatural(potNatural);
        newMedicion.setPotAc(potAc);
        newMedicion.setAmper(amper);
        newMedicion.setVolts(volts);
        newMedicion.setPotOnEq(potOnEq);
        newMedicion.setPotOffEq(potOffEq);
        newMedicion.setPotCcOffExtraEq(potCcOffExtraEq);
        newMedicion.setPotAcOffExtraEq(potAcOffExtraEq);
        newMedicion.setComment(comment);
        newMedicion.setObsCode(obsCode);
        newMedicion.setDate(date);
        newMedicion.setNotifyLocationError(notifyLocationError);
        return newMedicion;
    }

    // read only
    public String getId() {
        return id;
    }
    public String getOrden() {
        return orden;
    }
    public String getNuPmp() {
        return nuPmp;
    }
    public String getInPmp() {
        return inPmp;
    }
    @Override
    public MeasurePmpGtoType.Type getType() {
        return MeasurePmpGtoType.Type.NATURAL;
    }

    // read & write

    // Pot. natural
    @Override
    public boolean hasPotNatural() {
        return true;
    }

    @Override
    public String getPotNatural() {
        return potNatural;
    }

    @Override
    public void setPotNatural(String potNatural) {
        this.potNatural = potNatural;
    }

    // Pot. ON
    @Override
    public boolean hasPotOn() {
        return false;
    }

    @Override
    public String getPotOn() {
        return null;
    }

    @Override
    public void setPotOn(String potOn) {}

    // Pot. OFF
    @Override
    public boolean hasPotOff() {
        return false;
    }

    @Override
    public String getPotOff() {
        return null;
    }

    @Override
    public void setPotOff(String potOff) {}

    // Pot. AC
    @Override
    public String getPotAc() {
        return potAc;
    }

    @Override
    public void setPotAc(String potAc) {
        this.potAc = potAc;
    }

    // Equipment
    @Override
    public String getAmper() {
        return amper;
    }

    @Override
    public void setAmper(String amper) {
        this.amper = amper;
    }

    @Override
    public String getVolts() {
        return volts;
    }

    @Override
    public void setVolts(String volts) {
        this.volts = volts;
    }

    @Override
    public String getPotOnEq() {
        return potOnEq;
    }

    @Override
    public void setPotOnEq(String potOnEq) {
        this.potOnEq = potOnEq;
    }

    @Override
    public String getPotOffEq() {
        return potOffEq;
    }

    @Override
    public void setPotOffEq(String potOffEq) {
        this.potOffEq = potOffEq;
    }

    @Override
    public String getPotCcOffExtraEq() {
        return potCcOffExtraEq;
    }

    @Override
    public void setPotCcOffExtraEq(String potCcOffExtraEq) {
        this.potCcOffExtraEq = potCcOffExtraEq;
    }

    @Override
    public String getPotAcOffExtraEq() {
        return potAcOffExtraEq;
    }

    @Override
    public void setPotAcOffExtraEq(String potAcOffExtraEq) {
        this.potAcOffExtraEq = potAcOffExtraEq;
    }

    @NonNull
    @Override
    public String getComment() {
        return comment == null ? "" : comment;
    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @NonNull
    @Override
    public String getObsCode() {
        return obsCode == null ? "" : obsCode;
    }

    @Override
    public void setObsCode(String obsCode) {
        this.obsCode = obsCode;
    }

    @Override
    public boolean notifyLocationError() {
        return notifyLocationError;
    }

    @Override
    public void setNotifyLocationError(boolean notifyLocationError) {
        this.notifyLocationError = notifyLocationError;
    }
}
