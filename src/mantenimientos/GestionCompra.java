package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.InterfaceCompra;
import model.Compra;
import model.DetalleCompra;
import model.DetalleVentas;
import model.OrdenCompra;
import model.OrdenRegistroCompra;
import model.Producto;
import model.RegistroCompra;
import model.Ventas;
import utils.MySQLconexion;

public class GestionCompra implements InterfaceCompra {

	/*orden compra*/
	public int ObtenerNumero() {
		// TODO Auto-generated method stub
		int numero=1; // tipo de resultado
		
		ResultSet rs=null;
		Connection con= null;
		PreparedStatement pst = null;
		try {
		   con = MySQLconexion.getConexion(); 
		   String sql = "select max(nro_ord_compra) from ordenCompra"; 		  

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

	/*registro compra*/
public int realizaCompra(RegistroCompra c, ArrayList<DetalleCompra> detalle) {
		
		Connection con = null;
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		int resultado=0;
			try {
				System.out.println("el numero de orden es "+c.getNroRegistroCompra());
				
				con=MySQLconexion.getConexion();
				con.setAutoCommit(false);
							//insert ventas values(null,'Factura','2018/11/10',1,1);
				String sql1="insert registro_compra values(null,?,?,?,?,?,?,?,?,?,?,?)";
				pst1=con.prepareStatement(sql1);
				
				if(c.getNroOrdenCompra()==0) {
				pst1.setString(1,null);
				}
				else {
					pst1.setInt(1, c.getNroOrdenCompra());
				}
				
				pst1.setString(2, c.getComprovante());
				pst1.setString(3, c.getFechaRegisCompra());
				pst1.setString(4, c.getFechaVenCompra());
				pst1.setInt(5, c.getIdProve());
				pst1.setInt(6, c.getIdUsu());
				pst1.setString(7, c.getCondicionesPago());
				pst1.setString(8, c.getContacto());
				pst1.setBoolean(9, c.isPagado());
				pst1.setBoolean(10, c.isAnulado());
				pst1.setBoolean(11, c.isRecibido());
				resultado=pst1.executeUpdate();
				con.commit();
								//insert into detalle_venta values (1,1,3,500.0)
				String sql2="insert into detalle_compra_registro_compra values(?,?,?,?);";
				for (DetalleCompra dt : detalle) {
					pst1=con.prepareStatement(sql2);
				
					pst1.setInt(1, c.getCodRegisCompra());
					pst1.setInt(2, dt.getIdprodu());
					pst1.setInt(3, dt.getCantidad());
					pst1.setDouble(4,dt.getPrecio());
					resultado=pst1.executeUpdate();
				}
									//update producto set stock_prod=stock_prod-1 where id_prod = 1;
						String sql3="update producto set stock_pro=stock_pro+? where id_prod = ?";
						for (DetalleCompra dt: detalle) {
							pst1 = con.prepareStatement(sql3);
							pst1.setInt(1, dt.getCantidad());
							pst1.setInt(2, dt.getIdprodu());
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

/*orden compra*/
@Override
public int ordenCompra(OrdenCompra c,ArrayList<DetalleCompra> d) {
	// TODO Auto-generated method stub
	System.out.println("entro al metodo orden de compra");
	System.out.println(d);

	Connection con = null;
	PreparedStatement pst1=null;
	PreparedStatement pst2=null;
	int resultado=0;
		try {
			
			con=MySQLconexion.getConexion();
			con.setAutoCommit(false);
						//insert ventas values(null,'Factura','2018/11/10',1,1);
			String sql1="insert  OrdenCompra values(null,curdate(),?,?,?,?,?,?,?)";
			pst1=con.prepareStatement(sql1);
			
			
			pst1.setString(1, c.getFechaEntrega());
			pst1.setString(2, c.getDirecEntrega());
			pst1.setString(3, c.getDirecFactura());
			pst1.setString(4, c.getCondicionPago());
			pst1.setString(5, c.getContacto());
			pst1.setInt(6, c.getCodProveedor());
			pst1.setInt(7, c.getCodUsuario());
			resultado=pst1.executeUpdate();
							//insert into detalle_venta values (1,1,3,500.0)
				String sql2="insert into detalle_compra_orden_compra values(?,?,?,?);";
				for (DetalleCompra dt : d) {
					pst1=con.prepareStatement(sql2);
					pst1.setInt(1,dt.getNroCompra());
					pst1.setInt(2, dt.getIdprodu());
					pst1.setInt(3, dt.getCantidad());
					pst1.setDouble(4,dt.getPrecio());
					resultado=pst1.executeUpdate();
				}
								//update producto set stock_prod=stock_prod-1 where id_prod = 1;
					/*String sql3="update producto set stock_prod=stock_prod+? where id_prod = ?";
					for (DetalleCompra dt: detalle) {
						pst1 = con.prepareStatement(sql3);
						pst1.setInt(1, dt.getCantidad());
						pst1.setInt(2, dt.getIdprodu());
						resultado=pst1.executeUpdate();
					}
				*/
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

/*orden compra*/
@Override
public ArrayList<OrdenCompra> listadoOrdenCompra() {
	ArrayList<OrdenCompra> lista=new ArrayList<OrdenCompra>();
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	try {
		con=MySQLconexion.getConexion();
		String sql="select o.nro_ord_compra,u.nom_usu,o.fech_orden_compra,p.nom_prov,o.contacto,p.telf_prov,p.email_prov,o.fech_entrega_compra,round(sum(deta.CantxUnidad*deta.precioUnidad),2) as 'total' from OrdenCompra o \r\n" + 
				"				join usuario u on o.id_usu=u.id_usu join proveedor p on p.id_prov=o.id_prove join detalle_compra_orden_compra deta on o.nro_ord_compra=deta.nro_ord_compra\r\n" + 
				"                group by o.nro_ord_compra,u.nom_usu,o.fech_orden_compra,p.nom_prov,o.contacto,p.telf_prov,p.email_prov,o.fech_entrega_compra\r\n" + 
				"";
		pst=(PreparedStatement) con.prepareStatement(sql);
		rs=pst.executeQuery();
		
		while (rs.next()) {
			OrdenCompra reg=new OrdenCompra();
			reg.setNroOrdenCompra(rs.getInt(1));
			reg.setNomUsuario(rs.getString(2));
			reg.setFechaOrdenCompra(rs.getString(3));
			reg.setNomProveedor(rs.getString(4));
			reg.setContacto(rs.getString(5));
			reg.setTelefono(rs.getString(6));
			reg.setEmail(rs.getString(7));
			reg.setFechaEntrega(rs.getString(8));
			reg.setTotal(rs.getDouble(9));
			
			lista.add(reg);
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "error en la sentencia"+e.getMessage());
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
public int ObtenerNumeroRegistroCompra() {
	// TODO Auto-generated method stub
	int numero=1; // tipo de resultado
	
	ResultSet rs=null;
	Connection con= null;
	PreparedStatement pst = null;
	try {
	   con = MySQLconexion.getConexion(); 
	   String sql = "select max(cod_regis_com) from registro_compra"; 		  

	   pst = con.prepareStatement(sql);
	   // parámetros según la sentencia
	   
	   
	   rs=pst.executeQuery(); // tipo de ejecución
	   
	   while(rs.next()){
		  numero=rs.getInt(1); 
		   //V004
	
		  numero+=1;
		  
	   }
	   System.out.println(numero);
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

/*ORDEN COMPRA*/
@Override
public ArrayList<OrdenCompra> listaOrdenCompra(int codigo) {
	ArrayList<OrdenCompra> lista=new ArrayList<OrdenCompra>();
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	try {
		con=MySQLconexion.getConexion();
		String sql=" select c.id_prod,p.desc_prod,c.CantxUnidad,c.precioUnidad  from OrdenCompra o \r\n" + 
				"				join detalle_compra_orden_compra c on o.nro_ord_compra=c.nro_ord_compra join producto p on c.id_prod=p.id_prod   where o.nro_ord_compra=?";
		pst=(PreparedStatement) con.prepareStatement(sql);
		pst.setInt(1, codigo);
		rs=pst.executeQuery();
		
		
		while (rs.next()) {
			OrdenCompra reg=new OrdenCompra();
			
			
			reg.setIdprodu(rs.getInt(1));
			reg.setNomProd(rs.getString(2));
			reg.setCantidad(rs.getInt(3));
			reg.setPrecio(rs.getDouble(4));
			
	
			lista.add(reg);
		}
		
			
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "error en la sentencia"+e.getMessage());
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
public int realizaCompra(Compra c, ArrayList<DetalleCompra> detalle) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public ArrayList<OrdenRegistroCompra> listadoRegistroCompra() {
	// TODO Auto-generated method stub
	ArrayList<OrdenRegistroCompra> lista=new ArrayList<OrdenRegistroCompra>();
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	try {
		con=MySQLconexion.getConexion();
		String sql="select  r.cod_regis_com,r.comprovante,r.fecha_regis_com,pro.nom_prov,r.nro_ord_compra,r.condiciones_pago,r.fecha_ven_com,sum(deta.CantxUnidad*deta.precioUnidad),r.pagado,r.anulado,r.recibido from registro_compra r \r\n" + 
				"								left join ordencompra ord on r.nro_ord_compra=ord.nro_ord_compra join proveedor pro on r.id_prove=pro.id_prov join detalle_compra_registro_compra deta on deta.cod_regis_com=r.cod_regis_com\r\n" + 
				"								group by r.cod_regis_com,r.comprovante,fecha_regis_com,pro.nom_prov,r.nro_ord_compra,ord.condiciones_pago,r.fecha_ven_com,r.pagado,r.anulado,r.recibido;";
		pst=(PreparedStatement) con.prepareStatement(sql);
		
		rs=pst.executeQuery();
		
		
		while (rs.next()) {
			OrdenRegistroCompra reg=new OrdenRegistroCompra();
			reg.setCodigo(rs.getInt(1));
			reg.setComprovante(rs.getString(2));
			reg.setFechaRegisCom(rs.getString(3));
			reg.setNomProveedor(rs.getString(4));
			reg.setNroOrdenCompra(rs.getInt(5));
			reg.setFormaPago(rs.getString(6));
			reg.setFechaVenCom(rs.getString(7));
			reg.setTotal(rs.getDouble(8));
			reg.setPagado(rs.getBoolean(9));
			reg.setAnulado(rs.getBoolean(10));
			reg.setRecibido(rs.getBoolean(11));
			
			lista.add(reg);
		}
		
			
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "error en la sentencia"+e.getMessage());
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
public ArrayList<OrdenRegistroCompra> listadoXcodigoRegisCompra(int codigo) {
	ArrayList<OrdenRegistroCompra> lista=new ArrayList<OrdenRegistroCompra>();
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	try {
		con=MySQLconexion.getConexion();
		String sql="select deta.id_prod,pro.desc_prod,deta.CantxUnidad,deta.precioUnidad from detalle_compra_registro_compra deta join producto pro on deta.id_prod=pro.id_prod \r\n" + 
				" join registro_compra regis on regis.cod_regis_com=deta.cod_regis_com where regis.cod_regis_com=?";
		pst=(PreparedStatement) con.prepareStatement(sql);
		pst.setInt(1, codigo);
		rs=pst.executeQuery();
		
		
		while (rs.next()) {
			OrdenRegistroCompra reg=new OrdenRegistroCompra();
			reg.setCodPro(rs.getInt(1));
			reg.setNomPro(rs.getString(2));
			reg.setCantidad(rs.getInt(3));
			reg.setPrecio(rs.getDouble(4));
			lista.add(reg);
		}
		
			
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "error en la sentencia"+e.getMessage());
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


/*registro compra*/
@Override
public ArrayList<OrdenRegistroCompra> listadoXFiltro(String filtro,String busquedad) {
	ArrayList<OrdenRegistroCompra> lista=new ArrayList<OrdenRegistroCompra>();
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	String sql=null;
	try {
		con=MySQLconexion.getConexion();
		
		if(filtro.equals("TIPO DOCUMENTO")) {
			
		
		 sql="select  r.cod_regis_com,r.comprovante,fecha_regis_com,pro.nom_prov,r.nro_ord_compra,r.condiciones_pago,r.fecha_ven_com,sum(deta.CantxUnidad*deta.precioUnidad),r.pagado,r.anulado,r.recibido from registro_compra r  \r\n" + 
		 		"								left join ordencompra ord on r.nro_ord_compra=ord.nro_ord_compra join proveedor pro on r.id_prove=pro.id_prov join detalle_compra_registro_compra deta on deta.cod_regis_com=r.cod_regis_com\r\n" + 
		 		"				                where r.comprovante like concat(?,'%')\r\n" + 
		 		"								group by r.cod_regis_com,r.comprovante,fecha_regis_com,pro.nom_prov,r.nro_ord_compra,ord.condiciones_pago,r.fecha_ven_com,r.pagado,r.anulado,r.recibido\r\n" + 
		 		"                 ";
		
		}	
		
		else if(filtro.equals("PERIODO")) {

			 sql="select  r.cod_regis_com,r.comprovante,fecha_regis_com,pro.nom_prov,r.nro_ord_compra,r.condiciones_pago,r.fecha_ven_com,sum(deta.CantxUnidad*deta.precioUnidad),r.pagado,r.anulado,r.recibido from registro_compra r  \r\n" + 
			 		"								left join ordencompra ord on r.nro_ord_compra=ord.nro_ord_compra join proveedor pro on r.id_prove=pro.id_prov join detalle_compra_registro_compra deta on deta.cod_regis_com=r.cod_regis_com\r\n" + 
			 		"                where r.fecha_Regis_com like concat(?,'%')\r\n" + 
			 		"								group by r.cod_regis_com,r.comprovante,fecha_regis_com,pro.nom_prov,r.nro_ord_compra,ord.condiciones_pago,r.fecha_ven_com,r.pagado,r.anulado,r.recibido ";
			
			
		}
		
		
		pst=(PreparedStatement) con.prepareStatement(sql);
		pst.setString(1, busquedad);
		rs=pst.executeQuery();
		
		
		while (rs.next()) {
			OrdenRegistroCompra reg=new OrdenRegistroCompra();
			reg.setCodigo(rs.getInt(1));
			reg.setComprovante(rs.getString(2));
			reg.setFechaRegisCom(rs.getString(3));
			reg.setNomProveedor(rs.getString(4));
			reg.setNroOrdenCompra(rs.getInt(5));
			reg.setFormaPago(rs.getString(6));
			reg.setFechaVenCom(rs.getString(7));
			reg.setTotal(rs.getDouble(8));
			lista.add(reg);
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "error en la sentencia"+e.getMessage());
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

/*orden de compra*/
@Override
public ArrayList<OrdenCompra> listadoXFiltroOrden(String filtro, String busquedad) {
	// TODO Auto-generated method stub
	ArrayList<OrdenCompra> lista=new ArrayList<OrdenCompra>();
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	String sql=null;
	try {
		con=MySQLconexion.getConexion();
		
		if(filtro.equals("USUARIO")) {
			
		
		 sql="select o.nro_ord_compra,u.nom_usu,o.fech_orden_compra,p.nom_prov,o.contacto,p.telf_prov,p.email_prov,o.fech_entrega_compra,round(sum(deta.CantxUnidad*deta.precioUnidad*1.18),2) as 'total' from OrdenCompra o \r\n" + 
		 		"							join usuario u on o.id_usu=u.id_usu join proveedor p on p.id_prov=o.id_prove join detalle_compra_orden_compra deta on o.nro_ord_compra=deta.nro_ord_compra\r\n" + 
		 		"                            where nom_usu like concat(?,'%')\r\n" + 
		 		"				group by o.nro_ord_compra,u.nom_usu,o.fech_orden_compra,p.nom_prov,o.contacto,p.telf_prov,p.email_prov,o.fech_entrega_compra";
		
		
		
		}	
		
		else if(filtro.equals("FECHA ORDEN")) {

			 sql="select o.nro_ord_compra,u.nom_usu,o.fech_orden_compra,p.nom_prov,o.contacto,p.telf_prov,p.email_prov,o.fech_entrega_compra,round(sum(deta.CantxUnidad*deta.precioUnidad*1.18),2) as 'total' from OrdenCompra o \r\n" + 
			 		"							join usuario u on o.id_usu=u.id_usu join proveedor p on p.id_prov=o.id_prove join detalle_compra_orden_compra deta on o.nro_ord_compra=deta.nro_ord_compra\r\n" + 
			 		"                            where fech_orden_compra like concat(?,'%')\r\n" + 
			 		"				group by o.nro_ord_compra,u.nom_usu,o.fech_orden_compra,p.nom_prov,o.contacto,p.telf_prov,p.email_prov,o.fech_entrega_compra";
			
			
		}
		else if(filtro.equals("PROVEEDOR")) {
			sql="select o.nro_ord_compra,u.nom_usu,o.fech_orden_compra,p.nom_prov,o.contacto,p.telf_prov,p.email_prov,o.fech_entrega_compra,round(sum(deta.CantxUnidad*deta.precioUnidad*1.18),2) as 'total' from OrdenCompra o \r\n" + 
					"							join usuario u on o.id_usu=u.id_usu join proveedor p on p.id_prov=o.id_prove join detalle_compra_orden_compra deta on o.nro_ord_compra=deta.nro_ord_compra\r\n" + 
					"                            where nom_prov like concat(?,'%')\r\n" + 
					"				group by o.nro_ord_compra,u.nom_usu,o.fech_orden_compra,p.nom_prov,o.contacto,p.telf_prov,p.email_prov,o.fech_entrega_compra";
		}
		pst=(PreparedStatement) con.prepareStatement(sql);
		pst.setString(1, busquedad);
		rs=pst.executeQuery();
		
		
		while (rs.next()) {
			OrdenCompra reg=new OrdenCompra();
			reg.setNroOrdenCompra(rs.getInt(1));
			reg.setNomUsuario(rs.getString(2));
			reg.setFechaOrdenCompra(rs.getString(3));
			reg.setNomProveedor(rs.getString(4));
			reg.setContacto(rs.getString(5));
			reg.setTelefono(rs.getString(6));
			reg.setEmail(rs.getString(7));
			reg.setFechaEntrega(rs.getString(8));
			reg.setTotal(rs.getDouble(9));
			lista.add(reg);
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "error en la sentencia"+e.getMessage());
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


/*orden compra*/
@Override
public ArrayList<OrdenCompra> obtenerDatosOrdenCompra(int codigo) {
	ArrayList<OrdenCompra> lista=new ArrayList<OrdenCompra>();
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	try {
		con=MySQLconexion.getConexion();
		String sql="select pro.nom_prov,ruc_prov,pro.direc_prov,o.condiciones_pago,u.nom_usu,pro.id_prov from OrdenCompra o \r\n" + 
				"							join detalle_compra_orden_compra c on o.nro_ord_compra=c.nro_ord_compra  join proveedor pro \r\n" + 
				"                            on pro.id_prov=o.id_prove join usuario u on u.id_usu=o.id_usu  where o.nro_ord_compra=?\r\n" + 
				"							group by pro.nom_prov,pro.ruc_prov,pro.direc_prov,o.condiciones_pago";
		pst=(PreparedStatement) con.prepareStatement(sql);
		pst.setInt(1, codigo);
		rs=pst.executeQuery();
		
		
		while (rs.next()) {
			OrdenCompra reg=new OrdenCompra();
			
			
			reg.setNomProveedor(rs.getString(1));
			reg.setRuc(rs.getString(2));
			reg.setDirecProveedor(rs.getString(3));
			reg.setCondicionPago(rs.getString(4));
			reg.setNomUsuario(rs.getString(5));
			reg.setCodProveedor(rs.getInt(6));
			lista.add(reg);
		}
		
			
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "error en la sentencia"+e.getMessage());
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
	
}
