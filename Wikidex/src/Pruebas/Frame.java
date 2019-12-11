package Pruebas;

import javax.swing.*;

class Frame extends JFrame{

    Frame(String nombreVentana, ImageIcon icono){

        this.setTitle(nombreVentana);                           //Poner nombre a la ventana.
        this.setIconImage(icono.getImage());                        //Poner icono a la ventana.

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                //Settear la acción que se realizará al apretar la 'x'.
        this.setBounds(400, 50, 700, 700);                  //Definir el tamaño de la ventana.
        this.setResizable(false);                                       //Hacer que el tamaño de la ventana no pueda ser alterado.

        Panel panel = new Panel();                              //Crear panel.
        add(panel);                                     //Agregar panel a la ventana.

        setVisible(true);                                   //Hacer que la ventana sea visible.
    }


}
