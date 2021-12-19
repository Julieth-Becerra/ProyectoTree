/**
 * Paquete modelo
 */
package model;

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
     * @return nodo encontrado
     */
    public Node<T> findNode(T info) {
        Node<T> aux = null;
        if (!isEmpty()){
            if(root.getInfo() == info){
                return root;
            }else{
                aux = root.getRight();
                while (aux != root){
                    if(aux.getInfo() == info){
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
            if (root.getInfo() == info) {
                while
                (aux.getRight() != root) {
                    aux = aux.getRight();
                }
                root = root.getRight();
                aux.setRight(aux.getRight().getRight());
            } else {
                while (aux.getRight() != root) {
                    if (aux.getRight().getInfo() == info) {
                        aux.setRight(aux.getRight().getRight());
                        break;
                    }
                    aux = aux.getRight();
                }
            }
        }
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
            while (aux != nodo){
                nodos.add(aux);
                aux = aux.getRight();
            }
        }
        return nodos;
    }

}
