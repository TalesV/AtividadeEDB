package edb;

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
    public void remove(int data) {
    	if (root == null) {
    		System.out.println("Árvore vazia");
    	}
        else {
        	if (root.data == data) {
        		
        		Node nodeAuxiliar = new Node(0);
                nodeAuxiliar.setLeftChild(root);
                boolean resultado = root.remove(nodeAuxiliar, data);
                root = nodeAuxiliar.leftChild;
                if (resultado == true) {
                	System.out.println(data +" Removido");
                }
            } 
        	else {
        		 boolean resulta = root.remove(null, data);
        		 if (resulta == true) {
                 	System.out.println(data +" Removido");
                 }
                 else {
                 	System.out.println(data +" não está na árvore, não pode ser removido");
                 }
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
    public void Mediana() {
        System.out.println(root.Mediana());
    }
    
    public void Media(int x) {
    	if(root.Media(x) == -2) {
    		System.out.println("O elemento não pertence a arvore.");
    	}
    	else if(root.Media(x) == -1) {
    		System.out.println("O elemento não possui nós filhos.");
    	}
    	else {
    		System.out.println("A media e: "+ root.Media(x));
    	}
    }
    public void enesimoElemento (int n) {
    	System.out.println("A posição " +n+" é: "+
    			root.enesimoElemento(n));
    }
    
    public void Buscar(int n) {
    	root.Buscar(n);
    	if(root.Buscar(n) == true) {
    		System.out.println("Chave encontrada");
    	}
    	else {
    		System.out.println("Chave não encontrada");
    	}
    }
  
    public void Posicao(int n) {
        if(root.Posicao(n) <= 0) {
            System.out.println("O elemento não faz parte da arvore.");
        }
        else {
            System.out.println("O elemento "
                    + n + " esta na " + root.Posicao(n)+"ª posicao!");
        }
    }
}
