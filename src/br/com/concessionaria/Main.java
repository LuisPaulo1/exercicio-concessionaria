package br.com.concessionaria;

import br.com.concessionaria.estrutura.Peca;
import br.com.concessionaria.funcionarios.Mecanico;
import br.com.concessionaria.oficina.Oficina;
import br.com.concessionaria.veiculos.Veiculo;

public class Main {
	
	public static void main(String[] args) {
		
		Veiculo veiculo1 = new Veiculo("PKY-9078", 2015, 2015, "123456", "Preto", 500);
		Veiculo veiculo2 = new Veiculo("DUO-1563", 2016, 2016, "123456", "Branco", 600);
		Veiculo veiculo3 = new Veiculo("WJE-5458", 2016, 2016, "123456", "Cinza", 700);
		
		Peca peca1 = new Peca("Peça1", 10, "01/06/2022");
		Peca peca2 = new Peca("Peça2", 20, "02/06/2022");
		Peca peca3 = new Peca("Peça3", 30, "03/06/2022");
		Peca peca4 = new Peca("Peça4", 40, "04/06/2022");
		Peca peca5 = new Peca("Peça5", 50, "05/06/2022");
		Peca peca6 = new Peca("Peça6", 60, "06/06/2022");
		Peca peca7 = new Peca("Peça7", 70, "07/06/2022");
		Peca peca8 = new Peca("Peça8", 80, "08/06/2022");
		Peca peca9 = new Peca("Peça9", 90, "09/06/2022");
		Peca peca10 = new Peca("Peça10", 100, "10/06/2022");
		
		Mecanico mecanico1 = new Mecanico("Mecânico1", 2, 2);
		Mecanico mecanico2 = new Mecanico("Mecânico2", 3, 3);
		Mecanico mecanico3 = new Mecanico("Mecânico3", 4, 3);
		
		Oficina oficina = new Oficina("Oficina do Canto");
				
		oficina.adicionarPeca(peca1);
		oficina.adicionarPeca(peca2);
		oficina.adicionarPeca(peca3);
		oficina.adicionarPeca(peca4);
		oficina.adicionarPeca(peca5);
		oficina.adicionarPeca(peca6);
		oficina.adicionarPeca(peca7);
		oficina.adicionarPeca(peca8);
		oficina.adicionarPeca(peca9);
		oficina.adicionarPeca(peca10);
		
		oficina.adicionarVeiculo(veiculo1);
		oficina.adicionarVeiculo(veiculo2);
		oficina.adicionarVeiculo(veiculo3);
		
		oficina.adicionarMecanico(mecanico1);
		oficina.adicionarMecanico(mecanico2);
		oficina.adicionarMecanico(mecanico3);		
		
		oficina.verificarPecasRevisao();
		oficina.realizarRevisaoVeiculos();		
	}
}
