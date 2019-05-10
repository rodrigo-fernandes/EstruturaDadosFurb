package trabalho01.lista;

/**
 *
 * @author Rodrigo Fernandes e Bruno Fernandes
 */
public class NoLista<T> {

	private T info;
	private NoLista proximo;
	private int repeticoes;

	public NoLista(T info) {
		this.info = info;
		repeticoes = 1;
	}

	public T getInfo() {
		return info;
	}
	
	public int getRepeticoes() {
		return repeticoes;
	}
	
	public void setRepeticoes(int pVal) {
		this.repeticoes = pVal;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}

	public NoLista<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoLista<T> proximo) {
		this.proximo = proximo;
	}
}
