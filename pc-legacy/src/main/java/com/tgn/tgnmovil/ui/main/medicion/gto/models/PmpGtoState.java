package com.tgn.tgnmovil.ui.main.medicion.gto.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

// TODO use type ref, like in "inspeccion de obra" i think
public class PmpGtoState {

    public enum Valid {PENDING, COMPLETE, SEND, ERROR, ALL}

    public static final short PENDING = 0;
    public static final short COMPLETE = 1;
    public static final short SEND = 2;
    public static final short ERROR = 3;


    public static final String PENDING_STRING = "Pendiente de medición";

    public static final String COMPLETE_STRING = "Pendiente por enviar";

    public static final String SEND_STRING = "Completado";

    public static Valid getValidByName(@NonNull String state) {
        switch(state) {
            case PENDING_STRING:
                return Valid.PENDING;
            case COMPLETE_STRING:
                return Valid.COMPLETE;
            case SEND_STRING:
                return Valid.SEND;
            default:
                return Valid.ALL;
        }
    }

    public static short getCode(@NonNull Valid state) {
        switch(state) {
            case PENDING:
                return 0;
            case COMPLETE:
                return 1;
            case SEND:
                return 2;
            case ERROR:
                return 3;
            default:
                return -1;
        }
    }

    public static int getPosition(Valid state) {
        return getCode(state) + 1;
    }

    public static boolean mustFiltrate(Valid state) {
        return state == Valid.PENDING || state == Valid.COMPLETE || state == Valid.SEND;
    }

    @NonNull
    public static String toString(@NonNull Valid state) {
        switch(state) {
            case COMPLETE:
                return COMPLETE_STRING;
            case SEND:
                return SEND_STRING;
            case PENDING:
                return PENDING_STRING;
            default:
                return "Todos";
        }
    }

    @NonNull
    public static ArrayList<String> getAll() {
        ArrayList<String> estados = new ArrayList<>();
        estados.add("Todos");
        estados.add(PENDING_STRING);
        estados.add(COMPLETE_STRING);
        estados.add(SEND_STRING);
        return estados;
    }
}
