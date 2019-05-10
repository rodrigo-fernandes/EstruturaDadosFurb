/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import trabalho01.lista.ListaEncadeada;

/**
 *
 * @author Rodrigo Fernandes e Bruno Fernandes
 */
public class validaHtml {

	/**
	 * @param      <T>
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException {

		PilhaLista<String> pilha = new PilhaLista<>();
		byte inabrfec = 0;
		ListaEncadeada<String> contador = new ListaEncadeada<>();
		boolean indMontaTag = false;

		String auxiliar = "";
		int i;
		Scanner arquivo = new Scanner(new File("C:\\users\\bbf12\\Gilvan.html"));

		// arquivo.useDelimiter("\\<");

		while (arquivo.hasNextLine()) {
			String linha = arquivo.nextLine().toLowerCase();
			// System.out.println(linha.toString());
			indMontaTag = false;
			// Considera se linha não for vazia
			if (linha.toString().trim().contentEquals("") == false) {
				if (linha.toString().trim().charAt(0) == '<') {
					String linhaAux = "";
					char texto[] = linha.toString().toCharArray();
					for (char texto2 : texto) {
						if (texto2 == '<') {
							indMontaTag = true;
						}
						if ((texto2 == '>' || texto2 == ' ') && indMontaTag == true) {
							linhaAux += ">";
							indMontaTag = false;
						}
						if (indMontaTag == true) {
							linhaAux += texto2;
						}
						if (linhaAux.trim().equals("") == false && indMontaTag == false && linhaAux.charAt(1) != '/') {
							pilha.push(linhaAux);
							linhaAux = "";
						}
						if (linhaAux.trim().equals("") == false && indMontaTag == false && linhaAux.charAt(1) == '/') {
							if (linhaAux.trim().replace("/", "").equals(pilha.pop()) == true) {

							} else {
								throw new RuntimeException("Tag incorreta = " + linhaAux.trim());
							}
							linhaAux = "";
						}

					}

				}
			}

		}
		System.out.println("Executado com sucesso!");
		System.out.println(pilha.toString());

	}

}
