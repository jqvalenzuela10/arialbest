package mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Interfaces.InterfaceCaja;
import model.Caja;

import utils.MySQLconexion;

public class GestionCaja implements InterfaceCaja{

	@Override
	public ArrayList<Caja> listado() {
		ArrayList<Caja> lista=new ArrayList<Caja>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select*from caja;";
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Caja c=new Caja();
				
				c.setCodCaja(rs.getInt(1));
				c.setNomCaja(rs.getString(2));
				c.setSaldo(rs.getDouble(3));
				lista.add(c);
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
	public int agregar(Caja c) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" insert into caja values(null,?,?)";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,c.getNomCaja());
			
		
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

	@Override
	public int actualizar(Caja c) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" update caja set saldo=? where cod_caja=?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			
			pst.setDouble(1, c.getSaldo());
			pst.setInt(2, c.getCodCaja());
		
			
			rs=pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cliente en uso");
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
