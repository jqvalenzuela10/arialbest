package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.InterfaceCorteCaja;
import model.Clientes;
import model.CorteCaja;
import model.CorteCajaListadito;
import model.DetalleCorteCaja;
import model.DetalleVentas;
import model.Movimiento;
import utils.MySQLconexion;

public class GestionCorteCaja implements InterfaceCorteCaja{
	@Override
	public int ObtenerNumero() {
		// TODO Auto-generated method stub
				int numero=1; // tipo de resultado
				
				ResultSet rs=null;
				Connection con= null;
				PreparedStatement pst = null;
				try {
				   con = MySQLconexion.getConexion(); 
				   String sql = "select max(codigo_corte_caja) from corteCaja;"; 		  

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
	@Override
	public int registrarCorteDeCaja(CorteCaja c, ArrayList<DetalleCorteCaja> detalle ) {
		Connection con = null;
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		int resultado=0;
			try {
				
				con=MySQLconexion.getConexion();
				con.setAutoCommit(false);
							//insert ventas values(null,'Factura','2018/11/10',1,1);
				String sql1="insert into corteCaja values(null,SYSDATE(),?,?,?,?,?,?,?);";
				pst1=con.prepareStatement(sql1);

				pst1.setInt(1, c.getCodCaja());
				pst1.setDouble(2, c.getContado());
				pst1.setDouble(3, c.getCalculado());
				pst1.setDouble(4, c.getDiferencia());
				pst1.setDouble(5, c.getRetirado());
				pst1.setString(6, c.getNomUsu());
				pst1.setString(7, c.getDescripcion());
			
				resultado=pst1.executeUpdate();
				con.commit();
								//insert into detalle_venta values (1,1,3,500.0)
					String sql2="insert into detalle_corte_caja values (?,?,?)";
					for (DetalleCorteCaja dt : detalle) {
						pst1=con.prepareStatement(sql2);
					
						pst1.setInt(1,c.getCodCorteCaja());
						pst1.setInt(2, dt.getCodMovi());
						pst1.setString(3, dt.getNomCaja());
					
						resultado=pst1.executeUpdate();
					}
					con.commit();
									//update producto set stock_prod=stock_prod-1 where id_prod = 1;
						String sql3="update movimiento set tiene_corte_caja=true where  cod_caja=?";
						for (DetalleCorteCaja m: detalle) {
							pst1 = con.prepareStatement(sql3);
						
							pst1.setInt(1,c.getCodCaja());
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
	public ArrayList<CorteCaja> calcularCalculado(int codCaja) {
		ArrayList<CorteCaja> lista=new ArrayList<>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select sum(m.entrada)-sum(m.salida) from movimiento m where  cod_caja=?";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1,codCaja);
		
			rs=pst.executeQuery();
			
			while (rs.next()) {
				CorteCaja c=new CorteCaja();
				c.setCalculado(rs.getDouble(1));
				lista.add(c);
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia calcularCalculado"+e.getMessage());
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;
	}



	@Override
	public ArrayList<DetalleCorteCaja> listadoParaElDetalle(int codigoCaja) {
		ArrayList<DetalleCorteCaja> lista=new ArrayList<>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select m.cod_movimiento,c.nom_caja from movimiento m join caja c on m.cod_caja=c.cod_caja  where m.cod_caja=? and m.tiene_corte_caja=false;";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1,codigoCaja);
			
			rs=pst.executeQuery();
			
			while (rs.next()) {
				DetalleCorteCaja c=new DetalleCorteCaja();
				c.setCodMovi(rs.getInt(1));
				c.setNomCaja(rs.getString(2));
				
				lista.add(c);
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia listadoParaElDetalle"+e.getMessage());
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;
	}
	@Override
	public ArrayList<CorteCajaListadito> listadito(int codCaja) {
		ArrayList<CorteCajaListadito> lista=new ArrayList<>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select c.fecha,ca.nom_caja,c.contado,c.calculado,c.diferencia,c.retirado,c.nom_usuario,c.descripcion,SUBSTRING(c.fecha,1,10),SUBSTRING(c.fecha,11,length(fecha)-1) from corteCaja c join caja ca on c.cod_caja=ca.cod_caja  where c.codigo_corte_caja=?";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1,codCaja);
			
			rs=pst.executeQuery();
			
			while (rs.next()) {
				CorteCajaListadito c=new CorteCajaListadito();
				c.setFecha(rs.getString(1));
				c.setNomCaja(rs.getString(2));
				c.setContado(rs.getDouble(3));
				c.setCalculado(rs.getDouble(4));
				c.setDiferencia(rs.getDouble(5));
				c.setRetirado(rs.getDouble(6));
				c.setNomUsu(rs.getString(7));
				c.setDesUsu(rs.getString(8));
				c.setFechaCorteCaja(rs.getString(9));
				c.setHoraCorteCaja(rs.getString(10));
				
				
				lista.add(c);
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia listadoParaElDetalle"+e.getMessage());
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;
	}
	@Override
	public ArrayList<CorteCajaListadito> listaditoult() {
		ArrayList<CorteCajaListadito> lista=new ArrayList<>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select c.codigo_corte_caja,c.fecha,ca.nom_caja,c.contado,c.calculado,c.diferencia,c.retirado,c.nom_usuario,c.descripcion,SUBSTRING(c.fecha,1,10),SUBSTRING(c.fecha,11,length(fecha)-1) from corteCaja c  join caja ca on c.cod_caja=ca.cod_caja";
			pst=(PreparedStatement) con.prepareStatement(sql);
			
			
			rs=pst.executeQuery();
			
			while (rs.next()) {
				CorteCajaListadito c=new CorteCajaListadito();
				c.setCodCaja(rs.getInt(1));
				c.setFecha(rs.getString(2));
				c.setNomCaja(rs.getString(3));
				c.setContado(rs.getDouble(4));
				c.setCalculado(rs.getDouble(5));
				c.setDiferencia(rs.getDouble(6));
				c.setRetirado(rs.getDouble(7));
				c.setNomUsu(rs.getString(8));
				c.setDesUsu(rs.getString(9));
				c.setFechaCorteCaja(rs.getString(10));
				c.setHoraCorteCaja(rs.getString(11));
				
				
				lista.add(c);
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia listadoParaElDetalle"+e.getMessage());
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;
	}
	@Override
	public ArrayList<Movimiento> listadoXmovimiento(int codCaja) {
		ArrayList<Movimiento> lista=new ArrayList<>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select deta.cod_movimiento,m.fecha,m.Nro_ven,m.cod_regis_com,m.entrada,m.salida from corteCaja co join detalle_corte_caja deta on co.codigo_corte_caja=deta.codigo_corte_caja join movimiento m on m.cod_movimiento=deta.cod_movimiento where co.codigo_corte_caja=?";
			pst=(PreparedStatement) con.prepareStatement(sql);
			
			pst.setInt(1,codCaja);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Movimiento c=new Movimiento();
				c.setCodMovi(rs.getInt(1));
				c.setFecha(rs.getString(2));
				c.setNro_ven(rs.getInt(3));
				c.setCod_regis_com(rs.getInt(4));
				c.setEntrada(rs.getDouble(5));
				c.setSalida(rs.getDouble(6));
				
				
				lista.add(c);
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia listadoParaElDetalle"+e.getMessage());
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;
	}
	/*
	@Override
	public double obtenerSaldo(int codCaja) {
		double saldo=0;
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select saldo from movimiento where cod_Caja=? order by cod_movimiento desc limit 1;";
			pst=(PreparedStatement) con.prepareStatement(sql);
			
			pst.setInt(1,codCaja);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				saldo=rs.getDouble(1);
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia listadoParaElDetalle"+e.getMessage());
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return saldo;
	}

*/

	

}
