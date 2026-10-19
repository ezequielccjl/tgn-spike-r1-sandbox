package com.tgn.tgnmovil.ui.main.medicion.gto.models;

import java.util.Date;

import androidx.annotation.NonNull;
import io.realm.Realm;

public interface IMeasurePmpGto {

    MeasurePmpGtoType.Type getType();
    void save(@NonNull Realm realm);
    IMeasurePmpGto duplicate();

    String getId();

    boolean hasPotNatural();
    String getPotNatural();
    void setPotNatural(String measure);

    boolean hasPotOn();
    String getPotOn();
    void setPotOn(String measure);

    boolean hasPotOff();
    String getPotOff();
    void setPotOff(String measure);

    String getPotAc();
    void setPotAc(String measure);

    // equipment
    String getAmper();
    void setAmper(String amper);

    String getVolts();
    void setVolts(String volts);

    String getPotOnEq();
    void setPotOnEq(String potOnEq);

    String getPotOffEq();
    void setPotOffEq(String potOffEq);

    String getPotCcOffExtraEq();
    void setPotCcOffExtraEq(String potCcOffExtraEq);

    String getPotAcOffExtraEq();
    void setPotAcOffExtraEq(String potAcOffExtraEq);

    // comment
    @NonNull String getComment();
    void setComment(String comment);

    // date
    Date getDate();
    void setDate(Date date);

    // obs
    @NonNull String getObsCode();
    void setObsCode(String obsCode);

    // has to notify location error
    boolean notifyLocationError();
    void setNotifyLocationError(boolean notifyLocationError);
}

