package com.company;

public interface SistemaPokedex {


    public boolean IntsertarOrdenado();

    public void Pokemon(String identificador);//????

    public boolean insertarBasico(Pokemon pokemon);

    public boolean insertarEvolucion(Pokemon pokemon);

    public void desplegarEvoluciones();

    public boolean insertarPokemon(int numero, String formaActual, String formaBasica, String tipo1, String tipo2);

    public void desplegarPokemon(int min, int max);

    public void desplegarPokemonAlfabeticamente();

    public void desplegarPokemonTipo(String tipo);

    public void desplegarPokemonPrimeraEvolucion();

    public boolean buscarPokemon(String identificador);

    // public void desplegarEvoluciones(); DUPLICADO???

    public boolean agregarPokemonFavorito();

    public void salirSistema();

}
