package Pruebas;

import javax.swing.*;
import java.io.Serializable;

public class Pokemon implements Serializable {                  //Hacer que esta clase sea serializable.

    //Definir todos los atributos.
    private String name;
    private ImageIcon pokemon;
    private int tipoPrinc;
    private int tipoSec;
    private int nroPokedex;
    private double altura;
    private double peso;
    private String descripcion;

    //Constructor-------------------------------------------------------------------------------------------------------
    public Pokemon(String pokemonName, ImageIcon icono, int tipoPrinc, int tipoSec, int nro, double altura, double peso, String descripcion){
        this.name = pokemonName;
        this.pokemon = icono;
        this.tipoPrinc = tipoPrinc;
        this.tipoSec = tipoSec;
        this.nroPokedex = nro;
        this.altura = altura;
        this.peso = peso;
        this.descripcion = descripcion;
    }

    //Getters-----------------------------------------------------------------------------------------------------------
    String getName() {return this.name;}

    ImageIcon getPokemon() {return this.pokemon;}

    int getTipoPrinc() {
        return tipoPrinc;
    }

    int getTipoSec() {
        return tipoSec;
    }

    int getNroPokedex() {return  this.nroPokedex;}

    double getAltura() {
        return altura;
    }

    double getPeso() {
        return peso;
    }

    String getDescripcion() {
        return descripcion;
    }
}
