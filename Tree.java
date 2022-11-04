package imd.edb;

public class Tree {
    
    protected static Node root;
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        }
        else 
            root.insert(val);
        	System.out.println(val  + " Adicionado!");
    }
    
    public void preordem() {
        if (root != null) {
            System.out.println();
            System.out.print("Pre Ordem: ");
            root.preordem();
            System.out.println();
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
                System.out.println("Valor inserido para impressão inválido!");

        }
    }
    
    public void ehCompleta() {
    	if(root.ehCompleta()) {
    		System.out.println("A árvore é completa.");
    	}
    	else {
    		System.out.println("A árvore não é completa.");
    	}
    }
    
    public void ehCheia() {
    	if(root.ehCheia()) {
    		System.out.println("A árvore é cheia.");
    	}
    	else {
    		System.out.println("A árvore não é cheia.");
    	}
    }
    
    public boolean remover(int data) {
        
    	if (root == null) {
        	return false; 
        }

        Node current = root;
        Node father = root;
        boolean leftChild = true;

        while (current.data != data) {
          father = current;
          if(data < current.data ) { 
            current = current.leftChild;
            leftChild = true;
          }
          else {
            current = current.rightChild; 
            leftChild = false;
          }
          if (current == null) return false; 
        } 

        if (current.leftChild == null && current.rightChild == null) {
          if (current == root ) {
        	  root = null;
          }
          else if (leftChild) {
        	  father.leftChild = null; 
          }
          else {
        	  father.rightChild = null; 
          }
        }

        else if (current.rightChild == null) {
           if (current == root) {
        	   root = current.leftChild; 
           }
           else if (leftChild) {
        	   father.leftChild = current.leftChild;
           }
           else {
        	   father.rightChild = current.leftChild; 
           }
        }
        
        else if (current.leftChild == null) {
           if (current == root) {
        	   root = current.rightChild;
           }
           else if (leftChild) {
        	   father.leftChild = current.rightChild;
           }
           else {
        	   father.rightChild = current.rightChild; 
           }
        }

        else {
          Node sucessor = no_sucessor(current);
          if (current == root) root = sucessor;
          else if(leftChild) father.leftChild = sucessor; 
               else father.rightChild = sucessor; 
          sucessor.leftChild = current.leftChild; 
                                    
        }

        return true;
      }
    
    public Node no_sucessor(Node delete) {
        Node successorFather = delete;
        Node sucessor = delete;
        Node current = delete.rightChild; 

        while (current != null) { 
          successorFather = sucessor;
          sucessor = current;
          current = current.leftChild;
        } 
        if (sucessor != delete.rightChild) { 
          successorFather.leftChild = sucessor.rightChild; 
          sucessor.rightChild = delete.rightChild; 
                                   
        }
        return sucessor;
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
    public void mediana() {
        System.out.println(root.mediana());
    }
    
    public void media(int x) {
    	if(root.media(x) == -2) {
    		System.out.println("O elemento não pertence a arvore.");
    	}
    	else if(root.media(x) == -1) {
    		System.out.println("O elemento não possui nós filhos.");
    	}
    	else {
    		System.out.println("A media e: "+ root.media(x));
    	}
    }
    public void enesimoElemento (int n) {
    	System.out.println("A posição " +n+" é: "+
    			root.enesimoElemento(n));
    }
    
    public void buscar(int n) {
    	root.Buscar(n);
    	if(root.Buscar(n) == true) {
    		System.out.println("Chave encontrada");
    	}
    	else {
    		System.out.println("Chave não encontrada");
    	}
    }
  
    public void posicao(int n) {
        if(root.posicao(n) <= 0) {
            System.out.println("O elemento não faz parte da arvore.");
        }
        else {
            System.out.println("O elemento "
                    + n + " esta na " + root.posicao(n)+"ª posicao!");
        }
    }
}
