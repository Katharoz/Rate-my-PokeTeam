package Pruebas;

import java.util.*;

class TablaTipos {

    private static int[][] tablaTipos = {
            //Se crea la matriz tabla de tipos, que sirve para saber segun el tipo de cada pokemon, contra que es fuerte y contra que es debil.

                      //agu|bic|dra|ele|fan|fue|hie|luc|nor|pla|psi|roc|tie|ven|vol
            /*Agua*/    {1,  1,  -1, 1,  1,  2,  1,  1,  1,  -1, 1,  2,  2,  1,  1},
            /*Bicho*/   {1,  1,  1,  1,  1,  -1, 1,  -1, 1,  2,  2,  1,  1,  2,  -1},
            /*Dragon*/  {1,  1,  2,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},
           /*Electrico*/{2,  1,  -1, -1, 1,  1,  1,  1,  1,  -1, 1,  1,  0,  1,  2},
            /*Fantasma*/{1,  1,  1,  1,  2,  1,  1,  1,  0,  1,  0,  1,  1,  1,  1},
            /*Fuego*/   {-1, 2,  -1, 1,  1,  -1, 2,  1,  1,  2,  1,  -1, 1,  1,  1},
            /*Hielo*/   {-1, 1,  2,  1,  1,  1,  -1, 1,  1,  2,  1,  1,  2,  1,  2},
            /*Lucha*/   {1,  -1, 1,  1,  0,  1,  2,  1,  2,  1,  -1, 2,  1,  -1, -1},
            /*Normal*/  {1,  1,  1,  1,  0,  1,  1,  1,  1,  1,  1,  -1, 1,  1,  1},
            /*Planta*/  {2,  -1, -1, 1,  1,  -1, 1,  1,  1,  -1, 1,  2,  2,  -1, -1},
            /*Psiquico*/{1,  1,  1,  1,  1,  1,  1,  2,  1,  1,  -1, 1,  1,  2,  1},
            /*Roca*/    {1,  2,  1,  1,  1,  2,  2,  -1, 1,  1,  1,  1,  -1, 1,  2},
            /*Tierra*/  {1,  -1, 1,  2,  1,  2,  1,  1,  1,  -1, 1,  2,  1,  2,  0},
            /*Veneno*/  {1,  2,  1,  1,  -1, 1,  1,  1,  1,  2,  1,  -1, -1, -1, 1},
            /*Volador*/ {1,  2,  1,  -1, 1,  1,  1,  2,  1,  2,  1,  -1, 1,  1,  1},
    };

    //Se carga la lista con todas las debilidades de todos los pokemon elegidos, sin repetir.
    static void buscarDebilidades(int i, List<Integer> debilidades){

        for (int j=0;   j<tablaTipos.length;    j++){
            boolean repetido = false;
            if (tablaTipos[j][i]==2) {
                for (Integer debilidade : debilidades) {
                    if (debilidade == j) repetido = true;
                }
                if (!repetido)  debilidades.add(j);
            }
        }

    }

    //Se carga la lista con todas las fortalezas de todos los pokemon elegidos, sin repetir.
    static void buscarFortalezas(int i, List<Integer> fortalezas){

        for (int j=0;   j<tablaTipos.length;    j++){
            boolean repetido = false;
            if (tablaTipos[j][i]==-1 || tablaTipos[j][i]==0) {
                for (Integer fortaleza : fortalezas) {
                    if (fortaleza == j) repetido = true;
                }
                if (!repetido)  fortalezas.add(j);
            }
        }

    }

    //Una vez cargadas las dos listas, se comparan y se eliminan todos los elementos que tengan en común.
    static void comparar(List<Integer> deb, List<Integer> fort){
        for (int i=0;   i<deb.size()-1;   i++) {
            for (int j=0;   j<fort.size()-1;  j++) {
                if (deb.get(i).equals(fort.get(j))){
                    for (int k = 0; k < deb.size() - 1; k++) {
                        if (deb.get(k).equals(deb.get(i)))  {
                            deb.remove(k);
                        }
                    }
                    for (int k = 0; k < fort.size() - 1; k++) {
                        if (fort.get(k).equals(fort.get(j))) {
                            fort.remove(k);
                        }
                    }
                }
            }
        }
    }

    //Se carga un string con todos los elementos necesarios (que variaran dependiendo de si se pasa la lista de debilidades o la de fortalezas), y se envia ese string para ser impreso.
    static String imprimir(List<Integer> a){
        String esc = "";

        for (int x : a) {
            switch (x){
                case 0: esc += "[AGUA] "; break;
                case 1: esc += "[BICHO] "; break;
                case 2: esc += "[DRAGON] "; break;
                case 3: esc += "[ELECTRICO] "; break;
                case 4: esc += "[FANTASMA] "; break;
                case 5: esc += "[FUEGO] "; break;
                case 6: esc += "[HIELO] "; break;
                case 7: esc += "[LUCHA] "; break;
                case 8: esc += "[NORMAL] "; break;
                case 9: esc += "[PLANTA] "; break;
                case 10: esc += "[PSIQUICO] "; break;
                case 11: esc += "[ROCA] "; break;
                case 12: esc += "[TIERRA] "; break;
                case 13: esc += "[VENENO] "; break;
                case 14: esc += "[VOLADOR] "; break;
                default: esc += "Easter Egg!";

            }
        }
        return esc;
    }

}
