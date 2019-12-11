package Pruebas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Se crea una lista de pokemon, donde cada dato es cargado manualmente. Esta lista luego se serializa, para facilitar su uso.
    /*----------------------------------------------------------------------------------------------------------------*/

        /*List<Pokemon> listaPokemon = new ArrayList<>();

        String[] nombresPokemon = {"Venusaur","Charizard","Blastoise","Beedrill","Pikachu","Alakazam","Machamp","Gengar","Onix","Jynx","Snorlax","Dragonite","","Crear Equipo"};
        int[] nroPokemon = {3,6,9,15,25,65,68,94,95,124,143,149,82,0};
        double[] altura = {2.0, 1.7, 1.6, 1.0, 0.4, 1.5, 1.6, 1.5, 8.8, 1.4, 2.1, 2.2,0,0};
        double[] peso = {100.0, 90.5, 85.5, 29.5, 6.0, 48.0, 130.0, 40.5, 210.0, 40.6, 460.0, 210,0,0};
        String[] descripcion = {"La planta florece cuando absorbe energía solar. Ésta le obliga a ponerse en busca de la luz solar.", "Escupe fuego tan caliente que funde las rocas. Causa incendios forestales sin querer.", "Un brutal Pokémon con reactores de agua en su caparazón. Éstos son usados para rápidos placajes.", "Vuela muy deprisa y ataca con los venenosos y grandes aguijones de su cola y patas delanteras.", "Cuando varios de estos Pokémon se juntan, su energía puede causar fuertes tormentas.", "Su cerebro puede ganar al de un súper-ordenador. Tiene un coeficiente intelectual de 5000.", "Con sus fuertes músculos, lanza bestiales puñetazos y envía a su víctima al lejano horizonte.", "En luna llena, a este Pokémon le gusta imitar las sombras de la gente y burlarse de sus miedos.", "Cuando crece, las partes rocosas de su cuerpo se endurecen. Acaba pareciéndose a un diamante negro.", "Mueve sus caderas seductoramente al caminar. Puede hacer que la gente baile al unísono.", "Es muy vago. Sólo come y duerme. A medida que engorda se vuelve cada vez más perezoso.", "Un Pokémon marino que es muy raro de ver. Dicen que es tan inteligente como los humanos.","",""};
        int[] tipoPrincipal = {9,5,0,1,3,10,7,4,11,6,8,2,-1,-1};
        int[] tipoSecundario = {13,14,-1,14,-1,-1,-1,13,12,10,-1,14,-1,-1};

        for (int i=0;   i<14;    i++){
            ImageIcon iconPoke = new ImageIcon("iconos\\pokemon\\"+i+".png");
            listaPokemon.add(new Pokemon(nombresPokemon[i], iconPoke, tipoPrincipal[i], tipoSecundario[i],nroPokemon[i], altura[i], peso[i], descripcion[i]));
        }

        new Output_Input(listaPokemon);*/

    /*----------------------------------------------------------------------------------------------------------------*/

        ImageIcon icono = new ImageIcon("iconos\\18316-200.png");               //Recibir el icono de la ventana.
        new Frame("Wikidex", icono);                         //Crear la ventana, con el icono y el nombre.

    }

}
