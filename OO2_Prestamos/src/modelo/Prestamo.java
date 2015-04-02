package modelo;

import java.util.GregorianCalendar;


public class Prestamo {
	
	//atributos
	
	private long idPrestamo;
	private static long idSiguiente=0;
	
	private double monto;
	private double intereses;
	private int cantidadCuotas;
	private GregorianCalendar fecha;
	private Cliente cliente;

	
	//constructor
	
	public Prestamo(long id,double monto, double intereses, int cantidadCuotas, GregorianCalendar fecha, Cliente cliente){
		setId();
		this.monto=monto;
		this.intereses=intereses;
		this.cantidadCuotas=cantidadCuotas;
		this.fecha=fecha;
		this.cliente=cliente;
	}

	
	//gettes y setters
	
	public long getIdPrestamo() {
		return idPrestamo;
	}
	protected void setId(){
		idSiguiente++;
		this.idPrestamo=idSiguiente;}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public double getIntereses() {
		return intereses;
	}


	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}


	public int getCantidadCuotas() {
		return cantidadCuotas;
	}


	public void setCantidadCuotas(int cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}


	public GregorianCalendar getFecha() {
		return fecha;
	}


	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	//metodos
	
	public boolean equals(Prestamo p){
		
		boolean diferentes = false;
		
		if(this.idPrestamo==p.getIdPrestamo()){
			diferentes = true;
		}
		return diferentes;
		}
	
	
	//tostring
	
	public String toString(){
	String cadena="";
	
	cadena="\nID Prestamo: "+this.idPrestamo+ "\nDatos del Cliente:\n"+cliente.getApellido()+" "+ cliente.getNombre()
			+"\nDNI: "+cliente.getDni()+ "\nFecha de Prestamo: "+Funcion.traerFechaCorta(this.fecha)
			+"\nMonto: "+ this.monto +"\nIntereses: "+this.intereses+ "\nCantidad de Cuotas:"+ this.cantidadCuotas+"\n\n";
	
	return cadena;
}



}
