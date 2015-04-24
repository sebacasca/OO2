package datos;
import java.util.*;
import datos.Funciones;

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
		String prestamo= "\nCliente: "+cliente+"\n";
		prestamo+="ID_Prestamo: "+ idPrestamo+ "\nMonto: $ "+monto+"\nFecha: "+Funciones.traerFechaCorta(fecha)+"\nInteres: "+interes+"\nCant.de Cuotas: "+cantCuotas;
	
	return prestamo;
	}

}
