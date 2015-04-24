package test;

import java.util.List;

import negocio.PrestamoABM;
import negocio.ClienteABM;
import datos.Cliente;
import datos.Prestamo;

public class TestTraerPrestamo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		PrestamoABM presAbm=new PrestamoABM();
		
		Cliente cliente=new Cliente();

		long idPrestamo=1;
		
		
		//esto es mal----VER----
		try{
			System.out.println("\n---> TraerPrestamo idPrestamo="+idPrestamo);
			
			// PREGUNTAR!!!!Implementar que el test resuelva si el cliente no tiene prestamos otorgados imprima el mensaje: “El cliente …........ no tiene préstamo otorgado”
	
			if(cliente !=null){
				Prestamo p=presAbm.traerPrestamo(idPrestamo);
				//System.out.println(p);
			}
			else{
				System.out.println("El cliente: "+ cliente+ "no tiene prestamos otrogados");
			}
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		ClienteABM cliAbm=new ClienteABM();
		
		long idCliente=1;
		Cliente c;

		try {
			c = cliAbm.traerCliente(idCliente);
			
			System.out.println("\n---> TraerPrestamos del Cliente="+c);
			List<Prestamo> prestamos=presAbm.traerPrestamo(c);
			for (Prestamo o: prestamos) System.out.println(o);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
	}
}
