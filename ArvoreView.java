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
        Arvore tree = new Arvore();
        
        //insere os itens na arvore
        for (int i : itens) {
            tree.inserir(i);
        }
		tree.ehCheia();
		tree.ehCompleta();
		tree.enesimoElemento(3);
		tree.inserir(36);
		tree.ehCheia();
		tree.preordem();
		tree.imprimeArvore(1);
		tree.imprimeArvore(2);
		tree.remover(50);
		tree.inserir(15);
		tree.inserir(39);
		tree.remover(32);
		tree.posicao(15);
		tree.inserir(39);
		tree.enesimoElemento(5);
		tree.mediana();
		tree.media(20);
		tree.media(36);
		tree.buscar(36);
		tree.inserir(25);
		tree.mediana();
        

	}
}
