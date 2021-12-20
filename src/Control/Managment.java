/**
 * Paquete control
 */
package Control;

import logic.Lista;
import logic.Node;
import logic.TreeBinary;
import model.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de manejo
 * @param <T> informacion
 */
public class Managment<T> {


    /**
     * lista circular de peliculas
     */
    private static Lista<Movie> lista = new Lista<>();
    /**
     * Arbol de peliculas
     */
    private static TreeBinary<Movie> arbol = new TreeBinary<>(((Id1, Id2) -> (Id1.getId().compareTo(Id2.getId()))));;
    /**
     * Objeto de tipo Movie
     */

    private Movie movie;


    /**
     * Constructor vacio de la clase
     */

    public Managment(){

    }

    /**
     * Metodo que controla añadir al arbol y a la lista
     * @param id id de la pelicula
     * @param name nombre de la pelicula
     * @param duracion duracion de la pelicula
     * @param director director de la pelicula
     */
    public void addList(String id, String name, String duracion, String director){
        movie = new Movie(id, name, duracion, director);

        lista.addList(movie);
        arbol.addNode(movie);
    }

    /**
     * Metodo que perminte gestionar la eliminacion de peliculas
     * @param id id de la pelicula
     * @return mensaje confirmacion de eliminado
     */

    public String delete(String id){
        movie = new Movie(id);
        String aux = "";

        try {
            String des = arbol.findNode(new Movie(id)).getInfo().toString();
            aux = "Se ha eliminado la pelicula: \n"+des;
            lista.delete(movie);
            arbol = new TreeBinary<>((((Id1, Id2) -> (Id1.getId().compareTo(Id2.getId())))));
            if(lista.getRoot() != null){
                lista.recorrerRaiz().forEach(e->arbol.addNode(e.getInfo()));
            }
        }catch (Exception e){
            aux = "No se ha encontrado una pelicula con ese registro";
        }

        return aux;
    }


    /**
     * Metodo para obtener el contenido de la lista
     * @return contenido de la lista
     */
    public String getListContent(){
        String ret = "";
        try {
            for (Node<Movie> movie :lista.recorrerRaiz()) {
                ret += movie.getInfo();
            }
        }catch (Exception e){
            ret = "No hay registros";
        }

        return ret;
    }

    /**
     * Metodo para buscar un nodo
     * @param id id de nodo a buscar
     * @return mensaje de confirmacion
     */
    public String findNodeTree(String id){
        String ret;
        try{
            ret = arbol.findNode(new Movie(id)).getInfo().toString();
        }catch (Exception e){
            ret = "No se ha encontrado la pelicula";
        }
        return ret;
    }

    /**
     * Metodoo que permite recorrer la lista a partir de un nodo
     * @param id id del nodo
     * @return lista a partir del nodo
     */
    public String recorrerNodo(String id){
        String aux = "";
        for (Node<Movie> movie :lista.recorrer(arbol.findNode(new Movie(id)))
             ) {
            aux = aux+movie.getInfo();
        }
        return aux;
    }

}
