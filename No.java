package imd.edb;

public class No {
	protected No filhoEsq;
	protected No filhoDir;
	protected int data;
	protected int quantEsq;
	protected int quantDir;
	protected int altura;

	
	public No(int val) {
		data = val;
		filhoEsq = null;
		filhoDir = null;  
		quantEsq = 0;
		quantDir = 0;
		altura = 1;
	}
	
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

	public int mediana() {
		int tamanho = this.quantEsq + this.quantDir + 1;
		if(tamanho % 2 == 1)
			return this.enesimoElemento(tamanho/2 + 1);
		else {
			return this.enesimoElemento(tamanho/2);
		}
	}
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
	/* Método irrelevante olhar a substituição no método média.
	private int quantSubArvore(No atual) {
		if(atual==null)
			return 0;
		return 1 + quantSubArvore(atual.filhoEsq) + quantSubArvore(atual.filhoDir);
	}*/
	
	private int soma(No atual)
	{
		if (atual == null)
			return 0;
		return (atual.data + soma(atual.filhoEsq) +
				soma(atual.filhoDir));
	}
	
	public double media(int x) {
		double soma = soma(buscarNo(x));
		double quantNo = buscarNo(x).quantEsq + buscarNo(x).quantDir + 1;
		double media = soma/quantNo;
		return media;
	}
	
	public void preordem() {
		if (this != null) {
			System.out.print(this.data + " ");
			if (this.filhoEsq != null)
				this.filhoEsq.preordem();
			if (this.filhoDir != null)
				this.filhoDir.preordem();
		}
	}
	
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
