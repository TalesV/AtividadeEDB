package imd.edb;

public class ArvoreView {
	public static void main(String[] args) {
		Tree tree = new Tree();
		int[] items = {5, 8, 6, 3, 9};
		
		for (int i : items) {
			tree.insert(i);
		}
		
		tree.imprimeArvore(1);
		tree.imprimeArvore(2);
			
		System.out.println("Arvore Altura: " + tree.getAltura());
		System.out.println("Arvore Tamanho: " + tree.getTamanho());
		System.out.println("Quantidade de Nodes: " + tree.contadorNodes());
		
		tree.preordem();
		
		tree.remove(8);
		tree.remove(6);
		
		tree.preordem();
		
		System.out.println();
		
		System.out.println("Arvore Altura: " + tree.getAltura());
		System.out.println("Arvore Tamanho: " + tree.getTamanho());
		System.out.println("Quantidade de Nodes: " + tree.contadorNodes());
		
	}
}
