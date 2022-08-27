package com.company;

public class Pokemon {

    private int numero;
    private String nombre;
    private String formaActual;
    private String formaBasica;
    private String tipo1;
    private String tipo2;
    private ListaPokemonBasicos listaPokemonBasicos;

    public Pokemon(int numero, String nombre, String formaActual, String formaBasica, String tipo1, String tipo2) {
        this.numero = numero;
        this.nombre = nombre;
        this.formaActual = formaActual;
        this.formaBasica = formaBasica;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.listaPokemonBasicos = new ListaPokemonBasicos();
    }

    public Pokemon(int numero, String nombre, String formaActual, String tipo1, String tipo2) {
        this.numero = numero;
        this.nombre = nombre;
        this.formaActual = formaActual;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.listaPokemonBasicos = new ListaPokemonBasicos();
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormaActual() {
        return formaActual;
    }

    public void setFormaActual(String formaActual) {
        this.formaActual = formaActual;
    }

    public String getFormaBasica() {
        return formaBasica;
    }

    public void setFormaBasica(String formaBasica) {
        this.formaBasica = formaBasica;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

public ListaPokemonBasicos getListaPokemonBasicos() {
        return listaPokemonBasicos;
    }

    public void setListaPokemonBasicos(ListaPokemonBasicos listaPokemonBasicos) {
        this.listaPokemonBasicos = listaPokemonBasicos;
    }


}
