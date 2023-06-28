package br.com.jbeniz;

public class PrimeiraClasse {

	public static void main(String [] args) {
		// TODO Auto-generated method stub
		String teste = args[0];
		
		if (teste.equalsIgnoreCase("dev")) {
			System.out.println("Executando teste com DEV");
		} else {
			if (teste.equalsIgnoreCase("Junior")) {
				System.out.println("Serei um Especialista Back-End Java");
			} else {
				System.out.println("Hello World!!");
			}
			
		}
	}

}  
