package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	public static void main(String[] args) {

		ClienteABM abm = new ClienteABM();
		long id=9;
		Cliente c;
		
		try {
			//traer el obj a modificar
			c = abm.traerCliente(id);
			System.out.println("Cliente a Modificar -->"+c);
			//modificar por set los atributos
			c.setDni(444444445);
			c.setApellido("Hernan");
			c.setNombre("Botbol");
			c.setBaja(true);
			abm.modificar(c);
			Cliente cModif=abm.traerCliente(id);
			System.out.println("Cliente Modificado -->"+cModif);
		
		} 
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}


