package Runner;

import logic.Lista;
import model.Movie;
import logic.TreeBinary;

import javax.swing.*;

public class Main {


    Lista<Movie> listado = new Lista<>();
    TreeBinary<Movie> arbolinhio = new TreeBinary<>(((Id1, Id2) -> (Id1.getId().compareTo(Id2.getId()))));
    public void menu(){

        int opc = 0;

        Movie movie = null;

        while(opc !=6){

            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "*****MENU PRINCIPAL*****\n"+
                    "1. Agregar pelicula\n" +
                    "2. Eliminar pelicula\n" +
                    "3. Buscar pelicula\n" +
                    "4. Mostrar lista a partir de un nodo\n" +
                    "5. Ver lista de peliculas\n" +
                    "6. Salir"));

            switch (opc){
                case 1:

                    String id = JOptionPane.showInputDialog(null, "Ingrese id de la pelicula");
                    String name = JOptionPane.showInputDialog(null, "Ingrese nombre de la pelicula");
                    String duracion = JOptionPane.showInputDialog(null, "Ingrese duracion de la pelicula");
                    String director = JOptionPane.showInputDialog(null, "Ingrese director de la pelicula");
                    movie = new Movie(id, name, duracion, director);
                    listado.addList(movie);
                    arbolinhio.addNode(movie);

                    break;
                case 2:
                    String id1 = JOptionPane.showInputDialog(null, "Ingrese id de la pelicula a eliminar");
                    break;
                case 3:
                    String id2 = JOptionPane.showInputDialog(null, "Ingrese id de la pelicula a buscar");
                    break;

                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Thanks, bye :)");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }

        }

    }

    public static void main (String[]args){
        Main main = new Main ();
        main.menu();
    }

}
