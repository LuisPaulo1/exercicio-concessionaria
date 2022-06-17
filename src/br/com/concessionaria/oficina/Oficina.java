package br.com.concessionaria.oficina;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.concessionaria.estrutura.Peca;
import br.com.concessionaria.funcionarios.Mecanico;
import br.com.concessionaria.veiculos.Veiculo;

public class Oficina {

	private String nomeOficina;
	private List<Mecanico> listaMecanicos = new ArrayList<>();
	private List<Peca> listaPecas = new ArrayList<>();
	private List<Veiculo> listaVeiculos = new ArrayList<>();
	private int pecasNecessarias;
	
	public Oficina(String nomeOficina) {	
		this.nomeOficina = nomeOficina;
	}
	
	public String getNomeOficina() {
		return nomeOficina;
	}
	
	public void setNomeOficina(String nomeOficina) {
		this.nomeOficina = nomeOficina;
	}
	
	public int getPecasNecessarias() {
		return pecasNecessarias;
	}
	
	public void setPecasNecessarias(int pecasNecessarias) {
		this.pecasNecessarias = pecasNecessarias;
	}
	
	public void adicionarMecanico(Mecanico mecanico) {
		this.listaMecanicos.add(mecanico);
	}	
	
	public void removerMecanico(Mecanico mecanico) {
		this.listaMecanicos.remove(mecanico);
	}
	
	public void setListaMecanicos(List<Mecanico> listaMecanicos) {
		this.listaMecanicos = listaMecanicos;
	}
	
	public List<Mecanico> getListaMecanicos() {
		return listaMecanicos;
	}
	
	public void adicionarPeca(Peca peca) {
		this.listaPecas.add(peca);
	}	
	
	public void removerPeca(Peca peca) {
		this.listaPecas.remove(peca);
	}
	
	public List<Peca> getListaPecas() {
		return listaPecas;
	}
	
	public void setListaPecas(List<Peca> listaPecas) {
		this.listaPecas = listaPecas;
	}
	
	public void adicionarVeiculo(Veiculo veiculo) {
		
		this.listaVeiculos.add(veiculo);
		
		for (int i = 0; i < gerarNumeroAleatorioDePecas(); i++) {
			Peca peca = getListaPecas().get(i);
			this.listaPecas.add(peca);
		}		
	}	
	
	public void removerVeiculo(Veiculo veiculo) {
		this.listaVeiculos.remove(veiculo);
		
		for (int i = 0; i < gerarNumeroAleatorioDePecas(); i++) {
			Peca peca = getListaPecas().get(i);
			this.listaPecas.remove(peca);
		}		 
	}	
	
	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public int verificarPecasRevisao() {
		
		if(getListaVeiculos().size() >= 1) {						
			for (int i = 0; i < getListaVeiculos().size(); i++) {				
				this.pecasNecessarias += gerarNumeroAleatorioDePecas(); 
			}
			System.out.println("Total de peças necessárias para a revisão: "+getPecasNecessarias());
			System.out.println();
		}
		
		if(getPecasNecessarias() == 0)
			System.out.println("Não a carros para serem revisados");

		return getPecasNecessarias();
	}
	
	private int gerarNumeroAleatorioDePecas() {
		Random ran = new Random();
		return ran.nextInt(3) + 1;		
	}	
	
	public boolean realizarRevisaoVeiculos() {	
		if(getListaVeiculos().size() > 0) {
			
			if(getListaPecas().size() >= getPecasNecessarias() && totalDeVeiculosQuePodemSerAtendidos() >= getListaVeiculos().size()) {
				
				getListaVeiculos().forEach(veiculo -> {
					System.out.println("Placa do carro: "+veiculo.getPlaca());
				});
				
				System.out.println();
				
				getListaMecanicos().forEach(mecanico -> {
					System.out.println("Nome do mecânico: "+mecanico.getNome());
				});
				
				System.out.println();
				
				getListaPecas().forEach(peca -> {
					System.out.println("Nome da peça: "+peca.getNome());
					System.out.println("Valor da peça: "+peca.getValor());
					System.out.println("Data da compra: "+peca.getDataCompra());
					System.out.println();
				});				
				return true;
			}
			
			return false;			
		}
		System.out.println("Não a carros para serem revisados");
		return false;
	}
	
	private int totalDeVeiculosQuePodemSerAtendidos() {
		return getListaMecanicos().stream().map(m -> m.getCarrosSimultaneos()).reduce(0, (x, y) -> x + y);
	}
	
	public float valorTotalPecas() {
		
		System.out.println();
		getListaPecas().forEach(peca -> {
			System.out.println("Nome da peça: "+peca.getNome()+" - Valor da peça: "+peca.getValor());				
		});
		
		return getListaPecas().stream().map(p -> p.getValor()).reduce(0f, (x, y) -> x + y);
	}
	
}
