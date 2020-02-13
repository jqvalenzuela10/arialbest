package mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Interfaces.InterfaceProducto;

import model.Producto;
import utils.MySQLconexion;

public class GestionProductos implements InterfaceProducto{

	public ArrayList<Producto> listado() {
		ArrayList<Producto> lista=new ArrayList<Producto>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select*from producto";
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Producto reg=new Producto();
				reg.setCodigo(rs.getInt(1));
				reg.setCodbarra(rs.getInt(2));
				reg.setDescripcion(rs.getString(3));
				reg.setMarca(rs.getString(4));
				
				reg.setPrecioProCom(rs.getDouble(5));
				reg.setPrecioProVen(rs.getDouble(6));
				reg.setUnidadCompra(rs.getString(7));
				reg.setUnidadVenta(rs.getString(8));
				reg.setFactor(rs.getInt(9));
				reg.setNomCat(rs.getString(10));
				reg.setCodregistrosani(rs.getString(11));
				reg.setCodSunat(rs.getInt(12));
				reg.setLote(rs.getBoolean(13));
			reg.setStock(rs.getInt(14));
				
				
				
			
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
	public ArrayList<Producto> listadoXcodigo(int codigo) {
		// TODO Auto-generated method stub
				ArrayList<Producto> lista=new ArrayList<Producto>();
				ResultSet rs=null;
				Connection con=null;
				PreparedStatement pst=null;
				try {
					con=MySQLconexion.getConexion();
					String sql="select*from producto where cod_barra=?";
					pst=(PreparedStatement) con.prepareStatement(sql);
					pst.setInt(1,codigo);
					rs=pst.executeQuery();
					
					while (rs.next()) {
						Producto reg=new Producto();
						reg.setCodigo(rs.getInt(1));
						reg.setCodbarra(rs.getInt(2));
						reg.setDescripcion(rs.getString(3));
						reg.setMarca(rs.getString(4));
						
						reg.setPrecioProCom(rs.getDouble(5));
						reg.setPrecioProVen(rs.getDouble(6));
						reg.setUnidadCompra(rs.getString(7));
						reg.setUnidadVenta(rs.getString(8));
						reg.setFactor(rs.getInt(9));
						reg.setNomCat(rs.getString(10));
						reg.setCodregistrosani(rs.getString(11));
						reg.setCodSunat(rs.getInt(12));
						reg.setLote(rs.getBoolean(13));
					reg.setStock(rs.getInt(14));
						
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
	public ArrayList<Producto> listado(String nombre) {
		// TODO Auto-generated method stub
		ArrayList<Producto> lista=new ArrayList<Producto>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call sp_BuscarPro(?)}";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,nombre);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Producto reg=new Producto();
				reg.setCodigo(rs.getInt(1));
				reg.setCodbarra(rs.getInt(2));
				reg.setDescripcion(rs.getString(3));
				reg.setMarca(rs.getString(4));
				
				reg.setPrecioProCom(rs.getDouble(5));
				reg.setPrecioProVen(rs.getDouble(6));
				reg.setUnidadCompra(rs.getString(7));
				reg.setUnidadVenta(rs.getString(8));
				reg.setFactor(rs.getInt(9));
				reg.setNomCat(rs.getString(10));
				reg.setCodregistrosani(rs.getString(11));
				reg.setCodSunat(rs.getInt(12));
				reg.setLote(rs.getBoolean(13));
				reg.setStock(rs.getInt(14));
				
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
	public int Agregar(Producto reg) {
	
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="insert into Producto values (null,?,?,?,?,?,?,?,?,?,?,?,?,default)";
			pst=(PreparedStatement) con.prepareStatement(sql);
		
			pst.setInt(1, reg.getCodbarra());
			pst.setString(2, reg.getDescripcion());
			pst.setString(3,reg.getMarca());
			pst.setDouble(4, reg.getPrecioProCom());
			pst.setDouble(5, reg.getPrecioProVen());
			pst.setString(6,reg.getUnidadCompra());
			pst.setString(7, reg.getUnidadVenta());
			pst.setInt(8, reg.getFactor());
			pst.setString(9,reg.getNomCat());
			pst.setString(10,reg.getCodregistrosani());
			pst.setInt(11,reg.getCodSunat());
			pst.setBoolean(12, reg.getLote());
			
			
			rs=pst.executeUpdate();
			
			
			
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
		return rs;
		
	}

public int actualizar(Producto reg) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="   update producto set cod_barra=? ,desc_prod=?,marca_prod=?,pre_prod_compra=?,pre_prod_lista=?,unidadCompra=?,unidadVenta=?,factor=?,\r\n" + 
					"    nom_cat=?,codRegistroSanitario=?,codigo_sunat=?,lote=?,stock_pro=? where id_prod=?;";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			
			
			pst.setInt(1, reg.getCodbarra());
			pst.setString(2, reg.getDescripcion());
			pst.setString(3,reg.getMarca());
			pst.setDouble(4, reg.getPrecioProCom());
			pst.setDouble(5, reg.getPrecioProVen());
			pst.setString(6,reg.getUnidadCompra());
			pst.setString(7, reg.getUnidadVenta());
			pst.setInt(8, reg.getFactor());
			pst.setString(9,reg.getNomCat());
			pst.setString(10,reg.getCodregistrosani());
			pst.setInt(11,reg.getCodSunat());
			pst.setBoolean(12, reg.getLote());
			pst.setInt(13, reg.getStock());
			pst.setInt(14, reg.getCodigo());
			
			rs=pst.executeUpdate();
			
			
			
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
		return rs;
	}

	@Override
	public int eliminar(int codigo) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" delete from producto where id_prod =?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1,codigo);
		
			rs=pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Producto en uso");
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return rs;
	}


	
}
