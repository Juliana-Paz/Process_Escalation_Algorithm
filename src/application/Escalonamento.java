package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import model.Processo;

/**
 * 
 * @spetacularAuthor Juliana Chaves R. S. Paz
 * 
 */

// FIFO
public class Escalonamento {

	static Scanner scan = new Scanner(System.in);
	static List<Processo> arrayProcessos;
	static Processo processo;

	public static void main(String[] args) {

		char opcao = 's';
		do {
			System.out.println("+---------------------------------+");
			System.out.println(" Quantidade de processos: [1 - 50] ");
			int qtdProcessos = scan.nextInt();
			if (qtdProcessos > 50 || qtdProcessos < 1) {
				System.out.println("Opcao invalida!");
				continue;
			}

			setProcesso(qtdProcessos);
			sortArrivalTime();
			printEscalonamento();
			System.out.println("+---------------------------------+");

			System.out.println("\nGerar outros processos? [S]im/[N]ao");
			opcao = scan.next().toLowerCase().charAt(0);

		} while (opcao == 's');

	}

	/**
	 * Instancia uma nova lista de processos e seta cada atributo dentro de cada
	 * posicao na lista
	 */
	private static void setProcesso(int qtdProcessos) {
		arrayProcessos = new ArrayList<>();
		for (int i = 0; i < qtdProcessos; i++) {
			processo = new Processo();
			processo.setPid(Processo.returnsPidTime(i + 1));
			processo.setArrivalTime(Processo.returnsArrivalTime(i));
			processo.setBurstTime(Processo.returnsBurstTime());
			arrayProcessos.add(processo);
		}
	}

	/**
	 * Ordena a lista de processos de acordo com chegada dos processos (ArrivelTime)
	 */
	private static void sortArrivalTime() {
		arrayProcessos.sort(Comparator.comparing(Processo::getArrivalTime));
	}

	/**
	 * Imprimir cada posicao da lista de processos
	 */
	private static void printEscalonamento() {
		arrayProcessos.forEach(System.out::println);
	}

}
