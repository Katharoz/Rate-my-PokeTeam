package Pruebas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.SwingConstants.CENTER;

class Panel extends JPanel{

    /*----------------------------------------------------------------------------------------------------------------*/
    //Creo variables de forma estatica para poder llamarlos en cualquier parte de la clase.

    private static JPanel buttonPanel;

    private static JLabel background;

    private static JPanel infoPokemon;

    private static JPanel equipo;

    private static List<Pokemon> listaPokemon = new ArrayList<>(Output_Input.Input());

    /*----------------------------------------------------------------------------------------------------------------*/

    //Constructor
    Panel(){
        background = crearBackground();                     //Se crea el background.
        buttonPanel = crearBotones();                   //Se crea un panel de botones con datos basicos de cada pokemon.

        this.add(background);                       //Se añade el background al panel principal.
        background.setLayout(new FlowLayout());             //Se crea un nuevo layout para poder superponer cosas sobre el background.
        background.add(buttonPanel);                    //Se añade el panel de botones sobre el background.
    }

    //Toma una imagen y la convierte en el fondo de pantalla del panel.
    private static JLabel crearBackground(){

        ImageIcon pika = new ImageIcon("iconos\\pokemon-backgrounds-8.jpg");                //Se toma la imagen de la direccion especificada.
        Image pikachu = pika.getImage().getScaledInstance(700, 656, Image.SCALE_SMOOTH);            //Se la convierte a tipo 'Image' temporalmente para poder reescalarla.

        background = new JLabel(new ImageIcon(pikachu));                //Se reconvierte la imagen reescalada a tipo 'ImageIcon' y se la asigna al background.
        background.setBounds(0,0, 500, 700);                //Se dan las dimensiones del background.

        return background;

    }

    //Crea el 'menu principal' de botones.
    private static JPanel crearBotones(){

        buttonPanel = new JPanel( new GridLayout(7, 2, 6, 5) );         //Crea un panel con una disposicion de grid, con la cantidad de columnas y filas que se especifiquen, junto con la distancia horizontal y vertical entre botones.
        buttonPanel.setBorder( new EmptyBorder(0, 0, 0, 0) );       //Se crea un borde invisible para este panel.
        buttonPanel.setOpaque( false );                                         //Se pone opaco al panel, para que no tape al background.

        //Se crean 13 botones de pokemon
        for (int i=0;   i<13;    i++) {

            Boton boton = new Boton(listaPokemon.get(i));                       //Cada boton se crea usando la respectiva posicion del pokemon en la lista.
            boton.setPreferredSize( new Dimension(300, 75) );           //Se define el tamaño de cada boton.

            if (i==12)  boton.setVisible(false);        //Cuando se llega al ultimo boton, este se pone invisible.

            buttonPanel.add(boton);                 //Se añaden los botones al grid.

        }


        ImageIcon pokeball = new ImageIcon("iconos\\pokemon\\13.png");          //Se toma una imagen de una direccion de memoria.
        Boton boton = new Boton(pokeball);                           //Se crea un ultimo boton, que servira para crear equipos.

        //if (equipo != null) boton.setVisible(false);

        buttonPanel.add(boton);     //Se añade este ultimo boton al panel.

        return buttonPanel;

    }

    //Metodo que borra botones para cambiar entre las pantallas principal y datos de pokemon y viceversa.
    static void borrarBotones(String nombre){
        if (buttonPanel.isVisible()){
            buttonPanel.setVisible(false);
            infoPokemon(nombre);                //Se llama al método que crea el panel con los datos del pokemon elegido.
        }else {
            infoPokemon.setVisible(false);
            background.remove(infoPokemon);
            buttonPanel.setVisible(true);
        }
    }

    //Método que sirve para alternar entre las pantallas principal y equipo.
    static void borrarBotones(){
        if (buttonPanel.isVisible()) {
            buttonPanel.setVisible(false);
        }else {
            background.remove(equipo);
            buttonPanel.setVisible(true);
            /*if (Boton.equipoVisible) {
                buttonPanel.remove(buttonPanel.getComponent(13));
            }*/
        }
    }

    //Método que muestra la informacion del pokemon elegido.
    private static void infoPokemon(String nombre) {

        infoPokemon = new JPanel(new GridLayout(4,2,6,5));          //Se crea un grid con la informacion.
        infoPokemon.setBorder( new EmptyBorder(0, 0, 0, 0));

        //Agregar La imagen del pokemon.
        ImageIcon pokemon = new ImageIcon("iconos\\pokemonGif\\" + nombre + ".gif");
        JLabel pokegif = new JLabel(pokemon);
        pokegif.setSize(300, 75);
        infoPokemon.add(pokegif);

        //Parte de la que estoy profundamente avergonzado.
    /*----------------------------------------------------------------------------------------------------------------*/

        //Iniciacion de valores.
        int tipoPrinc = -1;
        int tipoSec = -1;
        String nomb = "";
        int nroPokedex = 0;
        double altura = 0;
        double peso = 0;
        String descripcion = "";

        //Se busca el pokemon en la lista cuyo nombre coincida con el dado en esta clase y se guardan sus valores.
        for (Pokemon poke : listaPokemon) {
            if (poke.getName().equals(nombre)) {
                tipoPrinc = poke.getTipoPrinc();
                tipoSec = poke.getTipoSec();
                nomb = poke.getName();
                nroPokedex = poke.getNroPokedex();
                altura = poke.getAltura();
                peso = poke.getPeso();
                descripcion = poke.getDescripcion();
            }
        }

        //Se carga cada dato individualmente. Perdon.
        JLabel nom = new JLabel("Nombre: "+nomb);
        nom.setHorizontalAlignment(CENTER);
        nom.setSize(300,75);
        nom.setFont(new Font("Arial", Font.BOLD, 24));
        infoPokemon.add(nom);

        //Se controla si el pokemon tiene o no tipo secundario.
        if (tipoSec==-1){

            JLabel text = new JLabel("Tipo:");
            text.setFont(new Font("Arial", Font.BOLD, 24));
            text.setHorizontalAlignment(CENTER);
            text.setSize(300,75);
            infoPokemon.add(text);

            ImageIcon tipo1 = new ImageIcon("iconos\\Tipos\\"+tipoPrinc+".png");
            Image pokem = tipo1.getImage().getScaledInstance(100,45, Image.SCALE_SMOOTH);
            JLabel tipoP = new JLabel(new ImageIcon(pokem));
            tipoP.setHorizontalAlignment(CENTER);
            tipoP.setSize(300, 75);
            infoPokemon.add(tipoP);

        }else {
            ImageIcon tipo1 = new ImageIcon("iconos\\Tipos\\"+tipoPrinc+".png");
            Image pokem = tipo1.getImage().getScaledInstance(100,45, Image.SCALE_SMOOTH);
            JLabel tipoP = new JLabel(new ImageIcon(pokem));
            tipoP.setHorizontalAlignment(CENTER);
            tipoP.setSize(300, 75);
            infoPokemon.add(tipoP);

            ImageIcon tipo2 = new ImageIcon("iconos\\Tipos\\"+tipoSec+".png");
            Image pokemo = tipo2.getImage().getScaledInstance(100,45, Image.SCALE_SMOOTH);
            JLabel tipoS = new JLabel(new ImageIcon(pokemo));
            tipoS.setHorizontalAlignment(CENTER);
            tipoS.setSize(300, 75);
            infoPokemon.add(tipoS);
        }

        JLabel nro = new JLabel("Nro Pokedex: #"+nroPokedex);
        nro.setFont(new Font("Arial", Font.BOLD, 24));
        nro.setHorizontalAlignment(CENTER);
        nro.setSize(300,75);
        infoPokemon.add(nro);

        JLabel alt = new JLabel("Altura: "+altura+" m");
        alt.setFont(new Font("Arial", Font.BOLD, 24));
        alt.setHorizontalAlignment(CENTER);
        alt.setSize(300,75);
        infoPokemon.add(alt);

        JLabel pes = new JLabel("Peso: "+peso+" Kg");
        pes.setFont(new Font("Arial", Font.BOLD, 24));
        pes.setHorizontalAlignment(CENTER);
        pes.setSize(300,75);
        infoPokemon.add(pes);

        JLabel desc = new JLabel("Descripcion: "+descripcion);
        desc.setFont(new Font("Arial", Font.BOLD, 24));
        desc.setHorizontalAlignment(CENTER);
        desc.setSize(300,75);
        //infoPokemon.add(desc);

        //Agregar el boton de volver a la pantalla anterior
        Boton boton = new Boton("Volver atras");
        boton.setSize(300, 75);
        infoPokemon.add(boton);

    /*----------------------------------------------------------------------------------------------------------------*/

        //Una vez cargados todos los datos, se añaden al panel. De nuevo, perdon por esto.
        infoPokemon.setOpaque(false);
        background.setLayout(new FlowLayout());
        background.add(infoPokemon);
    }

    //Aqui se crea por primera vez el panel donde se pueden elegir hasta 3 pokemon del menu principal.
    static void crearEquipo(){
        JLabel texto = new JLabel("Elija 3 pokemon");
        texto.setHorizontalAlignment(CENTER);
        texto.setFont(new Font("Arial", Font.BOLD, 24));
        texto.setBackground(Color.orange);
        texto.setOpaque(true);

        equipo = new JPanel( new GridLayout(2, 3, 6, 5) );
        equipo.setBorder( new EmptyBorder(0, 0, 0, 0) );
        equipo.add(texto);

        //Se crean los botones, que por ahora solamente contienen valores del 1 al 3.
        for (int i = 0; i < 5; i++) {
            Boton boton = new Boton(i + 1, null);
            boton.setPreferredSize(new Dimension(200, 200));
            equipo.add(boton);
        }
        //Los ultimos dos botones permanecen invisibles hasta que cierta condicion se cumpla.
        equipo.getComponent(4).setVisible(false);
        equipo.getComponent(5).setVisible(false);

        equipo.setOpaque( false );
        //Se llimpia la pantalla y luego se añade este panel al background.
        borrarBotones();
        buttonPanel.setVisible(false);
        background.add(equipo);

    }

    //Se 'actualizan' los datos del panel de equipos.
    static void crearEquipo(int n, String nombre){

        equipo.remove(equipo.getComponent(n));        //Se borra el boton que existia con anterioridad, ya que se va a crear uno con datos actualizados en su lugar.

        boolean flag = true;                        //Bandera que se encarga de poner visibles los ultimos botones del panel cuando 2 o mas pokemon han sido elegidos.

        //Se busca la posicion del boton clickeado, cuando se halla, se crea un boton con el pokemon correspondiente en dicha posicion.
        for (int i = 0; i < 3; i++) {
            if (i==n-1 ) {
                for (Pokemon poke : listaPokemon) {
                    if (poke.getName().equals(nombre)) {
                        Boton boton = new Boton(i + 1, poke);
                        boton.setPreferredSize(new Dimension(100, 75));
                        boton.setName(nombre);
                        equipo.add(boton,n);
                    }
                }
            }

            if (equipo.getComponent(n).getName()==null){
                flag=false;
            }
        }

        //Se ponen los botones visibles 'Borrar' y 'Aceptar'.
        if (!flag){
            equipo.getComponent(4).setVisible(true);
            equipo.getComponent(5).setVisible(true);
        }


        equipo.setOpaque( false );
        borrarBotones();
        buttonPanel.setVisible(false);
        background.add(equipo);
    }

    //This is it. Se crea un panel final, donde se muestran las debilidades y fortalezas del equipo elegido.
    static void valorarEquipo(){

        //Se crean las listas.
        List<Integer> debilidades = new ArrayList<>();
        List<Integer> fortalezas = new ArrayList<>();

        //Boton a boton, se encuentra el nombre del pokemon, y con el se busca el resto de datos relevantes.
        for (int i = 0; i < 3; i++) {
            String n = equipo.getComponent(i+1).getName();

            for (Pokemon pokemon : listaPokemon) {
                if (pokemon.getName().equals(n)) {
                    int tipoPr = pokemon.getTipoPrinc();
                    int tipoSe = pokemon.getTipoSec();

                    //Una vez se tiene el tipo principal y secundario (este ultimo puede no existir), se cargan las listas con las debilidades y fortalezas de cada tipo.
                    TablaTipos.buscarDebilidades(tipoPr, debilidades);
                    TablaTipos.buscarFortalezas(tipoPr, fortalezas);
                    if (tipoSe > -1) {
                        TablaTipos.buscarDebilidades(tipoSe, debilidades);
                        TablaTipos.buscarFortalezas(tipoSe, fortalezas);
                    }
                }
            }

        }

        //Se comparan ambas listas, eliminando cualquier elemento que compartan.
        TablaTipos.comparar(debilidades,fortalezas);

        /*System.out.print("\nDebilidades): ");
        TablaTipos.imprimir(debilidades);
        System.out.print("\nFortalezas: ");
        TablaTipos.imprimir(fortalezas);*/

        equipo.setVisible(false);           //Se esconde el panel de creacion de equipo.

        //Se crea un panel y se lo carga con los datos de las listas.
    /*----------------------------------------------------------------------------------------------------------------*/

        JPanel valoracion = new JPanel(new GridLayout(3, 1, 6, 5));
        valoracion.setBorder( new EmptyBorder(0, 0, 0, 0));
        valoracion.setBackground(Color.orange);
        valoracion.setOpaque(true);

        JLabel fortale = new JLabel("Fortalezas:" +TablaTipos.imprimir(fortalezas));
        fortale.setFont(new Font("Arial", Font.BOLD, 12));
        fortale.setHorizontalAlignment(CENTER);
        fortale.setSize(300,75);
        valoracion.add(fortale);

        JLabel debilida = new JLabel("Debilidades: " +TablaTipos.imprimir(debilidades));
        debilida.setFont(new Font("Arial", Font.BOLD, 12));
        debilida.setHorizontalAlignment(CENTER);
        debilida.setSize(300,75);
        valoracion.add(debilida);

    /*----------------------------------------------------------------------------------------------------------------*/

        //Se añade el panel al background.
        valoracion.setVisible(true);
        //background.setLayout(new FlowLayout());
        background.add(valoracion);

    }

}
