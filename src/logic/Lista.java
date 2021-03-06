
/**
 * Paquete logica
 */

package logic;

import logic.Node;
import logic.TreeBinary;
import model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase lista circular
 * @param <T> Informacion
 */
public class Lista<T> {

    /**
     * Nodo raiz
     */
    private Node<T> root;

    /**
     * Arbol de tipo pelicula
     */

    TreeBinary<Movie> arbolinhio = new TreeBinary<>(((Id1, Id2) -> (Id1.getId().compareTo(Id2.getId()))));

    /**
     * Constructor de la clase donde se inicializa el atributo en null
     */

    public Lista(){
        this.root = null;
    }

    /**
     * Metodo que permite comprobar si la lista está vacia o no
     * @return valor de verdad
     */

    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Metodo que permite ingresar informacion a la lista
     * El metodo comprueba primero si la lista esta vacia
     * @param info informacion a ingresar a la lista
     */
    public void addList(T info){
        Node<T> data = new Node<>(info);
        if(isEmpty()){
            root = data;
            data.setRight(root);
            root = data;

        }else{
            Node<T> aux = root;
            while (aux.getRight() != root){
                aux = aux.getRight();
            }
            data.setRight(root);
            aux.setRight(data);
        }
    }

    /**
     * Metodo que permite buscar un elemento en la lista
     * Comprueba si la lista esta vacia
     * @param info informacion a buscar
     * @return nodo encontrado o null si no se encuentra
     */
    public Node<Movie> findNode(Movie info) {
        Node<Movie> aux = null;
        if (!isEmpty()){
            if(root.getInfo() == info){
                return (Node<Movie>)root;
            }else{
                aux = (Node<Movie>)root.getRight();
                while (aux != root){
                    if(aux.getInfo().getId().equalsIgnoreCase(info.getId())){
                        return  aux;
                    }
                    aux = aux.getRight();
                }
                aux = null;
            }
        }
        return aux;
    }

    /**
     * Metodo para saber el tamaño de la lista
     * @return tamaño de la lista
     */
    public int getSize(){
        int cont = 0;
        if(!isEmpty()){
            cont++;
            Node<T> aux = root;
            while (aux.getRight() != root){
                cont++;
                aux = aux.getRight();
            }
        }
        return cont;
    }

    /**
     * Metodo para borrar un elemento de la lista
     * @param info informacion del nodo a eliminar
     */
    public void delete(T info) {
        if (!isEmpty()) {
            Node<T> aux = root;
            if((root == root.getRight())){
                root.setRight(null);
                root = null;
            } else if (((Node<Movie>) root).getInfo().getId().equalsIgnoreCase(((Movie) info).getId())) {
                while (!((Node<Movie>) aux.getRight()).getInfo().getId().equalsIgnoreCase(((Node<Movie>) root).getInfo().getId())) {
                    aux = aux.getRight();
                }
                root = root.getRight();
                aux.setRight(aux.getRight().getRight());
            } else {
                while (!(((Node<Movie>) aux).getRight().getInfo().getId()).equalsIgnoreCase(((Node<Movie>) root).getInfo().getId())) {
                    if (((Node<Movie>) aux.getRight()).getInfo().getId().equalsIgnoreCase(((Movie) info).getId())) {
                        aux.setRight(aux.getRight().getRight());
                        break;
                    }
                    aux = aux.getRight();
                }
            }
        }
    }

    /**
     * Metodo que permite recorrer la lista desde raiz
     * @return raiz
     */
    public  List<Node<T>> recorrerRaiz(){
        return recorrer(root);
    }
    /**
     * Metodo que permite recorrer y mostrar la lista a partir de un nodo dado
     * @param nodo apartir del que se recorre y muestra la lista
     * @return lista a partir de un nodo
     */
    public List<Node<T>> recorrer(Node<T> nodo){
        List<Node<T>> nodos = null;
        if (!isEmpty()){
            nodos = new ArrayList<>();
            Node<T> aux = nodo.getRight();
            nodos.add(nodo);
            while (aux != nodo){
                nodos.add(aux);
                aux = aux.getRight();
            }
        }
        return nodos;
    }

    /**
     * Metodo para obtener la raiz
     * @return raiz
     */
    public Node<T> getRoot() {
        return root;
    }

}
