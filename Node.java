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
    
    public void imprimeCase1(String ident) {
        if (this != null) {
            System.out.print(ident + this.data);
            System.out.println();
            if (this.leftChild != null) {
                this.leftChild.imprimeCase1(ident + "\t");
            }
            if (this.rightChild != null) {
                this.rightChild.imprimeCase1(ident + "\t");
            }
        }
    }
    
    public void imprimeCase2() {
        if (this != null) {
            System.out.print("("+this.data);
            if (this.leftChild != null) {
                this.leftChild.imprimeCase2();
            }
            if (this.rightChild != null)
                this.rightChild.imprimeCase2();
            System.out.print(")");
        }
    }
    
    public boolean remove(Node parente, int data) {

        if (data < this.data) {
        	if (leftChild != null) {
        		return leftChild.remove(this, data);
              }
        	else {
        		return false;
        	}
        } 
        else if (data > this.data) {
        	if (rightChild != null) {
        		return rightChild.remove(this, data);
        	}
        	else{
        		return false;
        	}
        } 
        else {
        	if (leftChild != null && rightChild != null) {
        		this.data = rightChild.minimo();
                rightChild.remove(this, this.data);
            } 
        	else if (parente.leftChild == this) {
        		if(leftChild != null) {
        			parente.leftChild = leftChild;
        		}
        		else {
        			parente.leftChild = rightChild;
        		}
            } 
        	else if (parente.rightChild == this) {
        		if(parente.leftChild != null) {
        			parente.rightChild = leftChild;
        		}
        		else {
        			parente.rightChild = rightChild;
        		}
            }
        	return true;
        }
  }
}
