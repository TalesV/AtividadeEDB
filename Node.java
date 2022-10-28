package imd.edb;

public class Node {
    protected Node leftChild;
    protected Node rightChild;
    protected int data;
    protected int quantEsq;
    protected int quantDir;

    public Node(int val) {
        data = val;
        leftChild = null;
        rightChild = null;  
        quantEsq = 0;
        quantDir = 0;
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
    	if (val == this.data) {
    		System.out.println( val +" já está na árvore, não pode ser inserido");
    	}
    	else if (val < this.data) {
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
        if(this.leftChild != null) {
        	this.quantEsq = this.leftChild.quantEsq +
        			this.leftChild.quantDir + 1;
        }
        if(this.rightChild != null) {
        	this.quantDir = this.rightChild.quantEsq +
        			this.rightChild.quantDir + 1;
        }
        if(this.leftChild == null && this.rightChild == null) {
        	this.quantEsq = 0;
        	this.quantEsq = 0;
        }
    }
    
    public int enesimoElemento (int n) {
    	if(n == this.quantEsq + 1) {
    		return this.data;
    	}
    	else if(n < this.quantEsq + 1) {
    		return this.leftChild.enesimoElemento(n);
    	}
    	else {
    		return this.rightChild.enesimoElemento(
    				n - (this.quantEsq + 1));
    	}
    }
    
    public boolean Buscar(int n) {
    	boolean flag = false;
    	if(n == this.data) {
    		flag = true;
    	}
    	else if(n < this.data) {
    		if(this.leftChild != null) {
    			flag = this.leftChild.Buscar(n);
    		}
    	}
    	else {
    		if(this.rightChild != null) {
    			flag = this.rightChild.Buscar(n);
    		}
    	}
    	return flag;
    }
    
    public int Posicao(int n) {
    	if(n == this.data) {
    		return this.quantEsq +1;
    	}
    	else if(n < this.data) {
    		if(this.leftChild != null) {
    			return this.leftChild.Posicao(n);
    		}
    	}
    	else{
    		if(this.rightChild != null) {
    			return this.quantEsq + 1 +
    					this.rightChild.Posicao(n);
    		}
    	}
    	//Gambiarra
    	return -1000000;
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
            System.out.print(ident + this.data
            		+ "\tQuantEsq: "+ this.quantEsq
            		+ "\tQuantDir: "+ this.quantDir);
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
