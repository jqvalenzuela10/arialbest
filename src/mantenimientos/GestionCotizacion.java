package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interfaces.InterfaceCotizacion;
import model.Cotizacion;
import model.DetalleCotizacion;

import utils.MySQLconexion;

public class GestionCotizacion implements InterfaceCotizacion{

	@Override
	public int agregar(Cotizacion c, ArrayList<DetalleCotizacion> deta) {
		Connection con = null;
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		int resultado=0;
			try {
				
				con=MySQLconexion.getConexion();
				con.setAutoCommit(false);
							//insert ventas values(null,'Factura','2018/11/10',1,1);
				String sql1="insert into cotizacion values(null,sysdate(),?,false,?,?,?,'vigente');";
				pst1=con.prepareStatement(sql1);

				pst1.setInt(1,c.getIdUsu());
				
				pst1.setDouble(2, c.getTotal());
				pst1.setString(3, c.getFechaVenci());
				pst1.setInt(4, c.getIdCli());
			
			
				resultado=pst1.executeUpdate();
				con.commit();
								//insert into detalle_venta values (1,1,3,500.0)
					String sql2="insert into detalle_cotizacion values(?,?,?,?,?);";
					for (DetalleCotizacion dt : deta) {
						pst1=con.prepareStatement(sql2);
						System.out.println(dt.getNroCoti());
						pst1.setInt(1,c.getNroCoti());
						pst1.setInt(2, dt.getIdPro());
						pst1.setInt(3, dt.getCantidad());
						pst1.setDouble(4,dt.getPrecio());
						pst1.setDouble(5, dt.getDescuento());
						resultado=pst1.executeUpdate();
					}
					con.commit();
						
			} catch (Exception ex) {
				try {
					con.rollback();
					System.out.println("Ocurrio un evento inesperado en el metodo insertar boleta : "+ex.getMessage());
					resultado=0;
				} catch (SQLException e) {
					System.out.println("Error en el Rollback "+e.getMessage());
				}
			}
			finally {
				try {
					if(pst1!=null)pst1.close();
					if(pst2!=null)pst2.close();
					if(con!=null)con.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar :"+e.getMessage());
				}
			}
		return resultado;
	}

	@Override
	public int ObtenerNumero() {
		// TODO Auto-generated method stub
		int numero=1; // tipo de resultado
		
		ResultSet rs=null;
		Connection con= null;
		PreparedStatement pst = null;
		try {
		   con = MySQLconexion.getConexion(); 
		   String sql = "select max(nro_cotizacion) from cotizacion"; 		  

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia
		   
		   
		   rs=pst.executeQuery(); // tipo de ejecución
		   
		   while(rs.next()){
			  numero=rs.getInt(1); 
			   //V004
		
			  numero=numero+1;
		   }

		   // Acciones adicionales en caso de consultas
		} catch (Exception e) {
		   System.out.println("error en ultimo numero : "+e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		
		return numero; 
	}

}
