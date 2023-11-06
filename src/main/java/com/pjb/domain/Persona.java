package com.pjb.domain;

public class Persona {
    private int idPersona;
    private String nombrePersona;
    private String clavePersona;
    public Persona() {
    }
    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }
    public Persona(int idPersona, String nombrePersona, String clavePersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.clavePersona = clavePersona;
    }
    public Persona(String nombrePersona, String clavePersona) {
        this.nombrePersona = nombrePersona;
        this.clavePersona = clavePersona;
    }
    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
    public void setClavePersona(String clavePersona) {
        this.clavePersona = clavePersona;
    }
    public String getNombrePersona() {
        return nombrePersona;
    }
    public String getClavePersona() {
        return clavePersona;
    }
    @Override
    public String toString() {
        return "Persona [idPersona=" + idPersona + ", nombrePersona=" + nombrePersona + ", clavePersona=" + clavePersona
                + "]";
    }

    
}
