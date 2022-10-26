package imd.edb;

public class Node {
    protected Node leftChild;
    protected Node rightChild;
    protected int data;

    public Node(int val) {
        data = val;
        leftChild = null;
        rightChild = null;  
    }
    
    public int getData() {
        return data;
    }
    
    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
    

    public void setData(int valor) {
        this.data = valor;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void insert(int val) {
        if (val < this.data) {
            if (this.leftChild == null) {
                this.leftChild = new Node(val);
            }
            else 
                this.leftChild.insert(val);
        }
        else if (val > this.data) {
            if (this.rightChild == null) {
                this.rightChild = new Node(val);
            }
            else
                this.rightChild.insert(val);
        }
    }
    
    public int getAltura() {
        int alturaEsq = 0, alturaDir = 0;
        
        if (this.leftChild != null)
            alturaEsq = this.leftChild.getAltura();
                    
        if (this.rightChild != null)
            alturaDir = this.rightChild.getAltura();
        
        return 1 + Math.max(alturaEsq, alturaDir);
    }
    public boolean ehCompleta() {
        /*
         * Achar a altura dos nodos, se os nodos de altura 
         * menor que (getAltura() - 1) tiverem this.leftchild
         * ou this.rightchild == null ela não é completa.
         */
        return true;
    }
    
    public boolean ehCheia() {
        /*
        * Achar a altura dos nodos, se os nodos de altura 
        * menor que (getAltura()) tiverem this.leftchild
        * ou this.rightchild == null ela não é completa.
         */
        return true;
    }
    public int getTamanho() {
        int alturaEsq = 0, alturaDir = 0;
        
        if (this.leftChild != null)
            alturaEsq = this.leftChild.getTamanho();
                    
        if (this.rightChild != null)
            alturaDir = this.rightChild.getTamanho();
        
        return 1 + alturaEsq + alturaDir;           
    }
    
    public void preordem() {
        if (this != null) {
            System.out.print(this.data + " ");
            if (this.leftChild != null)
                this.leftChild.preordem();
            if (this.rightChild != null)
                this.rightChild.preordem();
        }
    }
    
    public int minimo() {

        if (leftChild == null)

              return data;

        else

              return leftChild.minimo();

  }
    
    public boolean remove(int value, Node parent) {

        if (value < this.data) {

              if (leftChild != null)

                    return leftChild.remove(value, this);

              else

                    return false;

        } else if (value > this.data) {

              if (rightChild != null)

                    return rightChild.remove(value, this);

              else

                    return false;

        } else {

              if (leftChild != null && rightChild != null) {

                    this.data = rightChild.minimo();

                    rightChild.remove(this.data, this);

              } else if (parent.leftChild == this) {

                    parent.leftChild = (leftChild != null) ? leftChild : rightChild;

              } else if (parent.rightChild == this) {

                    parent.rightChild = (leftChild != null) ? leftChild : rightChild;

              }

              return true;

        }

  }



    
}
