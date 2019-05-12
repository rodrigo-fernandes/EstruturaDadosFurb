package trabalho01.lista;

/**
 *
 * @author Rodrigo Fernandes e Bruno Fernandes
 */
public class ListaEncadeada<T> {

	private NoLista<T> primeiro;

	public ListaEncadeada() {
		this.primeiro = null;
	}

	public NoLista<T> getPrimeiro() {
		return primeiro;
	}

	public void inserir(T info) {
		NoLista<T> segundo = primeiro;
		primeiro = new NoLista(info);
		primeiro.setProximo(segundo);
	}

	public boolean estaVazia() {
		return (primeiro == null);
	}

	public NoLista<T> buscar(T info) throws IndexOutOfBoundsException {
		NoLista<T> aux = primeiro;

		while (aux != null) {
			if (aux.getInfo().equals(info)) {
				return aux;
			}

			aux = aux.getProximo();
		}

		return null;
	}

	public void retirar(T info) {
		NoLista<T> aux = primeiro;
		NoLista<T> anterior = null;

		while ((aux != null) && (!aux.getInfo().equals(info))) {
			anterior = aux;
			aux = aux.getProximo();
		}

		if (aux != null) {
			if (anterior == null) {
				this.primeiro = aux.getProximo();
			} else {
				anterior.setProximo(aux.getProximo());
			}
		}
	}

	public int obterComprimento() {
		NoLista<T> aux = primeiro;
		int count = 0;

		while (aux != null) {
			count++;
			aux = aux.getProximo();
		}

		return count;
	}

	public NoLista<T> obterNo(int posicao) throws IndexOutOfBoundsException {
		if (posicao < 0) {
			throw new IndexOutOfBoundsException("A posi��oo informada est� negativa!");
		}

		NoLista<T> aux = primeiro;
		int auxPosicao = 0;

		while (aux != null) {
			if (posicao == auxPosicao) {
				return aux;
			}

			auxPosicao++;
			aux = aux.getProximo();
		}

		throw new IndexOutOfBoundsException("A posi��oo informada � maior que o tamanho da lista!");
	}

	public ListaEncadeada<T> criarSubLista(int inicio, int fim) {
		if (inicio < 0) {
			throw new IndexOutOfBoundsException("A posi��oo inicial informada � negativa!");
		}

		if (fim > obterComprimento()) {
			throw new IndexOutOfBoundsException("A posi��oo final informada � maior que o tamanho da lista!");
		}

		ListaEncadeada<T> novaLista = new ListaEncadeada<>();
		NoLista<T> aux = primeiro;
		int auxPosicao = 0;

		while (aux != null) {
			if ((inicio <= auxPosicao) && (fim >= auxPosicao)) {
				novaLista.inserir(aux.getInfo());
			}

			auxPosicao++;
			aux = aux.getProximo();
		}

		return novaLista;
	}

	@Override
	public String toString() {
		NoLista<T> aux = primeiro;
		String str = "";

		while (aux != null) {
			str += aux.getInfo() + ": " + aux.getRepeticoes() + (aux.getRepeticoes() == 1 ? " vez\n" : " vezes\n");
			aux = aux.getProximo();
		}

		return str;
	}
}
