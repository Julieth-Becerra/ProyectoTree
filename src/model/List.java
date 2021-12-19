package model;

import java.util.ArrayList;

public class List <T> {
    private Node<T> root;

    public List(){
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

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

    public List<Node<T>> recorrerDesdeNodo(Node<T> node){
        List<Node<T>> nodos = null;
        if (!isEmpty()) {
            nodos = new ArrayList<>();
            Node<T> aux = node.getRight();
            while (aux != node){
                nodos.add(aux);
                aux = aux.getRight();
            }
        }
        return nodos;
    }
}
