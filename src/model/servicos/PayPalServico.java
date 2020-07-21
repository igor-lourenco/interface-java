package model.servicos;

public class PayPalServico implements PagamentoServicoOnline {
	
	private static final Double TAXA_PAGAMENTO = 0.02;
	private static final Double JUROS_MENSAL = 0.01;

	@Override
	public Double taxaPagamento(Double quantidade) {
		return quantidade * TAXA_PAGAMENTO;
	}

	@Override
	public Double juros(Double quantidade, Integer meses) {
		return quantidade * meses * JUROS_MENSAL;
	}

}
