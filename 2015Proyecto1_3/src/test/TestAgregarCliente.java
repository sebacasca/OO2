package test;

import java.util.GregorianCalendar;

import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {

		String apellido="tu apellido";
		String nombre="tu nombre";
		int documento=35000000;
		GregorianCalendar fechaDeNacimiento=new GregorianCalendar();//tu fecha denacimiento
		double ingreso=7000;
		ClienteABM abm=new ClienteABM();

		try {
			long ultimoIdCliente= abm.agregar(apellido, nombre, documento,fechaDeNacimiento, ingreso);
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

	

	}
}

