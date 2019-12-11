package Pruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

class Boton extends JButton implements ActionListener {

    //Se crean 4 tipos diferentes de botones

    //Estos botones son los del menú principal, que muestran la imagen y nombre del pokemon, junto al tipo del mismo.
    Boton(Pokemon datosPokemon){

        this.setText(datosPokemon.getName());                       //Se settea el nombre del pokemon como texto en el botón.
        Image newimag = datosPokemon.getPokemon().getImage().getScaledInstance(150, 75, Image.SCALE_SMOOTH);        //Se busca la imagen en el archivo, y se reescala a un tamaño optimo.
        this.setIcon(new ImageIcon(newimag));                       //Se toma la imagen escala y se la aplica al botón.
        setHorizontalTextPosition(LEFT);                        //Esto se asegura de que el texto aparezca a la izquierda de la imagen.
        setHorizontalAlignment(CENTER);                     //Hace que todos lo que se cargó al boton se posicione en el centro.
        setIconTextGap(10);                         //Cantidad de distancia entre texto e imagen.

        this.setBackground(Color.orange);               //Indica de que color será el fondo del botón.

        this.addActionListener(this);               //Indica que el boton realiza acciones, definidas en otro método.

    }

    //Este es el último botón del menú principal, funciona de manera distinta que los demas botones.
    Boton(ImageIcon pokeball){
        this.setText("Crear Equipos");
        Image newimag = pokeball.getImage().getScaledInstance(150, 75, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(newimag));
        setHorizontalAlignment(CENTER);
        setHorizontalTextPosition(LEFT);
        setIconTextGap(10);

        this.setBackground(Color.orange);

        this.addActionListener(this);
    }

    //Estos son los botones de creación de equipo, los primeros 3 son para elegir pokemon, los últimos dos tienen funciones especiales.
    Boton(int a, Pokemon datosPokemon){

        //Si no se cargaron datos de los pokemon, se crean botones genericos, sino se cargan a los botones correspondientes los pokemon elegidos.
        if (datosPokemon==null) {
            if (a==4)   this.setText("Borrar");                 //Este botón se encargará de borrar el equipo creado.
            else if (a==5)  this.setText("Aceptar");                //Este se encargará de aceptar y valorar el equipo (de momento simplemente cierra el programa).
            else this.setText("" +a);                      //De no ser ninguno de los botones especiales, simplemente se les settea un número.
        }else {
            this.setIcon(new ImageIcon("iconos\\pokemonGif\\" + datosPokemon.getName() + ".gif"));                  //Se pone como icono del botón a un gif del pokemon.
            this.setText("" +a);
        }
        setHorizontalTextPosition(CENTER);
        this.setBackground(Color.orange);
        this.addActionListener(this);
    }

    //Este es el botón de volver atras.
    Boton(String texto){

        this.setText(texto);
        setHorizontalTextPosition(LEFT);
        setHorizontalAlignment(CENTER);

        this.setBackground(Color.ORANGE);

        this.addActionListener(this);

    }

    private static boolean equipoVisible = false;            //bandera que se puede usar en todos los métodos de esta clase.
    private static int temp;                             //Variable para almacenar el número del botón correspondiente a la pantalla de elegir equipo.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){                         //Se activa cuando cualquier botón es precionado.

            //Si el botón clickeado es el de crear equipos, se llama al método de crear equipo.
            if (this.getText().equals("Crear Equipos")){
                Panel.crearEquipo();

            }//Si el botón clickeado es uno de los botones numerados de crear equipo.
            else if (this.getText().equals("1") || this.getText().equals("2") || this.getText().equals("3")) {
                equipoVisible = true;                                           //La bandera se pone en verdadera.
                temp = Integer.parseInt(this.getText());                //Se guarda el número (posición) que pertenece al botón clickeado.
                Panel.borrarBotones();                              //Se llama al método borrar botones que no recibe ningún argumento.

            }//Si el botón precionado es el de borrar.
            else if (this.getText().equals("Borrar")) {
                equipoVisible = false;                      //La bandera se pone en verdadera.
                Panel.borrarBotones();                      //Se llama al método borrar botones que no recibe ningún argumento.
                Panel.crearEquipo();                        //Se llama al método de crear equipo.

            }//Si el botón clickeado es el de aceptar.
            else if (this.getText().equals("Aceptar")){
                Panel.valorarEquipo();                     //Se procede a cerrar la ventana.

            }//Si la bandera equipoVisible es verdadera, quiere decir que se ha llamado con anterioridad al método crearEquipo, por ende...
            else if (equipoVisible){
                Panel.borrarBotones();                          //Se llama al método borrar botones que no recibe ningún argumento.
                Panel.crearEquipo(temp,this.getText());             //Y se llama al método de crear equipos, este se diferencia del otro porque recibe como argumento un entero (representando la posición del botón), y un String(representando el nombre del pokemon).

            }//En caso de que la bandera no sea verdadera, se llama al método borrarBotones que recibe el nombre del pokemon, para poder mostrar sus datos por pantalla.
            else {
                //Para cualquier botón pokemon que sea precionado, excepto el botón de 'volver atras', se reproducira un archivo de audio con el rugido de ese pokemon.
                if (!this.getText().equals("Volver atras")) {
                    playSound("iconos\\Cries\\"+this.getText()+".wav");
                }
                Panel.borrarBotones(this.getText());
            }

        }
    }

    //Método para la reproducción de audio.
    private void playSound(String soundName) {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }

}
