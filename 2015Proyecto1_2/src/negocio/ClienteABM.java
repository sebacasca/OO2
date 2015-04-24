package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao=new ClienteDao();
	
	//metodos
	
	//traer cliente
	public Cliente traerCliente(long idCliente)throws Exception{
		
		Cliente c= dao.traerCliente(idCliente);
		
		if(c==null) throw new Exception("Cliente no Encontrado");//no se si esta bien la compracion o habria q comprar por id
	
	return c;
	}

	public Cliente traerCliente(int dni)throws Exception{
		
		Cliente c= dao.traerCliente(dni);
		
		// implementar si c es null lanzar Exception
		if(c==null) throw new Exception("Cliente no Encontrado");
	
	return c;
	}

	public int agregar(String apellido, String nombre, int dni,GregorianCalendar fechaDeNacimiento) throws Exception{
		
		Cliente c=new Cliente(apellido, nombre, dni,fechaDeNacimiento);
		
		//consultar si existe un cliente con el mismo dni, si existe arrojar la Excepcion
		
		if(dao.traerCliente(dni)!= null){
			
			throw new Exception("Cliente ya existe");
		}
		
	return dao.agregar(c);
	}

	
	@SuppressWarnings("null")
	public void modificar(Cliente c) throws Exception{
		
		/* implementar antes de actualizar que no exista un clientecon el mismo documento a modificar y con el mismo id, lanzar la Exception */
		
		if (c!=null){
			dao.actualizar(c);
		}
			
		else{
			throw new Exception("Cliente DNI: " +c.getDni()+ " no existe para modificar.");
		}
	
	}

	public void eliminar(long idCliente) throws Exception{/*en este caso es física en gral. no se se aplicaría este caso de uso, si se hiciera habría que validar que el cliente no tenga dependencias*/
		
		Cliente c=dao.traerCliente(idCliente);
		
		//Implementar que si es null que arroje la excepción la Excepción
		
		if(c!=null){
			dao.eliminar(c);
		}
		
		else{throw new Exception ("El Cliente a eliminar no existe");}		
	}
	
	public List<Cliente> traerCliente(){
		
	return dao.traerCliente();}
}
