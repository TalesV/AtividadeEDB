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
	
	public void buscar(int n) {
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
		No successorFather = delete;
		No sucessor = delete;
		No current = delete.filhoDir; 

		while (current != null) { 
			successorFather = sucessor;
			sucessor = current;
			current = current.filhoEsq;
		} 
		if (sucessor != delete.filhoDir) { 
			successorFather.filhoEsq = sucessor.filhoDir; 
			sucessor.filhoDir = delete.filhoDir; 

		}
		return sucessor;
	}
	
	public boolean remover(int data) {

		if (raiz == null) {
			return false; 
		}

		No current = raiz;
		No father = raiz;
		boolean filhoEsq = true;
		while (current.data != data) {
			father = current;
			if(data < current.data ) { 
				current = current.filhoEsq;
				filhoEsq = true;
			}
			else {
				current = current.filhoDir; 
				filhoEsq = false;
			}
			if (current == null) {
				System.out.println(data+" não está na árvore, não pode ser removido!");
				return false; 
			}
		} 

		if (current.filhoEsq == null && current.filhoDir == null) {
			if (current == raiz ) {
				raiz = null;
			}
			else if (filhoEsq) {
				father.filhoEsq = null; 
			}
			else {
				father.filhoDir = null; 
			}
		}

		else if (current.filhoDir == null) {
			if (current == raiz) {
				raiz = current.filhoEsq; 
			}
			else if (filhoEsq) {
				father.filhoEsq = current.filhoEsq;
			}
			else {
				father.filhoDir = current.filhoEsq; 
			}
		}

		else if (current.filhoEsq == null) {
			if (current == raiz) {
				raiz = current.filhoDir;
			}
			else if (filhoEsq) {
				father.filhoEsq = current.filhoDir;
			}
			else {
				father.filhoDir = current.filhoDir; 
			}
		}

		else {
			No sucessor = no_sucessor(current);
			if (current == raiz) raiz = sucessor;
			else if(filhoEsq) father.filhoEsq = sucessor; 
			else father.filhoDir = sucessor; 
			sucessor.filhoEsq = current.filhoEsq; 

		}
		System.out.println(data+" Removido!");
		attElementos();//atualiza altura, quantEsq e quantDir após a remoção
		return true;
	}
	
	public void enesimoElemento (int n) {
		System.out.println("A posição " +n+" é: "+
				raiz.enesimoElemento(n));
	}
	
	public void posicao(int n) {
		if(raiz.posicao(n) <= 0) {
			System.out.println("O elemento não faz parte da arvore.");
		}
		else {
			System.out.println("O elemento "
					+ n + " esta na " + raiz.posicao(n)+"ª posicao!");
		}
	}
	
	public void mediana() {
		System.out.println(raiz.mediana());
	}
	
	public void media(int x) {
		DecimalFormat format = new DecimalFormat("#.###");
		System.out.println(format.format(raiz.media(x)));

	}
	
	public void ehCheia() {
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
	
	public void ehCompleta() {
		if(completa(raiz, 0) > 0) {
			System.out.println("A árvore não é completa!");
		}
		else
			System.out.println("A árvore é completa!");
	}
	
	public void preordem() {
		if (raiz != null) {
			System.out.println();
			System.out.print("Pre Ordem: ");
			raiz.preordem();
			System.out.println();
		}
	}

	public void imprimeArvore(int s){
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
}
