package com.tgn.tgnmovil.ui.main.medicion.gto.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PmpGtoObs extends RealmObject {

    @PrimaryKey
    private String code;
    private String obs;
    private boolean inRange;
    private boolean active;

    public PmpGtoObs() {}

    public PmpGtoObs(String obs, String code) {
        this.obs = obs;
        this.code = code;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isInRange() {
        return inRange;
    }

    public void setInRange(boolean inRange) {
        this.inRange = inRange;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
