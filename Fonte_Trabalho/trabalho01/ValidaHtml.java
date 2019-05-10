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
import trabalho01.lista.ListaEstatica;
import trabalho01.lista.NoLista;

/**
 *
 * @author Rodrigo Fernandes e Bruno Fernandes
 */
public class ValidaHtml {

	static String[] singleton = { "meta", "base", "br", "col", "command", "embed", "hr", "img", "input", "link",
			"param", "source", "!DOCTYPE" };

	public static void main(String[] args) throws FileNotFoundException {

		PilhaLista<String> pilha = new PilhaLista<>();
		byte inabrfec = 0;
		ListaEncadeada<String> contador = new ListaEncadeada<>();
		boolean indMontaTag = false;
		Scanner arquivo = new Scanner(new File("C:\\users\\bbf12\\Gilvan.html"));

		while (arquivo.hasNextLine()) {
			String tagEsperada = "";
			String linha = arquivo.nextLine().toLowerCase();
			indMontaTag = false;
			// Considera se linha não for vazia
			if (linha.toString().trim().contentEquals("") == false) {
				String linhaAux = "";
				char texto[] = linha.toString().toCharArray();
				for (char texto2 : texto) {
					// verifica que é inicio de tag
					if (texto2 == '<') {
						indMontaTag = true;
					}
					// verifica se é final de tag e completa
					if ((texto2 == '>' || texto2 == ' ') && indMontaTag == true) {
						linhaAux += ">";
						indMontaTag = false;
					}
					// Se esta montando tag vai adicionando cada char da tag
					if (indMontaTag == true) {
						linhaAux += texto2;
					}

					// Se existe uma tag de abertura montada e indicador que está motando for false
					if (linhaAux.trim().equals("") == false && indMontaTag == false && linhaAux.charAt(1) != '/') {
						if (validaSingleton(linhaAux.trim()) == false) {
							pilha.push(linhaAux);
							// Se listaEncadeada ja possui só alimenta o contador, senão cria novo nó pra
							// contabilizar
							if (contador.buscar(linhaAux) == null) {
								contador.inserir(linhaAux);
							} else {
								contador.buscar(linhaAux).setRepeticoes(contador.buscar(linhaAux).getRepeticoes() + 1);
							}
						}
						// Limpa para nova tag
						linhaAux = "";
					}
					// Se existe uma tag de fim montada, retira da pilha e compara
					if (linhaAux.trim().equals("") == false && indMontaTag == false && linhaAux.charAt(1) == '/') {
						tagEsperada = pilha.pop().trim();
						if (linhaAux.trim().replace("/", "").equals(tagEsperada) == false
								&& tagEsperada.equals("") == false) {
							throw new RuntimeException("Tag final inesperada = " + linhaAux.trim()
									+ "\n Tag esperada = " + tagEsperada.replace("<", "</"));
						}
						linhaAux = "";
					}
				}
			}

		}

		// Valida se não falta tag final
		if (pilha.estaVazia() == false) {
			throw new RuntimeException("Falta tag final: " + pilha.toString().replace("<", "</"));
		}
		// Se não deu exception, exibe mensagens
		System.out.println("Executado com sucesso!");
		System.out.println("--------------------------");
		System.out.println("Tags e repetições:\n");
		System.out.println(contador.toString());
		

	}

	public static boolean validaSingleton(String pTag) {
		for (byte i = 0; i < singleton.length; i++) {
			if (pTag.replace("<", "").replace(">", "").toLowerCase().equals(singleton[i].toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
