package entity;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String cpf;
	private String telefone;
	public ArrayList<Orcamento> orcamento = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void imprimirExtratoOrcamento(Cliente cliente, Orcamento orcamento) {
		System.out.println("		-- EXTRATO DE ORÇAMENTOS --" + "\n");
		System.out.printf("CLIENTE: %S \nDestino: '%S' \nN°Passageiros:'%d' - Quilometragem:'%.2f.km' - Dias de viajem:'%d dias'\nValor Total: R$%.2f por pessoa.\n" ,
																												cliente.getNome(),
																											    orcamento.destino,
																												orcamento.qtdPassageiro,
																												orcamento.totalKm*2,
																												(orcamento.dataFim-orcamento.dataInicio)+1,
																												orcamento.valorTotal);
		System.out.printf("\n____________________________________________________________________________________\n\n");
	}
			
}
