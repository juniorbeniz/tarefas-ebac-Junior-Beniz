package br.com.jbeniz;

public class SegundaClasse {
	
	public static void main (String [] args) {
		System.out.println("Olá Júnior");
		Cliente cliente = new Cliente();
		cliente.cadastrarEndereco("Rua 1");
		cliente.setCodigo(1);
		System.out.println("Código do Cliente: " + cliente.getCodigo());
		System.out.print("Endereço: " );
		//cliente.imprimirEndereco();
		String end = cliente.retornarNomeCliente();
		System.out.println(end);
		System.out.println(cliente.getValorTotal());
		
	}

}
