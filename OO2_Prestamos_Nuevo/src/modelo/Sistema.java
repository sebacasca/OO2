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
	public void setListaCliente(){
			
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
	
	
	public void setListaPrestamos(){
		
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
		
		/*while(i<listado.size()){
				
			System.out.println(listado.get(i).toString());
				i+=1;
		}*/
	return listado;
	}	
	
	
	//Generar cuotas para un préstamo (devuelve una lista de cuotas)
	
	public List<Cuota> generarCuotas(Prestamo prestamo){
		
		   List<Cuota> listaCuotas= new ArrayList<Cuota>();
		   
		   //cantidad de cuotas totales
			int n=prestamo.getCantidadCuotas();
			//cantidad de cuotas a usar
			int cantidadDeCuotas=0;
			//saldo pendiente
			double saldoPendiente=prestamo.getMonto();
			//amortizacion
			double amortizacion=0;
			//interes en porciento por ejemplo 12.5% = (12.5)/100
			double interes=(prestamo.getIntereses()/100);
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