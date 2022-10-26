package imd.edb;

public class ArvoreView {
	public static void main(String[] args) {
		Tree tree = new Tree();
		//int[] items = {6, 1, 2, 3, 4, 5, 0, 7, 8, 9};
		int[] items = {5, 8, 6, 3, 9};
		for (int i : items)
			tree.insert(i);
		
		System.out.println("Tree Height: " + tree.getAltura());
		System.out.println("Tree Size: " + tree.getTamanho());
		tree.preordem();
		
	}
}
