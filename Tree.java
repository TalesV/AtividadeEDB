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
    
    public boolean remove(int value) {

        if (root == null)

              return false;

        else {

              if (root.data == value) {

                    Node auxRoot = new Node(0);

                    auxRoot.setLeftChild(root);

                    boolean result = root.remove(value, auxRoot);

                    root = auxRoot.leftChild;

                    return result;

              } else {

                    return root.remove(value, null);

              }

        }

  }

	public void insert(char val) {
		if (root == null) {
            root = new Node(val);
        }
        else 
            root.insert(val);
	}
  
    
}
