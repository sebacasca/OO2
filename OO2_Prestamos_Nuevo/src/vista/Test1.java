package vista;

import java.util.GregorianCalendar;

import modelo.Cliente;
import modelo.Funcion;
import modelo.Prestamo;
import modelo.Sistema;

public class Test1 {

	public static void main(String[] args) {
	
		
		Sistema sistema1=new Sistema();
		System.out.println(sistema1);
		
		System.out.println("\nLista de Feriados:");
		Funcion.setListaFeriados();
		for(GregorianCalendar f: Funcion.getListaFeriados()){
			System.out.println(Funcion.traerFechaCorta(f));
		}
		
		System.out.println("\n\n-----------------------------------\n");
		System.out.println("Tests de los metodos esdiaHabil y primerDiaHabil:\n");
		
		GregorianCalendar diaHabil=new GregorianCalendar(2015,03,01);//acordarse q cuando instancia es mes -1, pero por consola me muestra mes real por (mes+1) de la funcion TraerFechaCorta
		
		System.out.println("Dia hábil: "+ Funcion.traerFechaCorta(diaHabil)+ "? " + Funcion.esDiaHabil(diaHabil));
		
		GregorianCalendar sabado=new GregorianCalendar(2015,03,04);
		
		System.out.println("Dia hábil: "+ Funcion.traerFechaCorta(sabado)+ "? " +Funcion.esDiaHabil(sabado));//false
		
		GregorianCalendar feriado=new GregorianCalendar(2015,00,01);
		
		System.out.println("Dia hábil: "+ Funcion.traerFechaCorta(feriado)+ "? " +Funcion.esDiaHabil(feriado));//false
	
		System.out.println("Dia no Habil: "+ Funcion.traerFechaCorta(feriado)+ " ,Se pasa para el dia Habil: "+Funcion.traerFechaCorta(Funcion.primerDiaHabil(feriado)));
		
		System.out.println("Dia no Habil: "+ Funcion.traerFechaCorta(sabado)+ " ,Se pasa para el dia Habil: "+Funcion.traerFechaCorta(Funcion.primerDiaHabil(sabado)));
	
		System.out.println("\n-------------------------\n");
		
		System.out.println("Pruebo el metodo generarCuotas: \n");
		
		Cliente cliente=new Cliente(1, "casca", "seba", 0);
		
		Prestamo prestamo=new Prestamo(1, 10000, 12.5, 12, new GregorianCalendar(2015,01,01), cliente);
		
		System.out.println(sistema1.generarCuotas(prestamo));
	}
}

