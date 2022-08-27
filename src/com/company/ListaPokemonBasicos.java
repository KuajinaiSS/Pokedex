package com.company;

public class ListaPokemonBasicos {

    private Pokemon[] vecBasicos;
    private int cantActual;
    private int max;

    public ListaPokemonBasicos(){
        this.max = 79;
        vecBasicos = new Pokemon[max];
    }

    public boolean agregarPokemonBasico(Pokemon pokemon){

        vecBasicos[cantActual] = pokemon;
        cantActual++;
        return true;
    }

    public Pokemon[] getVecBasicos() {
        return vecBasicos;
    }

    public void setVecBasicos(Pokemon[] vecBasicos) {
        this.vecBasicos = vecBasicos;
    }

    public int getCantActual() {
        return cantActual;
    }

    public void setCantActual(int cantActual) {
        this.cantActual = cantActual;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}



