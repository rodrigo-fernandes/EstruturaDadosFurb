package trabalho01.lista;

import java.util.Arrays;

public class ListaEstatica<T> {

	private T[] info;
	private int tamanho;
	private final byte TAMANHO_INICIAL = 10;
	
	public ListaEstatica() {
		this.info = (T[]) new Object [TAMANHO_INICIAL];
		this.tamanho = 0;
	}

	/*
	 * Cria um vetor com capacidade de 10 posi��es maior que a atual, alimenta e o
	 * assume como vetor principal
	 */
	private void redimensionar() {
		T[] infox = (T[]) new Object [info.length + 10];
		for (int i = 0; i < info.length; i++) {
			infox[i] = info[i];
		}
		info = infox;
	}

	/*
	 * Insere numero fornecido como parametro no vetor. Verifica se est� no limite e
	 * redimensiona o vetor.
	 */
	public void inserir(T valorx) {
		if (tamanho == info.length) {
			redimensionar();
		}
		
		info[tamanho] = valorx;
		tamanho++;
		
	}

	/*
	 * Deve exibir o conte�do armazenado na lista, apresentando na tela o valor do
	 * primeiro n�mero at� o �ltimo n�mero armazenado, nesta ordem;
	 */
	public void exibir() {
		for (int i = 0; i < tamanho; i++) {
			System.out.println(i + ": " + info[i]);
			
		}
	}

	/*
	 * Deve procurar se h� um n�mero igual ao fornecido como argumento. Caso seja
	 * encontrado, este m�todo dever� retornar a posi��o do n�mero no vetor (�ndice
	 * no vetor). Se n�o for localizado, dever� retornar -1;
	 */
	public int buscar(T valorx) {		
		for (int i = 0; i < tamanho; i++) {
			if (info[i] == valorx) {
				return i;
			}
		}
		return -1;
	}
	
	public void retirar(T valorx){
		int posicao = buscar(valorx);
		if (posicao > -1) {
			for (int i = posicao; i < this.tamanho; i++) {
				info[i] = info[i+1];
			}
		}
		this.tamanho--;
	}
	
	public void liberar () {
		info = (T[]) new Object[TAMANHO_INICIAL];
		tamanho = 0;
		
	}
	
	public T obterElementos(int posicao){
		if (posicao >= 0 && posicao < tamanho) {
			return info[posicao];
		} else {
			throw new IndexOutOfBoundsException();
		}
		
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}

	public String toString() {
		String resultado = "";
		
		for (int i = 0; i < this.tamanho; i++) {
			if (i > 0) {
				resultado += "ListaEstatica [info=" + Arrays.toString(info) + ",tamanho=" + tamanho + "]";
			}
		}
		
		return resultado;
			
	}
	
	public int getTamanho() {
		return tamanho;
	}
}
