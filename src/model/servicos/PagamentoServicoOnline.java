package model.servicos;

public interface PagamentoServicoOnline {
	
	Double taxaPagamento(Double quantidade);
	Double juros(Double quantidade, Integer meses);

}
