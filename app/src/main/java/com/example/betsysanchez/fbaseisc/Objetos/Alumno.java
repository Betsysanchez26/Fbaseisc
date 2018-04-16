package com.example.betsysanchez.fbaseisc.Objetos;

/**
 * Created by BetsySanchez on 15/04/2018.
 */

public class Alumno {
    Long noControl;
    String nombre;

    public Alumno() {
    }

    public Alumno(Long noControl, String nombre) {
        this.noControl = noControl;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNoControl() {
        return noControl;
    }

    public void setNoControl(Long noControl) {
        this.noControl = noControl;
    }
}
