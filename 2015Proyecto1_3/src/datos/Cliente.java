package datos;

import java.util.*;
import java.util.Set;
import datos.Funcion;

public class Cliente {
	
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private GregorianCalendar fechaDeNacimiento;
	private boolean baja;
	private double ingreso;

	private Set<Prestamo> prestamos;
	public Cliente(){}
	
	public Cliente(String apellido, String nombre, int dni,GregorianCalendar fechaDeNacimiento, double ingreso) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni= dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja=false;
		this.setIngreso(ingreso);
	}

	
	public long getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public GregorianCalendar getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(GregorianCalendar fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	
	public Set<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public double getIngreso() {
		return ingreso;
	}

	public void setIngreso(double ingreso) {
		this.ingreso = ingreso;
	}
	
	
	
	public String toString(){
		return (idCliente+" "+apellido+" "+nombre+" DNI: "+dni+" F.de Nacimiento:"+Funcion.traerFechaCorta(fechaDeNacimiento)+" "+baja+ "Ingreso: "+ ingreso);

	}

	
	
}