package aplicacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Contrato;
import model.entidades.Parcelas;
import model.servicos.ContratoServico;
import model.servicos.PayPalServico;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor Contrato: ");
		double totalValor = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, totalValor);
		
		System.out.print("Digite a quantidade de parcelas: ");
		int meses = sc.nextInt();
				
		
		ContratoServico cs = new ContratoServico(new PayPalServico());
		
		cs.processoContrato(contrato, meses);
		
		System.out.println("Parcelas:");
		for(Parcelas p: contrato.getParcelamento()) {
			System.out.println(p);
		}
		
		
		
		sc.close();
	}

}
