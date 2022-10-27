package imd.edb;

public class Tree {
    
    protected static Node root;
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        }
        else 
            root.insert(val);
    }

    public int getAltura() {
        if (root != null)
            return root.getAltura();
        else
            return 0;
    }
    
    public int getTamanho() {
        if (root != null)
            return root.getTamanho();
        else
            return 0;
    }
    
    public void preordem() {
        if (root != null) {
            System.out.println();
            System.out.print("Pre Ordem: ");
            root.preordem();
        }
    }
    
    public void imprimeArvore(int s){
        switch(s){
            //caso "s" == 1
            //chama metodo que imprime no formato 1
            case 1:
                System.out.println("Formato 1:");
                root.imprimeCase1("\n");
                System.out.println();
                break;

            //caso "s" == 2
            //chama metodo que imprime no formato 2 
            case 2:
            	System.out.println("Formato 2:");
                root.imprimeCase2();
                System.out.println();
                System.out.println();

                break;
            // caso não seja um parametro aceito
            default:
                System.out.println("Valor inserido para impressão inválido");

        }
    }
    
    public boolean remove(int data) {
    	if (root == null) {
    		return false;
    	}
        else {
        	if (root.data == data) {
        		
        		Node nodeAuxiliar = new Node(0);
                nodeAuxiliar.setLeftChild(root);
                boolean resultado = root.remove(nodeAuxiliar, data);
                root = nodeAuxiliar.leftChild;
                return resultado;

            } 
        	else {
        		return root.remove(null, data);
            }
        }
    }
    
    public int contadorNodes() {
    	
    	int contador = 0;
    	
    	if (root == null) {
    		return contador;
    	}
    	Node aux = root;
    	Node predecessor;
    	while(aux != null) {
    		if(aux.leftChild == null) {
    			contador++;
    			aux = aux.rightChild;
    		}
    		else {
    			predecessor = aux.leftChild;
    			
    			while(predecessor.rightChild != null && predecessor.rightChild != aux) {
    				predecessor = predecessor.rightChild;
    			}
    			
    			if(predecessor.rightChild == null) {
    				predecessor.rightChild = aux;
    				aux = aux.leftChild;
    			}
    			else {
    				predecessor.rightChild = null;
    				contador++;
    				aux = aux.rightChild;
    			}
    		}
    	}
    	return contador;	
    }

	public void insert(char val) {
		if (root == null) {
            root = new Node(val);
        }
        else 
            root.insert(val);
	}
  
    
}
