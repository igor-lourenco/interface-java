package model.servicos;

import java.util.Calendar;
import java.util.Date;

import model.entidades.Contrato;
import model.entidades.Parcelas;

public class ContratoServico {
	
	private PagamentoServicoOnline pagamentoServicoOnline;
	
	public ContratoServico(PagamentoServicoOnline pagamentoServicoOnline) {
		this.pagamentoServicoOnline = pagamentoServicoOnline;
	}

	public void processoContrato(Contrato contrato, int meses) {
		double parcelaBasica = contrato.getValorTotal() / meses;
		//parcelaBasica = 200;
		for(int i = 1; i<= meses; i++) {
			double parcelaAtualizada = parcelaBasica + pagamentoServicoOnline.juros(parcelaBasica, i);
			//parcelaAtualizada = 202
			double totalParcela = parcelaAtualizada + pagamentoServicoOnline.taxaPagamento(parcelaAtualizada);
			//totalParcela = 206.4
			Date dataVencimento = adicionarMeses(contrato.getData(), i);
			contrato.getParcelamento().add(new Parcelas(dataVencimento, totalParcela));
		}
	}
	
	//metodo para acrescentar meses em uma data
	private Date adicionarMeses(Date data, int N) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		calendario.add(Calendar.MONTH, N);
		return calendario.getTime();
	}
}
