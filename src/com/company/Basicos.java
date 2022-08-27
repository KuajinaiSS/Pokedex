package com.company;

public class Basicos {
    int numero;
    boolean primeraEvolucion;
    boolean segundaEvolucion;

    public Basicos(int numero, boolean primeraEvolucion, boolean segundaEvolucion) {
        this.numero = numero;
        this.primeraEvolucion = primeraEvolucion;
        this.segundaEvolucion = segundaEvolucion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isPrimeraEvolucion() {
        return primeraEvolucion;
    }

    public void setPrimeraEvolucion(boolean primeraEvolucion) {
        this.primeraEvolucion = primeraEvolucion;
    }

    public boolean isSegundaEvolucion() {
        return segundaEvolucion;
    }

    public void setSegundaEvolucion(boolean segundaEvolucion) {
        this.segundaEvolucion = segundaEvolucion;
    }


}
