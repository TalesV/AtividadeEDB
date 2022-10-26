package imd.edb;

public class Tree {
	protected Node root;
	
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
}
