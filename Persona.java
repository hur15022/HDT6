/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;

/**
 *
 * @author Jose
 */
public class Persona {
    
    private String nombre;
    private boolean desarrollaJava;
    private boolean desarrollaWeb;
    private boolean desarrollaCelular;
    
    public Persona(String nombre, boolean desarrollaJava, boolean desarrollaWeb, boolean desarrollaCelular){
        this.nombre = nombre;
        this.desarrollaJava = desarrollaJava;
        this.desarrollaWeb = desarrollaWeb;
        this.desarrollaCelular = desarrollaCelular;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDesarrollaJava(boolean desarrollaJava) {
        this.desarrollaJava = desarrollaJava;
    }

    public void setDesarrollaWeb(boolean desarrollaWeb) {
        this.desarrollaWeb = desarrollaWeb;
    }

    public void setDesarrollaCelular(boolean desarrollaCelular) {
        this.desarrollaCelular = desarrollaCelular;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDesarrollaJava() {
        return desarrollaJava;
    }

    public boolean isDesarrollaWeb() {
        return desarrollaWeb;
    }

    public boolean isDesarrollaCelular() {
        return desarrollaCelular;
    }
    
    
    
}
