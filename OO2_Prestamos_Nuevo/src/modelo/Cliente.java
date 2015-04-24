package modelo;

public class Cliente {
	
	//atributos
	
	private long idCliente;
	private static long idSiguiente=0;
	
	private String apellido;
	private String nombre;
	private long dni;
	
	//constructor
	
	public Cliente(long idCliente, String apellido, String nombre, long dni){
		
		setId();
		this.apellido=apellido;
		this.nombre=nombre;
		this.dni=dni;
	}

	
	//getters y setters
	
	public long getIdcliente() {
		return idCliente;
	}
	protected void setId(){
		idSiguiente++;
		this.idCliente=idSiguiente;}
	
	
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}
	
	//metodos
	
	public boolean equals (Cliente c){
		
		boolean diferentes = false;
		
		if(this.dni==c.getDni()) {
			diferentes = true;
		}
		return diferentes;
	}
	
	
	public String toString(){
		
		String cadena="";
		
		return cadena+="\nId: "+ this.idCliente+ "\nApellido: "+this.apellido+ "\nNombre: "+this.nombre+ "\nDni: "+this.dni+"\n\n";
	}


}
