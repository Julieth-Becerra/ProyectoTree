package model;

import java.util.Comparator;

public class Tree <T> {
    private Comparator<T> comparator;
    private Node<T> root;
    private int cont;

    public Tree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

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

    public int heigthNode(Node<T> n){
        cont = 0;
        heigth( n, 0 );

        return cont;
    }

    private void heigth(Node<T> node, int i) {
        if( node != null ){
            heigth( node.getLeft(), i + 1 );
            cont = i > cont ? i : cont;
            heigth( node.getRight(), i + 1 );
        }
    }
}
