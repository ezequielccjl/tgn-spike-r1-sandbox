package com.tgn.tgnmovil.models.Medicion;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FotoMedicion extends RealmObject {

    @PrimaryKey private String id;
    private String fechaTransm;
    private String horasTransm;
    private String placa;
    private String foto;
    private String nombreArchivo;
    private String mimeType;

    public FotoMedicion() {
    }

    public FotoMedicion(String fechaTransm, String horasTransm, String placa, String foto, String nombreArchivo, String mimeType) {
        this.fechaTransm = fechaTransm;
        this.horasTransm = horasTransm;
        this.placa = placa;
        this.foto = foto;
        this.nombreArchivo = nombreArchivo;
        this.mimeType = mimeType;
        this.id = placa + nombreArchivo;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
