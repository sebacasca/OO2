package test;

import java.util.GregorianCalendar;

import negocio.CuotaABM;
import datos.Cliente;
import datos.Prestamo;

public class Test_Cuotas {

	public static void main(String[] args) throws Exception {
		
		Cliente c = new Cliente("casca", "seba", 22222222, new GregorianCalendar (1900,01,01), 7000);
		
		Prestamo p = new Prestamo(new GregorianCalendar(), 10000, 5, 12, c);
		
		System.out.println(p.generarCuotas(p));
		
		/*System.out.println("---------------------------- \n");
		
		CuotaABM cabm= new CuotaABM();
		
		System.out.println(cabm.traerCuotas(p));*/
		
		

	}

}
