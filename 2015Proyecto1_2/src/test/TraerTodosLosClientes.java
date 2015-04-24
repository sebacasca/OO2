package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TraerTodosLosClientes {

	public static void main(String[] args) {
		
		ClienteABM abm= new ClienteABM();
		
		for(Cliente c: abm.traerCliente()){
		System.out.println(c+ "\n");
		}
		
	}

}
