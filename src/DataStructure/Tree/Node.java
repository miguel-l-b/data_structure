package DataStructure.Tree;

import DataStructure.ShallowOrDeepCopy;
public class Node<T extends Comparable<T>> extends EssentialNode<T> implements Cloneable, Comparable<T> {
    private T data;

    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        if(data == null) throw new IllegalArgumentException("the data cannot be null");
        this.data = data;
        left = null;
        right = null;
    }

    public Node(Node<T> left, T data, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    protected Node(Node<T> model) {
        if(model == null) throw new IllegalArgumentException("NodeBilateral model is null");
        this.data = model.data;
        this.left = model.left;
        this.right = model.right;
    }

    @Override
    public int compareTo(T data) {
        return this.data.compareTo(data);
    }

    public T getData() { return (T) ShallowOrDeepCopy.verifyAndCopy(data); }
    public Node<T> getLeft() { return left; }
    public Node<T> getRight() { return right; }
    
    public void setData(T data) { this.data = data; }
    public void setLeft(Node<T> left) { this.left = left; }
    public void setRight(Node<T> right) { this.right = right; }



    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null) return false;
        if(obj.getClass() != obj.getClass()) return false;

        if(!this.data.equals(((Node<?>) obj).data)) return false;
        if(!this.left.equals(((Node<?>) obj).left)) return false;
        if(!this.right.equals(((Node<?>) obj).right)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 23;

        hash = 3 * hash + this.data.hashCode();
        hash = 7 * hash + this.left.hashCode();
        hash = 11 * hash + this.right.hashCode();

        if(hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        return String.format("{ %s } L { %s } R { %s }", this.left, this.data, this.right);
    }
}