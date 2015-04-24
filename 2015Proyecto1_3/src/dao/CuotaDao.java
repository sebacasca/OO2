package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Prestamo;
import datos.Cuota;

public class CuotaDao {
	
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException{
		
		session= HibernateUtil.getSessionFactory().openSession();
		
		tx= session.beginTransaction();
	}

	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos");
	}
	
	
	
	public Cuota traerCuota (long idCuota) throws HibernateException{
		
		Cuota objeto=null;
		
		try{
			iniciaOperacion();
			String hQL="from Cuota c inner join fetch c.prestamo p where p.idPrestamo="+ idCuota;
			objeto=(Cuota) session.createQuery(hQL).uniqueResult();
		}
		finally{
			session.close();
		}
	return objeto;
	}

	
	public List<Cuota> traerCuota(Prestamo p) throws HibernateException {

		List<Cuota> lista=null;

		try {
			iniciaOperacion();
			String hQL="from Cuota c inner join fetch c.prestamo p where p.idPrestamo="+p.getIdPrestamo();
			lista = session .createQuery(hQL).list() ;
		} finally {
			session.close();
		}

	return lista;
	}
	
	
	
}