/**
 * Paquete modelo
 */
package model;

import java.util.Comparator;

/**
 * Clase Tree
 * @param <T> informacion
 */
public class Tree <T> {

    /**
     * Comparator de la clase
     */
    private Comparator<T> comparator;
    /**
     * Nodo raiz
     */
    private Node<T> root;
    /**
     * Contador
     */
    private int cont;

    /**
     * Constructor donde se inicializa el comparator y la raiz
     * @param comparator comparator
     */
    public Tree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    /**
     * Metodo que comprueba si el arbol esta vacio
     * @return valor de verdad
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Metodo que permite agregar un nodo al arbol
     * El metodo verifica primero si  el arbol esta vacio
     * @param info informacion del nodo a ingresar
     */

    public void addNode( T info ){
        Node<T> node = new Node<>( info );
        if( isEmpty()){
            root = node;
        }else{
            Node<T> aux = root;
            Node<T> ant = null;
            while( aux != null ){
                ant = aux;
                aux = comparator.compare(info, aux.getInfo() ) < 0 ? aux.getLeft() : aux.getRight();
            }
            if( comparator.compare(info,ant.getInfo()) < 0 ){
                ant.setLeft( node );
            }else{
                ant.setRight( node );
            }
        }
    }

    /**
     * Metodo que permite buscar un elemento en  el arbol
     * @param info Informacion del elemento a buscar
     * @return elemento encontrado o null si no se encuentra
     */

    public Node<T> findNode( T info ){
        Node<T> aux = root;
        while( aux != null ){
            if( comparator.compare( info, aux.getInfo()) == 0 ){

                return aux;
            }
            aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
        }

        return null;
    }

    /**
     * Metodo que permite conocer la altura de un nodo
     * @param n nodo del que se quiere conocer la altura
     * @return altura del nodo
     */
    public int heightNode(Node<T> n){
        cont = 0;
        height( n, 0 );

        return cont;
    }

    /**
     * Metodo recursivo para calcular la altura
     * @param node
     * @param i
     */
    private void height(Node<T> node, int i) {
        if( node != null ){
            height( node.getLeft(), i + 1 );
            cont = i > cont ? i : cont;
            height( node.getRight(), i + 1 );
        }
    }
}
