package entity;

public class Orcamento {
	public String origem;
	public int dataInicio;
	public String destino;
	public int dataFim;
	public double totalKm;
	public int qtdPassageiro;
	public String veiculoAdisposicao;
	public double valorTotal;
	
	public Orcamento() {
		this.origem = "vazio";
		this.dataInicio = 0;
		this.destino = "vazio";
		this.dataFim = 0;
		this.totalKm = 0;
		this.qtdPassageiro = 0;
		this.veiculoAdisposicao = "vazio";		
		this.valorTotal = 0;
	}
	
	public double calcularViagem(double Km, int diaria, int qtdPassageiro) {
		double consumoPorLitro = 11.5;
		double totalKm = (Km * 2);
		double valorFinal;
		valorFinal = ((((totalKm / consumoPorLitro) * 3.766) + diaria * 200) / qtdPassageiro);

		return valorFinal;
	}
	
	public void imprimir(Cliente cliente) {
		System.out.printf("%S sua viagem para '%S' no dia '%d' terá o valor de '%.2f' por pessoa \nincluído as despesas de hospedagem e alimentação do motorista.\n",cliente.getNome().toUpperCase(),destino,dataInicio,valorTotal);
	}
}
