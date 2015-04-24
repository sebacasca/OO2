package vista;

import modelo.Cliente;
import modelo.Cuota;
import modelo.Funcion;
import modelo.Prestamo;
import modelo.Sistema;

public class TestGenerarLaListaDeCuotasDeUnPrestamo {

	public static void main(String[] args) {

		Sistema sistema1 = new Sistema();
		
		Funcion.setListaFeriados();
		sistema1.setListaCliente();
		sistema1.setListaPrestamos();

		try {
			System.out.println("Test para traer el prestamo de la lista:\n");
			
			Cliente c;

			c = sistema1.traerCliente(22222222);
			for (Prestamo p : sistema1.traerPrestamo(c))
				// Esto devuelve una lista
				System.out.println(p); // imprimimos el prestamo de la lista

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

		
		System.out.println("\n---------------------------------------------------\n");
		
		
		try {
			System.out.println("Test para generarCuotas de un prestamo traido por id del xml:\n");
			
			Prestamo p;

			p = sistema1.traerPrestamo(1);
			for (Cuota c : sistema1.generarCuotas(p))
				// Esto devuelve una lista de cuotas
				System.out.println(c); // imprimimos las cuotas de un prestamo

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
