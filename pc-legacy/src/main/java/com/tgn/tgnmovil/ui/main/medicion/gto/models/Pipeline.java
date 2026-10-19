package com.tgn.tgnmovil.ui.main.medicion.gto.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import io.realm.RealmObject;

public class Pipeline extends RealmObject {

    private String polylineOptions;
    private String points;

    public Pipeline() {}

    public Pipeline detachedCopy() {
        Pipeline pipeline = new Pipeline();
        pipeline.polylineOptions = this.polylineOptions;
        pipeline.points = this.points;
        return pipeline;
    }

    public PolylineOptions getPolylineOptions() {
        Gson gson = new Gson();
        PolylineOptions line = gson.fromJson(this.polylineOptions, PolylineOptions.class);
        line.addAll(getPoints());
        return line;
    }

    public void setPolylineOptions(PolylineOptions polylineOptions) {
        Gson gson = new Gson();
        this.polylineOptions = gson.toJson(polylineOptions);
    }

    private List<LatLng> getPoints() {
        Gson gson = new Gson();
        return gson.fromJson(this.points, new TypeToken<List<LatLng>>(){}.getType());
    }

    public void setPoints(List<LatLng> points) {
        Gson gson = new Gson();
        this.points = gson.toJson(points);
    }
}