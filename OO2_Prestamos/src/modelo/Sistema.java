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


public class Sistema{
	
//ATRIBUTOS

private List<Cliente> listaCliente  = new ArrayList<Cliente>();
private List<Prestamo> listaPrestamos  = new ArrayList<Prestamo>();
	
	
//CONSTRUCTOR	
	public Sistema(){
		
		this.setListaCliente();
		this.setListaPrestamos();
	}
	
	

//GETTERS 
	
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	public List<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}
	
	
//SETTERS 
	private void setListaCliente(){
			
			try {
		        File dirBase = new File("src/modelo/cliente.xml");
		     
		        String ruta = dirBase.getAbsolutePath();
		        
		        BufferedReader br = new BufferedReader(new FileReader(ruta));
		        
		        String entrada;
		        String cadena = "";
		        
		        while ((entrada = br.readLine()) != null)
		            cadena += entrada;
		    
		        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		        DocumentBuilder db = dbf.newDocumentBuilder();
		        
		        InputSource archivo = new InputSource();
		        archivo.setCharacterStream(new StringReader(cadena));
		        
		        Document documento = db.parse(archivo);
		        documento.getDocumentElement().normalize();
		 
		        NodeList nodeLista = documento.getElementsByTagName("cliente");
		        
		        String[] tags = {"idCliente","apellido","nombre","dni"};
		        
		        for (int s = 0; s < nodeLista.getLength(); s++) {
		        
		        	Node nodo = nodeLista.item(s);
		            String[] valores = new String[tags.length];            
		            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
		                Element elemento = (Element) nodo;
		                for (int i = 0; i < tags.length; i++) {
		                    NodeList nombreElementoLista = elemento.getElementsByTagName(tags[i]);
		                    Element nombreElemento = (Element) nombreElementoLista.item(0);
		                    NodeList nombre = nombreElemento.getChildNodes();
		                    valores[i] = ((Node) nombre.item(0)).getNodeValue().toString();
		            }
		                
		                long idCliente= Long.parseLong(valores[0]);
		                String apellido=valores[1];                     
		                String nombre =valores[2];
		                long dni=Long.parseLong(valores[3]);
		                Cliente c=new Cliente(idCliente, apellido,nombre,dni); 
		      
		                listaCliente.add(c);
		          
		            }
		        }
		        br.close();
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
	}
	
	
	private void setListaPrestamos(){
		
		try {
	        File dirBase = new File("src/modelo/prestamo.xml");
	     
	        String ruta = dirBase.getAbsolutePath();
	        
	        BufferedReader br = new BufferedReader(new FileReader(ruta));
	        
	        String entrada;
	        String cadena = "";
	        
	        while ((entrada = br.readLine()) != null)
	            cadena += entrada;
	        
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        
	        InputSource archivo = new InputSource();
	        archivo.setCharacterStream(new StringReader(cadena));
	        
	        Document documento = db.parse(archivo);
	        documento.getDocumentElement().normalize();
	 
	        NodeList nodeLista = documento.getElementsByTagName("prestamo");
	        
	        String[] tags = {"idPrestamo","fecha","monto","interes","cantCuotas","idCliente"};
	        
	        for (int s = 0; s < nodeLista.getLength(); s++) {
	        
	        	Node nodo = nodeLista.item(s);
	            String[] valores = new String[tags.length];            
	            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
	                Element elemento = (Element) nodo;
	                for (int i = 0; i < tags.length; i++) {
	                    NodeList nombreElementoLista = elemento.getElementsByTagName(tags[i]);
	                    Element nombreElemento = (Element) nombreElementoLista.item(0);
	                    NodeList nombre = nombreElemento.getChildNodes();
	                    valores[i] = ((Node) nombre.item(0)).getNodeValue().toString();
	            }
	          
	                long idPrestamo= Long.parseLong(valores[0]);
	                GregorianCalendar fecha= Funcion.traerFecha(valores[1]);                   
	                double monto =Double.parseDouble(valores[2]);
	                double interes=Double.parseDouble(valores[3]);
	                int cantCuotas=Integer.parseInt(valores[4]);
	                long idCliente=Long.parseLong(valores[5]);
	                
	                
	                Prestamo p=new Prestamo(idPrestamo,monto, interes, cantCuotas,fecha,traerClientePorID(idCliente)); 
	              
	                listaPrestamos.add(p);
	          
	            }
	        }
	        br.close();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}

	
	//METODOS
	
	//traer cliente
	
	public Cliente traerCliente(long dni)throws Exception{
		
		boolean encontrado=true;
		int i =0;
		Cliente cliente= null;
		
		while(i<listaCliente.size() && encontrado){
			if(listaCliente.get(i).getDni()==dni){
				 cliente=listaCliente.get(i);
				encontrado=false;}
			i+=1;}
		
	return cliente;
	}	
	
	//traer  prestamo
	
	public Prestamo traerPrestamo(long idPrestamo)throws Exception{
		
		boolean encontrado=true;
		int i =0;
		Prestamo prestamo= null;
		
		while(i<listaPrestamos.size() && encontrado){
			if(listaPrestamos.get(i).getIdPrestamo()==idPrestamo){
				 prestamo=listaPrestamos.get(i);
				encontrado=false;}
			i+=1;}
		
	return prestamo;
	}
	
	
	//traer lista prestamos
	
	public List<Prestamo> traerPrestamo(Cliente cliente)throws Exception{
			
		int i=0;
		List<Prestamo> listado= new ArrayList<Prestamo>();
			
		while(i<listaPrestamos.size()){
			
			if(listaPrestamos.get(i).getCliente().equals(cliente)){
				listado.add(listaPrestamos.get(i));
			}
			i+=1;
		}
			
		if(listado.size()==0){throw new Exception("No hay concidencia.");}
		
		i=0;
		while(i<listado.size()){
				
			System.out.println(listado.get(i).toString());
				i+=1;
		}
	return listado;
	}	
	
	
	//Generar cuotas para un préstamo (devuelve una lista de cuotas)
	//FALTA TERMINAR ESTE METODO , LO TENGO Q PENSAR UN POCO MAS JAJA
		
		public List<Cuota> generarCuotas(Prestamo prestamo)throws Exception{
			
			Cuota c = null;
			
			//Cuota cuota=new Cuota(c.getFecha(), c.getSaldoPendiente(), c.getAmortizacion(), c.getInteresesCuota(), c.getCuota(),c.getDeuda(), prestamo);
			
			int i=0;
			int n=prestamo.getCantidadCuotas();
			double total=prestamo.getMonto();
			int numeroCuota=c.getNroCuota();
			double amortizacion=c.getAmortizacion();
			double saldoPendiente=c.getSaldoPendiente();
			double interesesCuota=c.getInteresesCuota();
			double cuotas=c.getCuota();
			double deuda=c.getDeuda();
			
			List<Cuota> listaCuotas= new ArrayList<Cuota>();
			
		
			while(i<listaCuotas.size()){
				
				//if (numeroCuota==1){
					
					amortizacion= (saldoPendiente*prestamo.getIntereses()) / ((Math.pow(1+prestamo.getIntereses(),n))-1);//no esta terminado
					
					interesesCuota=saldoPendiente*prestamo.getIntereses();
					
					cuotas=amortizacion+interesesCuota;
					
					deuda=saldoPendiente-amortizacion;
					
					saldoPendiente=saldoPendiente-amortizacion;
					
				//}
			}
			
		//antes de agregar a la lista instanciar un objeto Cuota y luego agregarlo a la lista
			
		listaCuotas.add(c);
			
		return listaCuotas;
		}
	
	
	//traer cliente
	
	public Cliente traerClientePorID(long id)throws Exception{
		
		boolean encontrado=true;
		int i =0;
		Cliente cliente= null;
		
		while(i<listaCliente.size() && encontrado){
			if(listaCliente.get(i).getIdcliente()==id){
				cliente=listaCliente.get(i);
				encontrado=false;
			}
		i+=1;
		}
		
	return cliente;
	}	
	
	
	@Override
	public String toString() {
			return "Lista de clientes:\n" + listaCliente+"\n\n\nLista de prestamos:\n" +listaPrestamos ;
		}

}
