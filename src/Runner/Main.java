package Runner;

import Control.Managment;
import logic.Lista;
import logic.Node;
import model.Movie;
import logic.TreeBinary;

import javax.swing.*;

public class Main {

    public void menu(){

        Managment mng = new Managment();

        int opc = 0;

        Movie movie = null;

        while(opc !=6){

            try {

                opc = Integer.parseInt(JOptionPane.showInputDialog(null, "**MENU PRINCIPAL**\n"+
                        "1. Agregar pelicula\n" +
                        "2. Eliminar pelicula\n" +
                        "3. Buscar pelicula\n" +
                        "4. Mostrar lista a partir de un nodo\n" +
                        "5. Ver lista de peliculas\n" +
                        "6. Salir"));
                if (opc >=7) {
                    JOptionPane.showMessageDialog(null, "Opción invalida, debe digitar un número menor o igual a 6");
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Opción invalida, debe digitar un valor numérico.", "error", JOptionPane.WARNING_MESSAGE);
            }

            switch (opc){
                case 1:

                    String id = JOptionPane.showInputDialog(null, "Ingrese id de la pelicula");
                    String name = JOptionPane.showInputDialog(null, "Ingrese nombre de la pelicula");
                    String duracion = JOptionPane.showInputDialog(null, "Ingrese duracion de la pelicula");
                    String director = JOptionPane.showInputDialog(null, "Ingrese director de la pelicula");
                    movie = new Movie(id, name, duracion, director);
                    mng.addList(id, name, duracion, director);
                    break;
                case 2:
                    String id1 = JOptionPane.showInputDialog(null, "Ingrese id de la pelicula a eliminar");
                    JOptionPane.showMessageDialog(null, mng.delete(id1) );
                    break;
                case 3:
                    String id2 = JOptionPane.showInputDialog(null, "Ingrese id de la pelicula a buscar");
                    JOptionPane.showMessageDialog(null, mng.findNodeTree(id2));
                    break;
                case 4:
                    String id3 = JOptionPane.showInputDialog(null, "Ingrese id de la pelicula a partir de la cual se mostrara la lista");
                    JOptionPane.showMessageDialog(null, mng.recorrerNodo(id3));
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, mng.getListContent());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Thanks, bye :)");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void main (String[]args){
        Main main = new Main ();
        main.menu();
    }

}
