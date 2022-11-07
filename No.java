package imd.edb;

public class No {
	protected No filhoEsq;
	protected No filhoDir;
	protected int data;
	protected int quantEsq;
	protected int quantDir;
	protected int altura;

	
	// Construtor da classe Nó.
	public No(int val) { 
		data = val;
		filhoEsq = null;
		filhoDir = null;  
		quantEsq = 0;
		quantDir = 0;
		altura = 1;
	}
	
	// Método que diz se um nó está ou não na árvore.
	public boolean buscar(int n) {
		boolean flag = false;
		if(n == this.data) {
			flag = true;
		}
		else if(n < this.data) {
			if(this.filhoEsq != null) {
				flag = this.filhoEsq.buscar(n);
			}
		}
		else {
			if(this.filhoDir != null) {
				flag = this.filhoDir.buscar(n);
			}
		}
		return flag;
	}
	
	// Insere nós na árvore, e atenta se o nó já existe.
	public void inserir(int val) {
		if (val == this.data) {
			System.out.println( val +" já está na árvore, não pode ser inserido");
		}
		else if (val < this.data) {
			if (this.filhoEsq == null) {
				this.filhoEsq = new No(val);
				System.out.println(val + " Adicionado!");
			}
			else {
				this.filhoEsq.inserir(val);
			}
		}
		else if (val > this.data) {
			if (this.filhoDir == null) {
				this.filhoDir = new No(val);
				System.out.println(val + " Adicionado!");
			}
			else {
				this.filhoDir.inserir(val);

			}
		}        
	}

	// Retorna o n-ésimo elemento (contando a partir de 1) do percirso em ordem da ABB.
	public int enesimoElemento (int n) {
		if(n == this.quantEsq + 1) {
			return this.data;
		}
		else if(n < this.quantEsq + 1) {
			return this.filhoEsq.enesimoElemento(n);
		}
		else {
			return this.filhoDir.enesimoElemento(
					n - (this.quantEsq + 1));
		}
	}

	// Retorna a posição ocupada pelo elemento x em um percurso em ordem simétrica na ABB (contando a partir de 1).
	public int posicao(int n) {
		if(n == this.data) {
			return this.quantEsq +1;
		}
		else if(n < this.data) {
			if(this.filhoEsq != null) {
				return this.filhoEsq.posicao(n);
			}
		}
		else{
			if(this.filhoDir != null) {
				return this.quantEsq + 1 +
						this.filhoDir.posicao(n);
			}
		}
		return -1;
	}

	// Retorna o elemento que contém a mediana da ABB. Se a ABB possuir um número par de elementos, retorne o menor dentre os dois elementos medianos.
	public int mediana() {
		int tamanho = this.quantEsq + this.quantDir + 1;
		if(tamanho % 2 == 1)
			return this.enesimoElemento(tamanho/2 + 1);
		else {
			return this.enesimoElemento(tamanho/2);
		}
	}
	
	// Retorna o nó que possui o dado n, utilizado no método "media".
	private No buscarNo(int n) {
		No aux = null;
		if(n == this.data) {
			aux = this;
		}
		else if(n < this.data) {
			if(this.filhoEsq != null) {
				aux = this.filhoEsq.buscarNo(n);
			}
		}
		else {
			if(this.filhoDir != null) {
				aux = this.filhoDir.buscarNo(n);
			}
		}
		return aux;
	}

	// Retorna a soma dos valores da uma sub-árvore, o parâmetro será a raiz da sub-árvore que será somada. Implementado no método "media".
	private int soma(No atual)
	{
		if (atual == null)
			return 0;
		return (atual.data + soma(atual.filhoEsq) +
				soma(atual.filhoDir));
	}
	
	// Retorna a média aritmética dos nós da árvore que x é a raiz.
	public double media(int x) {
		double soma = soma(buscarNo(x));
		double quantNo = buscarNo(x).quantEsq + buscarNo(x).quantDir + 1;
		double media = soma/quantNo;
		return media;
	}
	
	// Imprime uma String que contém a sequência de visitação (percorrimento) da ABB em pré-ordem.
	public void preordem() {
		if (this != null) {
			System.out.print(this.data + " ");
			if (this.filhoEsq != null)
				this.filhoEsq.preordem();
			if (this.filhoDir != null)
				this.filhoDir.preordem();
		}
	}
	
	// Imprime a árvore no formaro diagrama de barras.
	public void imprimeCaso1(String ident) {
		if (this != null) {
			System.out.print(ident + this.data);
			System.out.println();
			if (this.filhoEsq != null) {
				this.filhoEsq.imprimeCaso1(ident + "\t");
			}
			if (this.filhoDir != null) {
				this.filhoDir.imprimeCaso1(ident + "\t");
			}
		}
	}

	// Imprime a árvore no formato aninhamento.
	public void imprimeCaso2() {
		if (this != null) {
			System.out.print("("+this.data);
			if (this.filhoEsq != null) {
				this.filhoEsq.imprimeCaso2();
			}
			if (this.filhoDir != null)
				this.filhoDir.imprimeCaso2();
			System.out.print(")");
		}
	}
}
