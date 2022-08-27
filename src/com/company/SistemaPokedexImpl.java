package com.company;

import ucn.ArchivoEntrada;
import ucn.Registro;

import java.io.IOException;
import java.time.temporal.Temporal;
import java.util.*;

public class SistemaPokedexImpl implements SistemaPokedex{
    Scanner scan = new Scanner(System.in);
    String opcion;
    ListaPokemon listaPokemonTemporal = new ListaPokemon();
    ListaPokemon listaPokemon = new ListaPokemon();
    LinkedList favoritos = new LinkedList();


    public SistemaPokedexImpl(){

    }


    /**
     * Esta funcion ejecuta primeramente a la funcion de lecturaDeArchivos y InsertarOrdenado ,para luego desplegar el menu navegable de la pokedex
     * que llama a su funcion correspondiente segun elija el usuario
     * @throws IOException
     */

    public void iniciarSistema() throws IOException {

        lecturaDeArchivos();
        IntsertarOrdenado();

        do {
            System.out.println(
                            "\n***************************************************************\n" +
                            "                 ! Bienvenido a la PokeDex !\n" +
                            "***************************************************************\n\n" +
                            " [1] Desplegar todos los Pokémon por un rango dado.\n" +
                            " [2] Desplegar todos los Pokémon ordenados alfabéticamente.\n" +
                            " [3] Desplegar Pokémon dado un tipo.\n" +
                            " [4] Desplegar todos los Pokémon ‘Primera Evolucion’.\n" +
                            " [5] Buscar un Pokémon por su número o nombre.\n" +
                            " [6] Desplegar Pokémon con sus evoluciones.\n" +
                            " [7] Añadir a favoritos.\n" +
                            " [0] Salir.\n\n" +
                            "***************************************************************");

            opcion = scan.next();

            switch (opcion){
                case "1":{
                    System.out.print("\n***************************************************************\n" +
                            "Desplegando Pokemones por Intervalo" +
                            "\n***************************************************************\n\n" +
                            "Ingrese el rango minimo: ");

                    String minn = scan.next();
                    System.out.print("Ingrese el rango maximo: ");
                    String maxx = scan.next();

                    if(validacionInt(minn) && validacionInt(maxx)){

                        int min = Integer.parseInt(minn);
                        int max = Integer.parseInt(maxx);

                        if(min>0 && max<152){
                            System.out.println("\n***************************************************************\n");
                            desplegarPokemon(min-1,max);

                            break;
                        }
                        System.out.println("Datos ingresados no estan en el rango de [1-151]");
                        break;
                    }
                    System.out.println("Datos ingresados no son enteros");
                    break;
                }

                case "2":{
                    System.out.print("\n***************************************************************\n" +
                            "Desplegando  Pokémon ordenados alfabéticamente: " +
                            "\n***************************************************************\n\n");
                    desplegarPokemonAlfabeticamente();

                    break;
                }

                case "3":{
                    System.out.print("\n***************************************************************\n" +
                            "Desplegando Pokemones por Tipos" +
                            "\n***************************************************************\n\n" +
                            "Ingrese el Tipo a desplegar: ");
                    String tipo = scan.next();
                    desplegarPokemonTipo(tipo);

                    break;
                }

                case "4":{
                    System.out.print("\n***************************************************************\n" +
                            "Desplegando Pokemones Primera evolucuon" +
                            "\n***************************************************************\n\n");
                    desplegarPokemonPrimeraEvolucion();

                    break;
                }

                case "5":{
                    System.out.print("\n***************************************************************\n" +
                            "Buscando pokemones" +
                            "\n***************************************************************\n\n");
                    System.out.print("Ingrese el nombre o el numero del pokemon a buscar: ");
                    String identificador = scan.next();
                    buscarPokemon(identificador);
                    break;
                }

                case "6":{
                    System.out.print("\n***************************************************************\n" +
                            "Desplegando Pokémones Basicos con sus evoluciones" +
                            "\n***************************************************************\n\n");
                    desplegarEvoluciones();

                    break;
                }

                case "7":{

                    agregarPokemonFavorito();
                    System.out.print("envie lo que sea para continuar: ");
                    scan.next();

                    break;
                }
            }
        }while(!opcion.equals("0"));
        salirSistema();
    }


    /**
     * Esta funcion lee los archivos de entrada, guardandolos en listaPokemonTemporal para mas adelante ser ordenados por su numero,
     * los archivos leidos son kanto.txy y basico.txt
     * @throws IOException
     */
    public void lecturaDeArchivos() throws IOException {

        ArchivoEntrada archivo = new ArchivoEntrada("kanto.txt");
        String formaBasica = "null";

        while(!archivo.isEndFile()){
            Registro registro = archivo.getRegistro();

            String numeroo = registro.getString();
            int numero = Integer.parseInt(numeroo.replace(" ", ""));


            String nombree = registro.getString();
            String nombre = nombree.replace(" ", "");


            String formaActuall = registro.getString();
            String formaActual = formaActuall.replace(" ", "");




            if(!formaActual.equalsIgnoreCase("basico")){

                String formaBasicaa = registro.getString();
                formaBasica = formaBasicaa.replace(" ", "");

            }

            String tipo11 = registro.getString();
            String tipo1 = tipo11.replace(" ", "");


            String tipo22 = registro.getString();
            String tipo2 = tipo22.replace(" ", "");


            if(!formaActual.equalsIgnoreCase("basico.txt")){
                Pokemon nuevoPokemon = new Pokemon(numero,nombre,formaActual,formaBasica,tipo1,tipo2);
                listaPokemonTemporal.agregarPokemon(nuevoPokemon);

            }else{
                Pokemon nuevoPokemon = new Pokemon(numero,nombre,formaActual,tipo1,tipo2);
                listaPokemonTemporal.agregarPokemon(nuevoPokemon);

            }
        }


        ArchivoEntrada archivo2 = new ArchivoEntrada("basicos.txt");
        while (!archivo2.isEndFile()) {
            Registro registro2 = archivo2.getRegistro();

            String numeroo = registro2.getString();
            int numero = Integer.parseInt(numeroo.replace(" ", ""));

            String posePrimeraa = registro2.getString();
            String posePrimera = posePrimeraa.replace(" ", "");

            String poseSegundaa = registro2.getString();
            String poseSegunda = poseSegundaa.replace(" ", "");




        }

    }


    /**
     * esta funcion ordena la listaPokemonTemporal, agrgandolos a la lista Pokemon
     * @return
     */
    @Override
    public boolean IntsertarOrdenado() {

        for (int i = 0; i < listaPokemonTemporal.cantDatos(); i++) {
            listaPokemon.agregarPokemon(listaPokemonTemporal.buscarPokemon(i+1).getPokemon());
        }

        return false;
    }

    /**
     *
     * @param identificador
     */
    @Override
    public void Pokemon(String identificador) {

    }//vacio

    /**
     *
     * @param pokemon
     * @return
     */
    @Override
    public boolean insertarBasico(Pokemon pokemon) {// vacio
        return false;
    }


    /**
     *
     * @param pokemon
     * @return
     */
    @Override
    public boolean insertarEvolucion(Pokemon pokemon) {
        return false;
    }//vacio


    /**
     * Esta funcion depliega los pokemones por orden numerioco de menor a mayor con sus arboles  evolutivos correspondientes
     */
    @Override
    public void desplegarEvoluciones() {

        for (int i = 0; i < listaPokemon.cantDatos()+1; i++) {

            if(i == 150){
                System.out.println("( "+ (i+1) +" )Mew → ( x )No tiene → ( x )No tiene\n");
                break;
            }


            if(listaPokemon.buscarPokemon(i+2).getPokemon().getFormaActual().equalsIgnoreCase("Basico") ){
                System.out.println("( "+ (i+1) +" )"+listaPokemon.buscarPokemon(i+1).getPokemon().getNombre()+" → ( x )No tiene → ( x )No tiene");

            }
            else{
                if(listaPokemon.buscarPokemon(i+3).getPokemon().getFormaActual().equalsIgnoreCase("Basico")){
                    System.out.println("( "+ (i+1) +" )"+listaPokemon.buscarPokemon(i+1).getPokemon().getNombre()+" → ( "+ (i+2) +" )"+listaPokemon.buscarPokemon(i+2).getPokemon().getNombre()+" → ( x )No tiene");
                    i = i +1;
                }
                else{
                    System.out.println("( "+ (i+1) +" )"+listaPokemon.buscarPokemon(i+1).getPokemon().getNombre()+" → ( "+ (i+2) +" )"+listaPokemon.buscarPokemon(i+2).getPokemon().getNombre()+" → ( "+ (i+3) +" )"+listaPokemon.buscarPokemon(i+3).getPokemon().getNombre());
                    i = i +2;
                }
            }
        }
        System.out.print("envie lo que sea para continuar: ");
        scan.next();

    }


    /**
     *
     * @param numero
     * @param formaActual
     * @param formaBasica
     * @param tipo1
     * @param tipo2
     * @return
     */
    @Override
    public boolean insertarPokemon(int numero, String formaActual, String formaBasica, String tipo1, String tipo2) {
        return false;
    }// vacio


    /**
     * esta funcion despliega los pokemones de menor a mayor segun su numero ,con toda su informacion respectiva (nombre, numero, forma actual, y sus tipos) segun
     * el rango numerico que ingreso el usuario
     * @param min numero minimo a buscar
     * @param max numero maximo a buscar
     */
    @Override
    public void desplegarPokemon(int min, int max) {

        System.out.print("\n***************************************************************\n");

        for (int i = min; i < max; i++) {
            System.out.println("*********************" +
                    "\nNúmero: "+listaPokemon.buscarPokemon(i+1).getPokemon().getNumero() +
                    "\nNombre: "+listaPokemon.buscarPokemon(i+1).getPokemon().getNombre() +
                    "\nFase: "+ listaPokemon.buscarPokemon(i+1).getPokemon().getFormaActual()+
                    "\nTipo 1: "+ listaPokemon.buscarPokemon(i+1).getPokemon().getTipo1()+
                    "\nTipo 2: "+ listaPokemon.buscarPokemon(i+1).getPokemon().getTipo2()+
                    "\n*********************\n\n");


        }
        System.out.print("envie lo que sea para continuar: ");
        scan.next();


    }

    /**
     * Esta funcion despliega los pokemones alfabeticamente con toda su informacion respectiva (nombre, numero, forma actual, y sus tipos)
     */
    @Override
    public void desplegarPokemonAlfabeticamente() {
        ArrayList<String> Temporal = new ArrayList<>();

        for (int i = 0; i < listaPokemon.cantDatos(); i++) {
            Temporal.add(listaPokemon.buscarPokemon(i+1).getPokemon().getNombre());
        }

        Collections.sort(Temporal);

        for (int i = 0; i < listaPokemon.cantDatos(); i++) {

            String nombre = Temporal.get(i);

            System.out.println("*********************" +
                    "\nNúmero: "+listaPokemon.buscarPokemonNombre(nombre).getPokemon().getNumero() +
                    "\nNombre: "+listaPokemon.buscarPokemonNombre(nombre).getPokemon().getNombre() +
                    "\nFase: "+ listaPokemon.buscarPokemonNombre(nombre).getPokemon().getFormaActual()+
                    "\nTipo 1: "+ listaPokemon.buscarPokemonNombre(nombre).getPokemon().getTipo1()+
                    "\nTipo 2: "+ listaPokemon.buscarPokemonNombre(nombre).getPokemon().getTipo2()+
                    "\n*********************\n\n");
        }
        System.out.print("envie lo que sea para continuar: ");
        scan.next();
    }

    /**
     * Esta funcion despliega los pokemones segun el tipo que ingreso el usuario con toda su informacion respectiva (nombre, numero, forma actual, y sus tipos)
     * @param tipo
     */
    @Override
    public void desplegarPokemonTipo(String tipo) {

        for (int i = 0; i < listaPokemon.cantDatos(); i++) {
            if(listaPokemon.buscarPokemon(i+1).getPokemon().getTipo1().equalsIgnoreCase(tipo) || listaPokemon.buscarPokemon(i+1).getPokemon().getTipo2().equalsIgnoreCase(tipo)){

                System.out.println("*********************" +
                        "\nNúmero: "+listaPokemon.buscarPokemon(i+1).getPokemon().getNumero() +
                        "\nNombre: "+listaPokemon.buscarPokemon(i+1).getPokemon().getNombre() +
                        "\nFase: "+ listaPokemon.buscarPokemon(i+1).getPokemon().getFormaActual()+
                        "\nTipo 1: "+ listaPokemon.buscarPokemon(i+1).getPokemon().getTipo1()+
                        "\nTipo 2: "+ listaPokemon.buscarPokemon(i+1).getPokemon().getTipo2()+
                        "\n*********************\n\n");

            }
        }

        System.out.print("envie lo que sea para continuar: ");
        scan.next();

    }

    /**
     * Esta funcion despliega a los pokemones en su Primera Evolucion, con toda su informacion respectiva (nombre, numero, forma actual, y sus tipos)
     */
    @Override
    public void desplegarPokemonPrimeraEvolucion() {
        for (int i = 0; i < listaPokemon.cantDatos(); i++) {
            if(listaPokemon.buscarPokemon(i+1).getPokemon().getFormaActual().equalsIgnoreCase("PrimeraEvolucion")){

                System.out.println("*********************" +
                        "\nNúmero: "+listaPokemon.buscarPokemon(i+1).getPokemon().getNumero() +
                        "\nNombre: "+listaPokemon.buscarPokemon(i+1).getPokemon().getNombre() +
                        "\nFase: "+ listaPokemon.buscarPokemon(i+1).getPokemon().getFormaActual()+
                        "\nTipo 1: "+ listaPokemon.buscarPokemon(i+1).getPokemon().getTipo1()+
                        "\nTipo 2: "+ listaPokemon.buscarPokemon(i+1).getPokemon().getTipo2()+
                        "\n*********************\n\n");

            }
        }

        System.out.print("envie lo que sea para continuar: ");
        scan.next();

    }


    /**
     * Esta funcion busca a los pokemones segun su nombre o numero identificador, para luego desplegar a este pokemon con toda su informacion respectiva (nombre, numero, forma actual, y sus tipos)
     * @param identificadorr
     * @return
     */
    @Override
    public boolean buscarPokemon(String identificadorr) {

        if(validacionInt(identificadorr)){
            int identificador = Integer.parseInt(identificadorr);

            if(0<identificador && identificador<151) {
                System.out.print("\n***************************************************************\n");
                System.out.println("\n*********************" +
                        "\nNúmero: " + listaPokemon.buscarPokemon(identificador).getPokemon().getNumero() +
                        "\nNombre: " + listaPokemon.buscarPokemon(identificador).getPokemon().getNombre() +
                        "\nFase: " + listaPokemon.buscarPokemon(identificador).getPokemon().getFormaActual() +
                        "\nTipo 1: " + listaPokemon.buscarPokemon(identificador).getPokemon().getTipo1() +
                        "\nTipo 2: " + listaPokemon.buscarPokemon(identificador).getPokemon().getTipo2() +
                        "\n*********************");
                System.out.print("\n***************************************************************\n");

                System.out.print("envie lo que sea para continuar: ");
                scan.next();
                return true;
            }
            System.out.println("Datos ingresados no estan en el rango de [1-151]");
            System.out.print("envie lo que sea para continuar: ");
            scan.next();
            return false;
        }

        else{

            if(listaPokemon.buscarPokemonNombre(identificadorr)==null){
                System.out.println("El nombre del Pokemon no existe");
                System.out.print("envie lo que sea para continuar: ");
                scan.next();
                return false;
            }

            System.out.print("\n***************************************************************\n");
            System.out.println("\n*********************" +
                    "\nNúmero: " + listaPokemon.buscarPokemonNombre(identificadorr).getPokemon().getNumero() +
                    "\nNombre: " + listaPokemon.buscarPokemonNombre(identificadorr).getPokemon().getNombre() +
                    "\nFase: " + listaPokemon.buscarPokemonNombre(identificadorr).getPokemon().getFormaActual() +
                    "\nTipo 1: " + listaPokemon.buscarPokemonNombre(identificadorr).getPokemon().getTipo1() +
                    "\nTipo 2: " + listaPokemon.buscarPokemonNombre(identificadorr).getPokemon().getTipo2() +
                    "\n*********************");
            System.out.print("\n***************************************************************\n");

            System.out.print("envie lo que sea para continuar: ");
            scan.next();
            return true;


        }
    }

    /**
     * Esta primeramente depliega a todos los pokemones que tiene actualmente agregados a favoritos, luego solicita al usuario a cual pokemon quiere agregar a lista de favoritos
     * luego algrega a este pokemon a la lista de favoritos si es que se encuentra o si no esta agregado
     * @return
     */
    @Override
    public boolean agregarPokemonFavorito() {

        System.out.print("\n\n***************************************************************\n" +
                "Favoritos actualmente agregados" +
                "\n***************************************************************\n\n");

        for (int i = 0; i < favoritos.size(); i++) {//desplegar favoritos actuales
            String nombre = (String) favoritos.get(i);
            Pokemon desplegar = listaPokemon.buscarPokemonNombre(nombre).getPokemon();

            if(desplegar.getFormaActual().equalsIgnoreCase("Basico")){
                System.out.println("( "+desplegar.getNumero()+" ) "+ desplegar.getNombre() +" → () No Tiene");
            }
            else{
                Pokemon desplegarFormaBaisca = listaPokemon.buscarPokemonNombre(desplegar.getFormaBasica()).getPokemon();

                System.out.println("( "+desplegar.getNumero()+" ) " +desplegar.getNombre()+"  → ( "+desplegarFormaBaisca.getNumero()+" ) "+desplegarFormaBaisca.getNombre() );
            }
        }

        System.out.print("\nIngrese el nombre del favorito que desea agregar: ");
        String favorito = scan.next();

        if(listaPokemon.buscarPokemonNombre(favorito)== null) {
            System.out.println("El nombre del pokemon ingresado no existe...\n");
            return false;
        }

        for (int i = 0; i < favoritos.size(); i++) {
            if (favoritos.get(i).equals(favorito)) {//busco si ya esta agregado
                System.out.println("El pokemon ya esta en tu lista de favoritos...\n");
                return false;
            }
        }


        favoritos.add(favorito);
        System.out.println(favorito+" agregado correctamente\n");
        return true;
    }

    /**
     *
     */
    @Override
    public void salirSistema() {
        System.out.println("Cerrando sistema...");
    }

    /**
     * esta funcion valida si el dato es un numero o un String
     * @param cadena la palabra a corroborar
     * @return si es true si es entero o false si es un numero
     */
    public boolean validacionInt(String cadena){
        int num;
        try{
            num = Integer.parseInt(cadena);
            return true;


        }catch (Exception e){

            return false;
        }
    }

}
