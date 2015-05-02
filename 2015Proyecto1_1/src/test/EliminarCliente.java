package test;

import negocio.ClienteABM;
import datos.Cliente;

public class EliminarCliente {

	public static void main(String[] args) {
		
		ClienteABM abm = new ClienteABM();
		long id=8;
		Cliente c;
		
		try {
		//traer el obj a eliminar
		c = abm.traerCliente(id);
		System.out.println("Cliente a Modificar -->"+c);
		abm.eliminar(id);
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
