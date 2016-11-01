package ProyectoFinal;

import java.util.ArrayList;

public class Nodo {
    
    private char dato;
    private boolean esFinal;
    private ArrayList<Nodo> hijos;

    public Nodo(char dato) {
        this.dato = dato;
        this.esFinal = false;
        this.hijos = new ArrayList<>();
    }

    public boolean getEsFinal() {
        return esFinal;
    }

    public void setEsFinal(boolean esFinal) {
        this.esFinal = esFinal;
    }

    public char getDato() {
        return dato;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }
}
