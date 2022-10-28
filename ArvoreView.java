package imd.edb;

public class ArvoreView {
	public static void main(String[] args) {
		Tree tree = new Tree();
		int[] items = {5, 8, 6, 9, 3, 2, 4, 1};
		
		for (int i : items) {
			tree.insert(i);
		}
		
		tree.imprimeArvore(1);
		tree.imprimeArvore(2);
			
		//System.out.println("Quantidade de Nodes: " + tree.contadorNodes());
		
		tree.preordem();
		
		tree.preordem();
		
		System.out.println();
		
		System.out.println(tree.enesimoElemento(8));
		
		//System.out.println("Quantidade de Nodes: " + tree.contadorNodes());
		
	}
}
