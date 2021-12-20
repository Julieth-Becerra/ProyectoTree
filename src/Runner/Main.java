package Runner;

import logic.Lista;
import logic.Node;
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
                    listado.delete(new Movie(id1));
                    arbolinhio = new TreeBinary<>(((Id1, Id2) -> (Id1.getId().compareTo(Id2.getId()))));
                    listado.recorrerRaiz().forEach(e-> arbolinhio.addNode(e.getInfo()));
                    break;
                case 3:
                    String id2 = JOptionPane.showInputDialog(null, "Ingrese id de la pelicula a buscar");
                    JOptionPane.showMessageDialog(null, arbolinhio.findNode(new Movie(id2)).getInfo());
                    break;
                case 4:
                    String id3 = JOptionPane.showInputDialog(null, "Ingrese id de la pelicula a partir de la cual se mostrara la lista");
                    String mostrar1 = "";
                    for (Node<Movie> e:listado.recorrerRaiz()
                    ) {
                        mostrar1+=e.getInfo()+"\n";
                    }
                    mostrar1 ="";
                    JOptionPane.showMessageDialog(null, mostrar1);
                    break;
                case 5:
                    String mostrar = "";
                    for (Node<Movie> e:listado.recorrerRaiz()
                         ) {
                        mostrar+=e.getInfo()+"\n";
                    }
                    JOptionPane.showMessageDialog(null, mostrar);
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
