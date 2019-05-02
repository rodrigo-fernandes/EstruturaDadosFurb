package trabalho01;

/**
 *
 * @author Rodrigo Fernandes e Bruno Fernandes
 */
public interface Pilha<T> {

	public void push(T info);

	public T pop();

	public T peek();

	public boolean estaVazia();

	public void liberar();

}
