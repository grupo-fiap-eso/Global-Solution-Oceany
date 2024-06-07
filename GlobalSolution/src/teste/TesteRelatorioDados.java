package teste;

import services.RelatorioDados;

public class TesteRelatorioDados {
	public static void main(String[] args) {
		RelatorioDados relatorio = new RelatorioDados();

		System.out.println(relatorio.calcularMedia("temperatura"));
		System.out.println(relatorio.calcularMedia("salinidade"));
		System.out.println(relatorio.calcularMedia("ph"));
		System.out.println(relatorio.calcularMedia("nivel_nutriente"));
		System.out.println(relatorio.calcularMedia("teste"));
	}
}