package trabalho01;


/**
 *
 * @author Rodrigo Fernandes e Bruno Fernandes
 */
public class PilhaVetor<T> implements Pilha<T> {

	private T[] info;
	private int limite;
	private int tamanho;

	/**
	 * Construtor da classe. Deve inicializar a vetor infocom o limite fornecido
	 * como argumento;
	 * 
	 * @param limite
	 */
	public PilhaVetor(int tam) {

		this.info = (T[]) new Object[tam];
		this.limite = tam;
		this.tamanho = 0;

	}

	/**
	 * Deve empilhar um valor naestrutura de dados. Se a pilha j� estiver cheia,
	 * deve lan�ar exce��oPilhaCheiaException
	 * 
	 * @param info
	 */
	@Override
	public void push(T v) {
		if (tamanho == limite) {
			throw new PilhaCheiaException();
		} else {
			info[tamanho] = v;
			tamanho++;
		}
	}

	/**
	 * Deve retornar o valor que estiver armazenado no topo da pilha. Case a pilha
	 * esteja vazia, deve-se lan�ar exce��o PilhaVaziaException;
	 * 
	 * @return
	 */
	@Override
	public T peek() {
		if (estaVazia()) {
			throw new PilhaVaziaException();
		}

		return info[tamanho - 1];

	}

	/**
	 * Deve retirar o valor que estiver no topo da pilha e retornar seu valor �
	 * rotina chamadora. Se a pilha estiver vazia, deve lan�ar a
	 * exce��oPilhaVaziaException;
	 */
	public T pop() {

		T valor = peek();
		info[tamanho - 1] = null;
		tamanho--;

		return valor;
	}

	/**
	 * Dever� retornar false se existir algum dado empilhado e truese n�o possuir;
	 * 
	 * @return
	 */
	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	/**
	 * dever� desempilhar todos os dados da pilha;
	 */
	@Override
	public void liberar() {
		for (int i = 0; i < tamanho; i++) {
			info[i] = null;
		}
		this.tamanho = 0;

		// outra forma:
		// while(esavazia())
		// pop();
	}

	/**
	 * dever� retornar os dados armazenados na pilha, retornando o conte�do do
	 * elemento que estiver no topo da pilha at� sua base. Separe os valores por �,�
	 */
	@Override
	public String toString() {
		String str = "";

		for (int i = tamanho - 1; i >= 0; i--) {
			if (i == tamanho - 1) {
				str += info[i];
			} else {
				str += ", " + info[i];
			}
		}

		return str;
	}

	/**
	 * estem�todo dever�concatenaros dados da pilha fornecida como argumento (p)na
	 * pilha corrente . O novo topo da pilha deve ser igual ao topo de p. Ap�s a
	 * opera��o, a pilha pdeve permanecer com o mesmo conte�do antes da invoca��o de
	 * concatenar().
	 * 
	 * @param p
	 */
	public void concatenar(PilhaVetor<T> p) {
		for (int i = 0; i < tamanho - 1; i++) {
			this.push(p.info[i]);
		}
	}

}
