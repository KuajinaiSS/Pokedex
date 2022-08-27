package com.company;

public class NodoPokemon {

    private Pokemon pokemon;
    private NodoPokemon next;
    private NodoPokemon prev;

    public NodoPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
        next = null;
        prev = null;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public NodoPokemon getNext() {
        return next;
    }

    public void setNext(NodoPokemon next) {
        this.next = next;
    }

    public NodoPokemon getPrev() {
        return prev;
    }

    public void setPrev(NodoPokemon prev) {
        this.prev = prev;
    }
}
