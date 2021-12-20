/**
 * Paquete modelo
 */
package logic;

/**
 * Clase del nodo
 * @param <T> Informacion
 */
public class Node <T>{

    /**
     * Infromacion del nodo
     */
    private T info;
    /**
     * Nodo izquierdo
     */
    private Node<T> left;
    /**
     * Nodo derecho
     */
    private Node<T> right;

    /**
     * Altura del arbol
     */
    private int height;
    /**
     * Constructor de la clase donde se inicializan los atributos
     * @param info infromacion
     */
    public Node(T info){
      this.info = info;
      this.left = null;
      this.right = null;
      this.height = 0;
    }

    /**
     * Metodo para obtener la informacion
     * @return retorna la informacion
     */
    public T getInfo() {
        return info;
    }

    /**
     * Metodo para modificar la informacion
     * @param info informacion modificada
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Metodo para obtener el nodo izquierdo
     * @return retorna el nodo izquierdo
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Metodo para modificar el nodo izquierdo
     * @param left nodo modificado
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * Metodo para obtener el  nodo derecho
     * @return retorna el nodo derecho
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * Metodo para modificar el nodo derecho
     * @param right nodo modificado
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * Metodo para obtener la altura
     * @return altura
     */
    public int getHeight() {
        return height;
    }

    /**
     * Metodo para modificar la altura
     * @param height altura a modificar
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
