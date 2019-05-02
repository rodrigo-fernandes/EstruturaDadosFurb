/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Rodrigo Fernandes e Bruno Fernandes
 */
public class validaHtml {

	/**
	 * @param <T>
	 * @param args
	 *            the command line arguments
	 */
	public static <T> void main(String[] args) throws FileNotFoundException {

		PilhaLista<T> pilha = new PilhaLista<T>();

		String auxiliar = "";
		int i;
		Scanner arquivo = new Scanner(
				new File("C:\\Developer\\Project\\estruturadados\\src\\trabalho01\\lerArquivo.html"));
		
		arquivo.useDelimiter("\\<");
		
		while (arquivo.hasNext()) {
			String parte = arquivo.next();

			if (!parte.isEmpty()) {
				if (parte.indexOf("//") != -1) {
					i = parte.indexOf(">");
					auxiliar = parte.substring(0, parte.indexOf(">"));
					pilha.pop();
				} else if (parte.indexOf(">") != -1) {
					pilha.push((T) parte.substring(0, parte.indexOf(">")));
				}

			}
			System.out.println(parte);
		}

	}

}
