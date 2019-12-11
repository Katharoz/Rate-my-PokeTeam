package Pruebas;

import java.io.*;
import java.util.List;

public class Output_Input {

    public Output_Input(List<Pokemon> p){

        try {
            ObjectOutputStream listaPokemon = new ObjectOutputStream(new FileOutputStream("iconos\\pokemon\\ListaPokemon.txt"));
            listaPokemon.writeObject(p);

            listaPokemon.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static List<Pokemon> Input(){

        List<Pokemon> listaInput = null;

        try {
            ObjectInputStream listaPokemon = new ObjectInputStream(new FileInputStream("iconos\\pokemon\\ListaPokemon.txt"));
            listaInput = (List<Pokemon>) listaPokemon.readObject();

            listaPokemon.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listaInput;

    }

}
