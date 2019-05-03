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
		byte inabrfec = 0;

		String auxiliar = "";
		int i;
		Scanner arquivo = new Scanner(
				new File("C:\\users\\bbf12\\Gilvan.html"));
		
		arquivo.useDelimiter("\\<");
		
		while (arquivo.hasNext()) {
			String linha = arquivo.next();
			//Considera se linha não for vazia
			if (linha.toString().trim().contentEquals("") == false) {
				if (linha.toString().trim().charAt(0) == '<') {
					inabrfec = verificaTag(linha.toString().trim().substring(0,buscaPosicao(linha.trim().toString())));
					if (inabrfec == 0) {
						pilha.push((T)linha.trim().toString());
					}
					if (inabrfec == 1) {
					
					}
				}
			}

		}

	}

	//Verifica se está abrindo uma tag ou fechando.
	public static byte verificaTag(String axdstaghtm) {
		if(axdstaghtm.charAt(1) == '/') {
			return 1; //tag fecha
		} else {
			return 0; //tag abre
		}
	}
	//Busca posição do ultimo caractere
	public static int buscaPosicao(String axdstaghtm) {
		int indA = 0;
		int indB = 0;
		
		indA = axdstaghtm.lastIndexOf(" ");
		indB = axdstaghtm.lastIndexOf(">");
		
		if (indA > indB) {
			return indB;
		} else {
			return indA;
		}
		
		
	}

}
