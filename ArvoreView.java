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
        int size = linhaArray.length;
        int [] linhaInt = new int [size];
        for(int i=0; i<size; i++) {
           linhaInt[i] = Integer.parseInt(linhaArray[i]);
        }


        Tree tree = new Tree();

        for (int i : linhaInt) {
            tree.insert(i);
        }
		
		tree.imprimeArvore(1);
		tree.imprimeArvore(2);
			
		//System.out.println("Quantidade de Nodes: " + tree.contadorNodes());
		
		tree.preordem();
		
		tree.preordem();
		
		System.out.println();
		
		tree.enesimoElemento(3);
		
		tree.Buscar(20);
		//System.out.println("Quantidade de Nodes: " + tree.contadorNodes());
		
	}
}
