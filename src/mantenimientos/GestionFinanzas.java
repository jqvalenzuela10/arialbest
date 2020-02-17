package mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Interfaces.InterfaceFinanzas;
import model.Abono;
import model.Cobranza;
import model.Producto;
import utils.MySQLconexion;

public class GestionFinanzas implements InterfaceFinanzas {

	@Override
	public ArrayList<Cobranza> listado() {
		ArrayList<Cobranza> lista=new ArrayList<Cobranza>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call consulta_cobranza()}";
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Cobranza reg=new Cobranza();
				
				reg.setNomCli(rs.getString(1));
				reg.setTelf_cli(rs.getString(2));
				reg.setCell_cli(rs.getString(3));
				reg.setTotalVen(rs.getString(4));
			
				
				
				
			
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
	public ArrayList<Cobranza> listadoxFecha(String año, String mes) {

		ArrayList<Cobranza> lista=new ArrayList<Cobranza>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call consulta_cobranzaxFecha(?,?)}";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, año);
			int mes2=Integer.parseInt(mes)+1;
			pst.setString(2, mes2+"");
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Cobranza reg=new Cobranza();
				reg.setNomCli(rs.getString(1));
				reg.setTipDoc(rs.getString(2));
				reg.setNumDoc(rs.getString(3));
				reg.setTipPag(rs.getString(4));
				reg.setNumVen(rs.getString(5));
				reg.setFormaPag(rs.getString(6));
				reg.setFechEmi(rs.getString(7));
				reg.setFechVenc(rs.getString(8));
				reg.setNomVendedor(rs.getString(9));
				reg.setTotalVen(rs.getString(10));
				reg.setVenceDias(rs.getString(11));
				reg.setDiasMora(rs.getString(12));
				
				
				
			
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
	public ArrayList<Cobranza> listadoCobranzaHoy() {
		ArrayList<Cobranza> lista=new ArrayList<Cobranza>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call consultaCobranzaHoy()}";
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Cobranza reg=new Cobranza();
				reg.setNomCli(rs.getString(1));
				reg.setTotalVen(rs.getString(2));
			
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
	public ArrayList<Cobranza> listadoxCliente(String nombre) {
		ArrayList<Cobranza> lista=new ArrayList<Cobranza>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call consultaCobranzaCliente(?)}";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, nombre);
			
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Cobranza reg=new Cobranza();
				reg.setIdVenta(rs.getString(1));
				reg.setTipDoc(rs.getString(2));
				reg.setNumVen(rs.getString(3));
				reg.setFechVenc(rs.getString(4));
				reg.setDiasMora(rs.getString(5));
				reg.setTotalVen(rs.getString(6));
				reg.setAbono(rs.getString(7));
				reg.setSaldo(rs.getString(8));
				reg.setTelf_cli(rs.getString(9));
				reg.setCell_cli(rs.getString(10));
				reg.setCorreo_cli(rs.getString(11));
				
			
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
	public ArrayList<Abono> listadoAbonos(String idVenta) {
		ArrayList<Abono> lista=new ArrayList<Abono>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call consultaAbono(?)}";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, idVenta);
			
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Abono reg=new Abono();
				reg.setFecha_abono(rs.getString(1));
				reg.setForma_pago(rs.getString(2));
				reg.setObserv_abono(rs.getString(3));
				reg.setMonto_abono(rs.getString(4));
				
				
			
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

	@SuppressWarnings("resource")
	@Override
	public int registrarAbono(Abono a) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			
			String sql=" insert into abono_venta values(null,sysdate(),?,?,?,?);";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, a.getForma_pago());
			pst.setString(2, a.getMonto_abono());
			pst.setString(3, a.getObserv_abono());
			pst.setString(4, a.getId_venta());
		
	
			
		
			
			rs=pst.executeUpdate();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia registrar cliente"+e.getMessage());
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar la conexion");
			}
		}
		return rs;
		
	}

}
