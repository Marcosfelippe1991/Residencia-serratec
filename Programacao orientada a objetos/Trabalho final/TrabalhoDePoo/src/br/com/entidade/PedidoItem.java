package br.com.entidade;

public class PedidoItem {

	double valorVendaUnidade;
	double quantidadeProduto;
	double valorDesconto;
	double PorcetagemDesconto;
	
	public double getValorVendaUnidade() {
		return valorVendaUnidade;
	}
	public void setValorVendaUnidade(double valorVendaUnidade) {
		this.valorVendaUnidade = valorVendaUnidade;
	}
	public double getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(double quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	public double getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public double getPorcetagemDesconto() {
		return PorcetagemDesconto;
	}
	public void setPorcetagemDesconto(double porcetagemDesconto) {
		PorcetagemDesconto = porcetagemDesconto;
	}
}
