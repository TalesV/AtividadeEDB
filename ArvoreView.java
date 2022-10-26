package imd.edb;

public class ArvoreView {
	public static void main(String[] args) {
		Tree tree = new Tree();
		int[] items = {5, 8, 6, 3, 9};
		
		for (int i : items) {
			tree.insert(i);
		}
		
		int[] items2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		Tree tree2 = new Tree();
		for (int i : items2) {
			tree.insert(i);
		}	
		
		System.out.println("Arvore Altura: " + tree.getAltura());
		System.out.println("Arvore Tamanho: " + tree.getTamanho());
		
		tree.preordem();
		
		tree2.remove(3);
		
		tree2.preordem();
	}
}
