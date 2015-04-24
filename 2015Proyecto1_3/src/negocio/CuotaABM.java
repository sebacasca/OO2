package negocio;

import dao.CuotaDao;
import java.util.List;
import datos.Cuota;
import datos.Prestamo;

	public class CuotaABM {
		
		private CuotaDao dao=new CuotaDao();
		
		public Cuota traerPrestamo(long idCuota) throws Exception{
			
			Cuota c =dao.traerCuota(idCuota);
			
			if(c==null){
				
				throw new Exception("El prestamo no existe");
			}
			
		return c;
		}

		
		public List<Cuota> traerCuotas(Prestamo p) {
			
			return dao.traerCuota(p);
		}

}
