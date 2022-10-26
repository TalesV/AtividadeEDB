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
}
