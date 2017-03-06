package br.edu.impacta.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaApp {
	private static Scanner entrada = new Scanner(System.in);
	private static List<Contato> contatos = new ArrayList<>();
	public static void main(String[] args) {
		boolean sair = false;
		while (!sair) {
			int opcao = apresentarMenuPrincipal();
			switch (opcao) {
			case 1: inserirContato(); break;
			case 2: buscarContato(); break;
			case 3: sair = true; break;
			default: System.out.println("ERRO: opção inválida!");
			}
		}
		System.out.println("\n Fim do programa!");
	}
	
	
	private static int apresentarMenuPrincipal() {
		boolean inteiro = false;
		int opcao = 0;
		while(!inteiro) {
			System.out.println("\n AGENDA TELEFÔNICA!");
			System.out.println("(1) Inserir");
			System.out.println("(2) Buscar");
			System.out.println("(3) Sair");
			System.out.println("Escolha uma opção: ");
			
			String s = entrada.nextLine();
			try {
				opcao = Integer.parseInt(s);
				inteiro = true;
			} catch (Exception e) {
				System.out.println("ERRO: Opção deve ser um valor inteiro!");
			}
		}
		return opcao;
	}
	
	
	private static void inserirContato() {
		System.out.println("\n INSERÇÃO DE NOVO CONTATO: ");
		String nome = lerNome();
		String telefone = lerTelefone();
		Contato c = new Contato(nome, telefone);
		if(contatos.contains(c)) {
			System.out.println("Este contato já está cadastrado!");
		}else{
			contatos.add(c);
			System.out.println("Contato inserido!");
		}
	}
	
	private static String lerNome() {
		boolean valido = false;
		String nome = "";
		while(!valido) {
			System.out.println("Nome: ");
			nome = entrada.nextLine();
			if (nome.length() == 0 || nome.length() > 200) {
				System.out.println("EERO: Nome de tamanho inválido!");
			} else {
				valido = true;
			}
		}
		return nome;
	}
	
	
	private static String lerTelefone() {
		boolean valido = false;
		String telefone = "";
		while(!valido) {
			System.out.println("Telefone: ");
			telefone = entrada.nextLine();
			if (telefone.length() == 0 || telefone.length() > 25) {
				System.out.println("EERO: Nome de tamanho inválido!");
			} else {
				valido = true;
			}
		}
		return telefone;
	}
	
	
	private static void buscarContato() {
		System.out.println("\n BUSCA DE CONTATOS: ");
		String nome = lerNome();
		List<Contato> resultado = new ArrayList<>();
		for (Contato c : contatos) {
			if (nome.equals(c.getNome())) {
				resultado.add(c);
			}
		}
		if(resultado.size() == 0) {
			System.out.println("Não há contato com esse nome!");
		} else {
			System.out.println("\n Resultado da busca: ");
			for (Contato c : resultado) {
				System.out.println(c);
			}
		}
	}
	
}
