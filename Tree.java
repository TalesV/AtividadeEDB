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

                break;

            //caso "s" == 2
            //chama metodo que imprime no formato 2 
            case 2:

                break;
            // caso não seja um parametro aceito
            default:
                System.out.println("Valor inserido para impressão inválido");

        }
    }
    
    public Node delete(Node root, int key){
    	if(root == null) {
    		return root;
    	}
    	if(key > root.data) {
    		root.rightChild = delete(root.rightChild, key);
    	}
    	else if(key < root.data) {
    		root.leftChild = delete(root.rightChild, key);
    	}
    	else {
    		if(root.leftChild == null && root.rightChild == null) {
    			root = null;
    		}
    		else if(root.rightChild != null) {
    			root.data = sucessor(root);
    			root.rightChild = delete(root.rightChild, root.data);
    		}
    		else {
    			root.data = predecessor(root);
    			root.leftChild = delete(root.leftChild, root.data);
    		}
    	}
    	return root;
    }
    
    public int sucessor(Node root){
        root = root.rightChild;
        while(root.leftChild != null){
            root = root.leftChild;
        }
        return root.data;
    }
    
    private int predecessor(Node root){
        root = root.leftChild;
        while(root.rightChild != null){
            root = root.rightChild;
        }
        return root.data;
    }

	public void insert(char val) {
		if (root == null) {
            root = new Node(val);
        }
        else 
            root.insert(val);
	}
  
    
}
