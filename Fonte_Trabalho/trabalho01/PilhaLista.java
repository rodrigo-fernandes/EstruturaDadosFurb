package trabalho01;

import trabalho01.PilhaVaziaException;
import trabalho01.lista.Lista;
import trabalho01.lista.ListaEncadeada;
import trabalho01.lista.NoLista;

/**
 *
 * @author Rodrigo Fernandes e Bruno Fernandes
 */
public class PilhaLista<T> implements Pilha<T> {

    private Lista<T> lista;

    public PilhaLista() {
        lista = new Lista<T>();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new RuntimeException("Lista vazia");
        }

        T valor = lista.getPrimeiro().getInfo();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Lista vazia");
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        try {
            while (!estaVazia()) {
                pop();
            }

        } catch (Exception e) {
        }
    }

    public String toString() {
        String resultado = "";
        NoLista<T> p = lista.getPrimeiro();
        while (p != null) {
            resultado += p.getInfo();
            if ((p.getProximo() != null)) {
                resultado = resultado + ",";
            }
            p = p.getProximo();
        }

        return resultado;
    }
}
