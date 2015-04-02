package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Cuota {
	
	//atributos
	
	private long idCuota;
	private static long idSiguiente=0;
	
	private int nroCuota;
	private static int cuotaSiguiente=0;
	
	private GregorianCalendar fecha;
	private double saldoPendiente;
	private double amortizacion;
	private double interesesCuota;
	private double cuota;
	private double deuda;
	private Prestamo prestamo;
	
	private List<String> listaFeriados  = new ArrayList<String>();
	
	//constructor
	
	public Cuota(GregorianCalendar fecha, double saldoPendiente, double amortizacion, double interesesCuota, double cuota, double deuda, Prestamo prestamo){
		
		setId();
		setnroCuota();
		this.fecha=fecha;
		this.saldoPendiente=saldoPendiente;
		this.amortizacion=amortizacion;
		this.interesesCuota=interesesCuota;
		this.cuota=cuota;
		this.deuda=deuda;
		this.prestamo=prestamo;
	}
	
	
	//getters y setters
	
	public long getIdCuota() {
		return idCuota;
	}
	protected void setId(){
		idSiguiente++;
		this.idCuota=idSiguiente;}
	
	public int getNroCuota() {
		return nroCuota;
	}
	protected void setnroCuota(){
		cuotaSiguiente++;
		this.nroCuota=cuotaSiguiente;}


	public GregorianCalendar getFecha() {
		return fecha;
	}


	public void setFecha(GregorianCalendar fecha)throws Exception {
		
		if(Funcion.esDiaHabil(fecha)){
		
				this.fecha = fecha;
		}
		else{
			throw new Exception("hacer la parta para cambiar a dia habil siguiente");
			
			//trabajo con xml para traer los feriados
			
			
		}
	
	}


	public double getSaldoPendiente() {
		return saldoPendiente;
	}


	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}


	public double getAmortizacion() {
		return amortizacion;
	}


	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}


	public double getInteresesCuota() {
		return interesesCuota;
	}


	public void setInteresesCuota(double interesesCuota) {
		this.interesesCuota = interesesCuota;
	}


	public double getCuota() {
		return cuota;
	}


	public void setCuota(double cuota) {
		this.cuota = cuota;
	}


	public double getDeuda() {
		return deuda;
	}


	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}


	public Prestamo getPrestamo() {
		return prestamo;
	}


	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
	
	//metodos
	
	public String toString(){
		
		String cadena="";
		
		cadena= "NRO Cuota: "+this.nroCuota+ "\nFecha VTO: "+ Funcion.traerFechaCorta(this.fecha)+ "\nSaldo Pendiente: "+ this.saldoPendiente
				+"\nAmortizacion: "+ this.amortizacion +"\nInteres: "+this.interesesCuota+ "\nCuota:"+ this.cuota+ "\nDeuda: "+ this.deuda;
				
		return cadena;
	}
	
	
	
}
	
	

