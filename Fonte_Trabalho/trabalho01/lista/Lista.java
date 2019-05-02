package trabalho01.lista;

import trabalho01.lista.NoLista;

/**
 *
 * @author Rodrigo Fernandes e Bruno Fernandes
 */
public class Lista<T> {

	private NoLista primeiro;
	private int qtdeNos;

	public Lista() {
		primeiro = null;
		qtdeNos = 0;
	}

	public void inserir(T info) {
		NoLista<T> novo = new NoLista(null);
		novo.setInfo(info);
		novo.setProximo(primeiro);
		this.primeiro = novo;
		qtdeNos++;
	}

	public void exibir() {
		NoLista<T> p = primeiro;
		while (p != null) {
			System.out.println(p.getInfo());
			p = p.getProximo();
		}
	}

	public boolean estaVazia() {
		return primeiro == null;
	}

	public NoLista buscar(T v) {
		NoLista<T> p = primeiro;

		while (p != null) {
			if (p.getInfo().equals(v)) {
				return p;
			}
			p = p.getProximo();

		}
		return null;
	}

	public void retirar(T info) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;

		while ((p != null) && (!p.getInfo().equals(info))) {
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) {
			if (anterior == null) {
				this.primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
		}

		qtdeNos--;
	}

	public int obterComprimento() {
		int qtdeNos = 0;

		NoLista<T> p = primeiro;

		while (p != null) {

			qtdeNos++;
			p = p.getProximo();
		}
		return qtdeNos;
	}

	public int obterComprimentoOtimizado() {
		return qtdeNos;
	}

	public T obterUltimo() {
		if (estaVazia()) {
			throw new ListaVaziaException();
		}

		NoLista<T> ultimo = null;

		NoLista<T> p = primeiro;
		while (p != null) {
			ultimo = p;
			p = p.getProximo();
		}
		return ultimo.getInfo();
	}

	public NoLista<T> getPrimeiro() {
		return primeiro;
	}

	public boolean equals(Object lista) {
		Lista<T> outraLista = (Lista<T>) lista;

		if (this.obterComprimento() != outraLista.obterComprimento()) {
			return false;
		}

		NoLista<T> p1 = this.getPrimeiro();
		NoLista<T> p2 = outraLista.getPrimeiro();

		while ((p1 != null) && (p2 != null)) {
			if (!(p1.getInfo().equals(p2.getInfo()))) {
				return false;
			}

			p1 = p1.getProximo();
			p2 = p2.getProximo();
		}

		return (p1 == null) && (p2 == null);

	}

	public NoLista<T> getNo(int i) {
		if ((i < 0) || (i >= obterComprimento())) {
			throw new IndexOutOfBoundsException();
		}

		NoLista<T> p = getPrimeiro();
		while (i > 0) {
			i--;
			p = p.getProximo();
		}

		return p;
	}

	public Lista<T> criarInvertida() {
		Lista<T> nova = new Lista<>();

		NoLista<T> p = getPrimeiro();
		while (p != null) {
			nova.inserir(p.getInfo());
			p = p.getProximo();
		}
		return nova;
	}

	public void inserirOrdenado(T info) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;

	}

}
