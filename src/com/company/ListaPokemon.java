package com.company;


public class ListaPokemon {
    private NodoPokemon first;
    private NodoPokemon last;


    public ListaPokemon(){
        first = null;
        last = null;
    }


    public NodoPokemon getFirst() {
        return first;
    }

    public void setFirst(NodoPokemon first) {
        this.first = first;
    }

    public NodoPokemon getLast() {
        return last;
    }

    public void setLast(NodoPokemon last) {
        this.last = last;
    }


    public boolean isEmpty(){
        return first==null;

    }

    public int cantDatos() {
        if (isEmpty()) {
            return 0;
        } else {
            int contador = 0;
            NodoPokemon actual = first;
            while (actual != null) {
                actual = actual.getNext();
                contador++;
            }
            return contador++;
        }
    }


    public boolean agregarPokemon(Pokemon pokemon) {
        NodoPokemon nuevo = new NodoPokemon(pokemon);
        if (isEmpty()) {
            first = nuevo;
        } else {
            last.setNext(nuevo);
        }
        nuevo.setPrev(last);
        last = nuevo;
        return true;

    }


    public NodoPokemon buscarPokemon(int numero) {
        NodoPokemon actual = first;
        while (actual != null && actual.getPokemon().getNumero() != numero) {
            actual = actual.getNext();
        }

        return actual;
    }


    public NodoPokemon buscarPokemonNombre(String nombre) {
        NodoPokemon actual = first;


        while (actual != null) {
            if(actual.getPokemon().getNombre().equalsIgnoreCase(nombre)){
                return actual;
            }
            actual = actual.getNext();
        }

        return actual;
    }

/*
    public NodoPokemon buscarPokemon(int numero){
        NodoPokemon auxiliar = head;

        while(auxiliar!=null){

            if(auxiliar.getPokemon().getNumero()==numero){
                return auxiliar;
            }

            auxiliar = auxiliar.getSiguiente();

        }
        return null;
    }

*/


/*
    public boolean agregarPokemon(Pokemon pokemon){
        if(buscarPokemon(pokemon.getNumero()) == null){
            NodoPokemon nuevoPokemon = new NodoPokemon(pokemon);

            if(head == null){
                head = nuevoPokemon;
                return true;
            }

            NodoPokemon auxiliar = head;
            while(auxiliar.getSiguiente()!=null){
                auxiliar = auxiliar.getSiguiente();
            }

            auxiliar.setSiguiente(nuevoPokemon);
            return true;

        }
        return false;
    }
*/

}
