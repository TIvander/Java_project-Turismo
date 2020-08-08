package application;

import java.util.Scanner;

import entity.Cliente;
import entity.Orcamento;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cliente cliente = new Cliente();
		boolean registro = false;
		int opcao = 0;
	
		do {
		System.out.println("|| Menu Principal ||");
		System.out.println();
		System.out.println("1. Cadastro de Usuário");
		System.out.println("2. Orçamentos");
		System.out.println("3. Extrato de Orçamentos realizados");
		System.out.println("0. Sair");
		opcao = sc.nextInt();
		
		switch(opcao) {
		case 1:
			registro = true;
			System.out.println("CADASTRO DE USUARIO:");
			System.out.print("Nome: ");
			String nome = sc.next();
			
			System.out.print("CPF: ");
			String cpf = sc.next();
			
			System.out.print("Telefone: ");
			String telefone = sc.next();
			
			
			
			
			cliente.setNome(nome);
			cliente.setCpf(cpf);
			cliente.setTelefone(telefone);
			System.out.println("\n" + "Cliente registrado com sucesso!");
			System.out.println();
			
			break;
		
		case 2:
			if(registro) {
				
			
			Orcamento orcamento = new Orcamento();
			System.out.println("PREENCHER DADOS PARA ORÇAMENTOS:");
			System.out.print("Origem: ");
			String origem = sc.next();
			
			
			System.out.print("Data de Partida: ");
			int dataInicio = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Destino da Viajem: ");
			String destino = sc.next();
			
			
			System.out.print("Data de Retorno: ");
			int dataFim = sc.nextInt();
			
			System.out.print("Total de Quilômetros: ");
			double totalKm = sc.nextDouble();
			
			System.out.print("Numero de Passageiros: ");
			int qtdPassageiro = sc.nextInt();
			if(qtdPassageiro > 12) {
				System.out.println("\n" + "“Quantidade de pessoas maior que o limite comportado pelo veículo!”");
				System.out.println("Capacidade máxima: 12 Pessoas.." + "\n");
				break;
			}
			System.out.print("Veículo ficará a disposição ? sim/não: ");
			String veiculoAdisposicao;
			
			if(dataFim < dataInicio) {
				dataFim+=30;
			}
			
			int diaria = ((dataFim - dataInicio) + 1);
			orcamento.origem = origem;
			orcamento.dataInicio = dataInicio;
			orcamento.destino = destino;
			orcamento.dataFim = dataFim;
			orcamento.totalKm = totalKm;
			orcamento.qtdPassageiro = qtdPassageiro;
			
			
				do {
					
					veiculoAdisposicao = sc.next().toUpperCase();
					if(veiculoAdisposicao.equals("SIM")) {
						 orcamento.veiculoAdisposicao = veiculoAdisposicao;
						 orcamento.valorTotal = orcamento.calcularViagem(totalKm, diaria, qtdPassageiro);
						 
						 cliente.orcamento.add(orcamento);						 
					    						 						 
						 System.out.println("\n" + "-- ORCAMENTO GERADO -- " + "\n");
						 orcamento.imprimir(cliente);
						 System.out.println("");
						 break;
						
					   } else if(veiculoAdisposicao.equals("NÃO")) {						 
						 orcamento.veiculoAdisposicao = veiculoAdisposicao;
						 orcamento.valorTotal = orcamento.calcularViagem(totalKm, diaria, qtdPassageiro);
						 
						 cliente.orcamento.add(orcamento);
						 
						 System.out.println("\n" + "-- ORCAMENTO GERADO --" + "\n");
						 orcamento.imprimir(cliente);
						 System.out.println("");
					    					 
						 break;	
						 
					    } else {					
						   	System.out.println("Erro de digitação - digite apenas Sim ou Não..");
						   	System.out.print("Veículo ficará a disposição ? sim/não: ");
						   	
					  }
					
				} while(!veiculoAdisposicao.equals("NÃO") || !veiculoAdisposicao.equals("SIM")); 
				break;
			}else { 
				System.out.println("\n" + "Solicitação de Orçamentos disponíveis apenas para clientes." + "\n");	
			break;
			}
		case 3:
			for(int i =0; i < cliente.orcamento.size();i++) {
				cliente.imprimirExtratoOrcamento(cliente,cliente.orcamento.get(i));
			    
			}
			break;
		
		case 0:
			System.out.println("Fim de Execução!");			
			
			}
			
		}
			while(opcao != 0);
			sc.close();
	}
}