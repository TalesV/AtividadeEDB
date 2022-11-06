package imd.edb;
import java.text.DecimalFormat;
public class Arvore {

	protected static No raiz;
	
	private void attQuantEsqDir(No atual) {
		if(atual.filhoEsq != null) {
			attQuantEsqDir(atual.filhoEsq);
		}
		if(atual.filhoDir != null) {
			attQuantEsqDir(atual.filhoDir);
		}
		if(atual.filhoEsq != null && atual.filhoDir != null) {
			atual.quantEsq = atual.filhoEsq.quantEsq + atual.filhoEsq.quantDir + 1;
			atual.quantDir = atual.filhoDir.quantEsq + atual.filhoDir.quantDir + 1;
		}
		else if(atual.filhoEsq != null && atual.filhoDir == null) {
			atual.quantEsq = atual.filhoEsq.quantEsq + atual.filhoEsq.quantDir + 1;
			atual.quantDir = 0;
		}
		else if(atual.filhoEsq == null && atual.filhoDir != null) {
			atual.quantEsq = 0;
			atual.quantDir = atual.filhoDir.quantEsq + atual.filhoDir.quantDir + 1;
		}
		else {
			atual.quantEsq = 0;
			atual.quantDir = 0;
		}
	}
	private void attAltura(No atual) {
		if(atual.filhoEsq != null) {
			atual.filhoEsq.altura = atual.altura - 1;
			attAltura(atual.filhoEsq);
		}
		if(atual.filhoDir != null) {
			atual.filhoDir.altura = atual.altura - 1;
			attAltura(atual.filhoDir);
		}
	}
	private void attElementos() {
		raiz.altura = getAltura(raiz);
		attAltura(raiz);
		attQuantEsqDir(raiz);
	}
	
	private void buscar(int n) {
		if(raiz.buscar(n) == true) {
			System.out.println("Chave encontrada");
		}
		else {
			System.out.println("Chave não encontrada");
		}
	}
	
	public void inserir(int val) {
		if (raiz == null) {
			raiz = new No(val);
		}
		else 
			raiz.inserir(val);
		attElementos(); //atualiza altura, quantEsq e quantDir após a inserção
	}
	private int getAltura(No atual) {
		int altEsq = 0, altDir = 0;

		if (atual.filhoEsq != null)
			altEsq = getAltura(atual.filhoEsq);

		if (atual.filhoDir != null)
			altDir = getAltura(atual.filhoDir);

		return 1 + Math.max(altEsq, altDir);
	}
	//Esse método serve para uma linha do remover
	private No no_sucessor(No delete) {
		No successorpai = delete;
		No sucessor = delete;
		No atual = delete.filhoDir; 

		while (atual != null) { 
			successorpai = sucessor;
			sucessor = atual;
			atual = atual.filhoEsq;
		} 
		if (sucessor != delete.filhoDir) { 
			successorpai.filhoEsq = sucessor.filhoDir; 
			sucessor.filhoDir = delete.filhoDir; 

		}
		return sucessor;
	}
	
	private boolean remover(int data) {

		if (raiz == null) {
			return false; 
		}

		No atual = raiz;
		No pai = raiz;
		boolean filhoEsq = true;
		while (atual.data != data) {
			pai = atual;
			if(data < atual.data ) { 
				atual = atual.filhoEsq;
				filhoEsq = true;
			}
			else {
				atual = atual.filhoDir; 
				filhoEsq = false;
			}
			if (atual == null) {
				System.out.println(data+" não está na árvore, não pode ser removido!");
				return false; 
			}
		} 

		if (atual.filhoEsq == null && atual.filhoDir == null) {
			if (atual == raiz ) {
				raiz = null;
			}
			else if (filhoEsq) {
				pai.filhoEsq = null; 
			}
			else {
				pai.filhoDir = null; 
			}
		}

		else if (atual.filhoDir == null) {
			if (atual == raiz) {
				raiz = atual.filhoEsq; 
			}
			else if (filhoEsq) {
				pai.filhoEsq = atual.filhoEsq;
			}
			else {
				pai.filhoDir = atual.filhoEsq; 
			}
		}

		else if (atual.filhoEsq == null) {
			if (atual == raiz) {
				raiz = atual.filhoDir;
			}
			else if (filhoEsq) {
				pai.filhoEsq = atual.filhoDir;
			}
			else {
				pai.filhoDir = atual.filhoDir; 
			}
		}

		else {
			No sucessor = no_sucessor(atual);
			if (atual == raiz) raiz = sucessor;
			else if(filhoEsq) pai.filhoEsq = sucessor; 
			else pai.filhoDir = sucessor; 
			sucessor.filhoEsq = atual.filhoEsq; 

		}
		System.out.println(data+" Removido!");
		attElementos();//atualiza altura, quantEsq e quantDir após a remoção
		return true;
	}
	
	private void enesimoElemento (int n) {
		System.out.println("A posição " +n+" é: "+
				raiz.enesimoElemento(n));
	}
	
	private void posicao(int n) {
		if(raiz.posicao(n) <= 0) {
			System.out.println("O elemento não faz parte da arvore.");
		}
		else {
			System.out.println("O elemento "
					+ n + " esta na " + raiz.posicao(n)+"ª posicao!");
		}
	}
	
	private void mediana() {
		System.out.println("Mediana: " + raiz.mediana());
	}
	
	private void media(int x) {
		DecimalFormat format = new DecimalFormat("#.###");
		System.out.println("Media: "+ format.format(raiz.media(x)));

	}
	
	private void ehCheia() {
		int nosArvore = (raiz.quantEsq + raiz.quantDir + 1);
		int totalNos = (int)(Math.pow(2, raiz.altura) - 1);
		if(nosArvore == totalNos) {
			System.out.println("A árvore é cheia!");
		}
		else
			System.out.println("A árvore não é cheia!");
	}
	
	private int completa(No atual, int flag) {
		if(atual.altura > 2) {
			if(atual.filhoEsq == null || atual.filhoDir == null) {
				flag += 1;
			}
			if(atual.filhoEsq != null) {
				if(atual.filhoEsq.altura > 1)
					flag = completa(atual.filhoEsq, flag);
			}
			if(atual.filhoDir != null) {
				if(atual.filhoEsq.altura > 1)
					flag = completa(atual.filhoDir, flag);
			}
		}
		return flag;
	}
	
	private void ehCompleta() {
		if(completa(raiz, 0) > 0) {
			System.out.println("A árvore não é completa!");
		}
		else
			System.out.println("A árvore é completa!");
	}
	
	private void preordem() {
		if (raiz != null) {
			System.out.println();
			System.out.print("Pre Ordem: ");
			raiz.preordem();
			System.out.println();
		}
	}

	private void imprimeArvore(int s){
		switch(s){
		//caso "s" == 1
		//chama metodo que imprime no formato 1
		case 1:
			System.out.println("Formato 1:");
			raiz.imprimeCaso1("\n");
			System.out.println();
			break;

			//caso "s" == 2
			//chama metodo que imprime no formato 2 
		case 2:
			System.out.println("Formato 2:");
			raiz.imprimeCaso2();
			System.out.println();
			System.out.println();

			break;
			// caso não seja um parametro aceito
		default:
			System.out.println("Valor inserido para impressão inválido!");

		}
	}

	public void metodo(String metodo, String parametro) {
		if(metodo.equals("BUSCAR") && !parametro.equals("")) {
			int n = Integer.parseInt(parametro);
			buscar(n);
		}
		else if(metodo.equals("INSIRA") && !parametro.equals("")) {
			int n = Integer.parseInt(parametro);
			inserir(n);
		}
		else if(metodo.equals("REMOVA") && !parametro.equals("")) {
			int n = Integer.parseInt(parametro);
			remover(n);
		}
		else if(metodo.equals("ENESIMO") && !parametro.equals("")) {
			int n = Integer.parseInt(parametro);
			enesimoElemento(n);
		}
		else if(metodo.equals("POSICAO") && !parametro.equals("")) {
			int n = Integer.parseInt(parametro);
			posicao(n);
		}
		else if(metodo.equals("MEDIANA") && parametro.equals("")) {
			mediana();
		}
		else if(metodo.equals("MEDIA") && !parametro.equals("")) {
		int n = Integer.parseInt(parametro);
		media(n);
		}
		else if(metodo.equals("CHEIA") && parametro.equals("")) {
			ehCheia();
		}
		else if(metodo.equals("COMPLETA") && parametro.equals("")) {
			ehCompleta();
		}
		else if(metodo.equals("PREORDEM") && parametro.equals("")) {
			preordem();
		}
		else if(metodo.equals("IMPRIMA") && !parametro.equals("")) {
			int n = Integer.parseInt(parametro);
			imprimeArvore(n);
		}
		else {
			System.out.println("Esse método " + metodo + " não foi implementado!");
		}
	}
}
