/**
 * Paquete modelo
 */
package logic;

import logic.Node;

import java.util.Comparator;

/**
 * Clase Tree
 * @param <T> informacion
 */
public class TreeBinary <T> {

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
    public TreeBinary(Comparator<T> comparator) {
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

    public Node<T> getRoot(){
        return root;
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

    private Node<T> rebalance(Node<T> node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (heightNode(node.getRight().getRight()) > heightNode(node.getRight().getLeft())) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (heightNode(node.getLeft().getLeft()) > heightNode(node.getLeft().getRight())) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }
        return node;
    }
    public int getBalance(Node<T> node) {
        return (node == null) ? 0 : heightNode(node.getRight()) - heightNode(node.getLeft());
    }

    private Node<T> rotateLeft(Node<T> y) {
        Node<T> x = y.getRight();
        Node<T> z = x.getLeft();
        x.setLeft(y);
        y.setRight(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.getLeft();
        Node<T> z = x.getRight();
        x.setRight(y);
        y.setLeft(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node<T> node) {
        node.setHeight(1 + Math.max(heightNode(node.getLeft()), heightNode(node.getRight())));
    }
}
