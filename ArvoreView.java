package imd.edb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class ArvoreView {
    public static void main(String[] args) throws IOException {
    	
        //Instancia a arvore
        Arvore tree = new Arvore();
        
    	Path arquivo1 = Paths.get("arquivo1.txt");
    	List<String> linhasArquivo1 = Files.readAllLines(arquivo1);
    	for(String linha : linhasArquivo1) {
    		String[] splitedLinha = linha.split(" ");
    		for(String num : splitedLinha) {
	        	int i = Integer.parseInt(num);
	        	tree.inserir(i);
    		}
    	}

        
        Path arquivo2 = Paths.get("arquivo2.txt");
        
        List<String> linhasArquivo2 = Files.readAllLines(arquivo2);
        for(String linha : linhasArquivo2) {
        	String[] splitedLinha = linha.split(" ");
        	if(splitedLinha.length == 1)
        		tree.metodo(splitedLinha[0], "");
        	else
        		tree.metodo(splitedLinha[0], splitedLinha[1]);
        }
	}
}
