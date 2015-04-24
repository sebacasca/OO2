package datos;
import java.util.*;

import datos.Funcion;

public class Prestamo {

	private long idPrestamo;
	private GregorianCalendar fecha;
	private double monto;
	private double interes;
	private int cantCuotas;
	private Cliente cliente;
	
	public Prestamo(){}
	
	public Prestamo(GregorianCalendar fecha, double monto, double interes,int cantCuotas, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	protected void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		
		this.cliente = cliente;
	}

	public String toString(){
		String prestamo= "\nCliente: "+cliente;
		prestamo+="Prestamo: $ "+monto+"\nFecha: "+Funcion.traerFechaCorta(fecha)+"\nInteres: "+interes+"\nCant.de Cuotas: "+cantCuotas;
	
	return prestamo;
	}

	
	//Generar cuotas para un préstamo (devuelve una lista de cuotas)
	
			public List<Cuota> generarCuotas(Prestamo prestamo){
				
				   List<Cuota> listaCuotas= new ArrayList<Cuota>();
				   
				   //cantidad de cuotas totales
					int n=prestamo.getCantCuotas();
					//cantidad de cuotas a usar
					int cantidadDeCuotas=0;
					//saldo pendiente
					double saldoPendiente=prestamo.getMonto();
					//amortizacion
					double amortizacion=0;
					//interes en porciento por ejemplo 12.5% = (12.5)/100
					double interes=(prestamo.getInteres()/100);
					//interes de cada cuota
					double interesCuota=0;
					
					//fecha inicial del prestamo
					GregorianCalendar fechaInicial= prestamo.getFecha();
					
					//fechavto
					GregorianCalendar fechavto;
					
					fechavto=fechaInicial;
					
					for(int i=0;i<n;i++){		
						
							//Cantidad de cuotas
							if(i==0)cantidadDeCuotas=n;
							
							else {cantidadDeCuotas=n-i;
							}
							
							
							//Amortizacion
							amortizacion=(saldoPendiente*interes) / ((Math.pow((1+interes),cantidadDeCuotas))-1);
							
							//Interes de la cuota
							interesCuota=saldoPendiente*interes;
							
							//cuotauotas
							double cuota=amortizacion+interesCuota;
							
							//deuda
							double deuda=saldoPendiente-amortizacion;
							
							//saldo pendiente
							saldoPendiente=saldoPendiente-amortizacion;
							
							fechavto = Funcion.primerDiaHabil(Funcion.incrementaMes(fechavto)); //incremento un mes 
							
							Cuota nuevaCuota = new Cuota( fechavto, Funcion.redondear(saldoPendiente+amortizacion), Funcion.redondear(amortizacion), Funcion.redondear(interesCuota), Funcion.redondear(cuota),Funcion.redondear(deuda),prestamo);	
							
							//fechavto = Funcion.primerDiaHabil(Funcion.incrementaMes(fechavto)); //incremento un mes 
							
							listaCuotas.add(nuevaCuota);
							
						}
				
				return listaCuotas;
			}
	
			
			//verifico si el cliente puede solicitar el prestamo
			
			public boolean puedeAcceder (Cuota cuota) throws Exception{
				
				Cliente c= new Cliente();
				
				boolean accede=true;
				
				if(c.getIngreso()< cuota.getCuota()){
					accede=false;
					throw new Exception("El clienete no pude acceder al prestamo");
				}
				
				
			return accede;	
				
			}
	
}
