package imd.edb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ArvoreView {
    public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        InputStream arquivo = new FileInputStream("arquivo1.txt");
        Reader isr = new InputStreamReader(arquivo);
        BufferedReader br = new BufferedReader(isr);
        String linhaString = br.readLine();
        br.close();
        String linhaArray[] = linhaString.split(" ");
        int quantidade = linhaArray.length;
        int [] itens = new int [quantidade];
        for(int i=0; i<quantidade; i++) {
           itens[i] = Integer.parseInt(linhaArray[i]);
        }
        //Instancia a arvore
        Tree tree = new Tree();
        
        //insere os itens na arvore
        for (int i : itens) {
            tree.insert(i);
        }
		
		tree.imprimeArvore(1);
		/*tree.imprimeArvore(2);
		
		System.out.println();
		tree.enesimoElemento(3);
		tree.preordem();
		
		
		tree.insert(15);
		tree.insert(39);
		tree.remover(32);
		tree.media(39);
		tree.preordem();
		tree.mediana();
		tree.media(32); // Possui dois nós filhos --> 13 e 41
		tree.media(41); // Possui um nó filho --> 60
		tree.media(60); // Não possui nós filhos
		tree.media(31); // Não pertence a árvore
		tree.media(13); // Caso problema --> 5 20. Deveria dar 12.5
		tree.buscar(20);*/
        tree.buscarNode(5);
        tree.buscar(5);
        tree.media(13);
        tree.quantSub(60);
		
	}
}
