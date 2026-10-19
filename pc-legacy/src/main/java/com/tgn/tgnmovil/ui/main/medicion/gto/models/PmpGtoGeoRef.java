package com.tgn.tgnmovil.ui.main.medicion.gto.models;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PmpGtoGeoRef extends RealmObject {

    // read only
    @PrimaryKey
    private String id;
    private String order;
    private String nuPmp;
    private String inPmp;

    // read & write
    private double latitude;
    private double longitude;
    private double accuracy;

    public PmpGtoGeoRef() {}

    public PmpGtoGeoRef(String order, String nuPmp, String inPmp) {
        this.order = order;
        this.nuPmp = nuPmp;
        this.inPmp = inPmp;
        this.id = this.order + this.nuPmp + this.inPmp;
    }

    @NonNull
    public static String getId(@NonNull PmpGto pmpGto) {
        return pmpGto.getOrden() + pmpGto.getNuPmp() + pmpGto.getInPmp();
    }

    // read only
    public String getId() {
        return id;
    }
    public String getOrder() {
        return order;
    }
    public String getNuPmp() {
        return nuPmp;
    }
    public String getInPmp() {
        return inPmp;
    }

    // read & write
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
