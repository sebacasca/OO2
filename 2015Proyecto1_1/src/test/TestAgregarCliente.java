package test;

import java.util.GregorianCalendar;

import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {

		String apellido="marina";
		String nombre="fernandez";
		int documento=33333333;
		GregorianCalendar fechaDeNacimiento=new GregorianCalendar(1990,02,18);//tu fecha de nacimiento
		ClienteABM abm=new ClienteABM();

		try {
			abm.agregar(apellido, nombre, documento,fechaDeNacimiento);
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

	

	}
}

