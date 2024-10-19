package tp2.ejercicio1;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    BinaryTree(T data) {
        this.data = data; 
    }
    public BinaryTree() {
		super();
	}
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(BinaryTree<T> leftChild) {
        this.leftChild = leftChild;
    }
    public BinaryTree<T> getRightChild() {
        return rightChild;
    }
    public void setRightChild(BinaryTree<T> rightChild) {
        this.rightChild = rightChild;
    }
    public void removeLeftChild() {
        leftChild = null;
    }
    public void removeRightChild() {
        rightChild = null;
    }
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
    public boolean isEmpty() {
        return leftChild == null && rightChild == null;
    }
    public boolean hasLeftChild() {
        return leftChild != null;
    }
    public boolean hasRightChild() {
        return rightChild != null;
    }

    public String toString() {
        return data.toString();
    }
    
}

