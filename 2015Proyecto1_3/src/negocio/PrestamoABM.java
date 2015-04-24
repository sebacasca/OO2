//preguntar si alta, baja y modificacion cumple el analisis de reglas de negocio??

package negocio;
import dao.PrestamoDao;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	
	private PrestamoDao dao=new PrestamoDao();
	
	public Prestamo traerPrestamo(long idPrestamo) throws Exception{
		
		Prestamo p =dao.traerPrestamo(idPrestamo);
		
		//Implementar: si el no existe el prestamo lanzar la excepción
		if(p==null){
			
			throw new Exception("El prestamo no existe");
		}
		
	return p;
	}

	
	public List<Prestamo> traerPrestamo(Cliente c) {
		
		return dao.traerPrestamo(c);
	}
	
	
	//alta
	
	public int agregarPrestamo(GregorianCalendar fecha, double monto, double interes,int cantCuotas, Cliente cliente) throws Exception{
		
		Prestamo p=new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		
		long id= p.getIdPrestamo(); 
		
		if(dao.traerPrestamo(id)!= null){
			
			throw new Exception("El prestamo ya existe");
		}
		
	return dao.agregarPrestamo(p);
	}
	
	
	//baja
	
	public void eliminarPrestamo(long idPrestamo) throws Exception{
		
		Prestamo p= dao.traerPrestamo(idPrestamo);
		
		if(p != null){
			dao.eliminarPrestamo(p);
		}
		
		else{
			throw new Exception ("El prestamo a eliminar no existe");
		}
	}
	
	
	//modificacion
	
	public void modificarPrestamo(Prestamo p) throws Exception{
		
		if (p != null){
			dao.actualizarPrestamo(p);
		}
		
		else{
			throw new Exception("El prestamo id: "+ p.getIdPrestamo()+ "no existe");
		}
	}
	
}
