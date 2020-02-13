package mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Interfaces.InterfaceFinanzas;
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
				reg.setTipDoc(rs.getString(1));
				reg.setNumVen(rs.getString(2));
				reg.setFechVenc(rs.getString(3));
				reg.setDiasMora(rs.getString(4));
				reg.setTotalVen(rs.getString(5));
				reg.setTelf_cli(rs.getString(6));
				reg.setCell_cli(rs.getString(7));
				reg.setCorreo_cli(rs.getString(8));
				
			
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
