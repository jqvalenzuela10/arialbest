package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Interfaces.InterfaceMovimiento;

import model.Movimiento;
import utils.MySQLconexion;

public class GestionMovimiento implements InterfaceMovimiento{

	@Override
	public int insertar(Movimiento m) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst1=null;
	
		try {
			con=MySQLconexion.getConexion();
			String sql1="insert into movimiento values(null,curdate(),?,?,?,?,?,?,?,?,default);";
			pst1=con.prepareStatement(sql1);
			if(m.getNro_ven()==0) {
				pst1.setString(3,null);
				}
				else {
					pst1.setInt(3, m.getNro_ven());
				
				}
			
			if(m.getCod_regis_com()==0) {
				pst1.setString(4,null);
				}
				else {
					pst1.setInt(4, m.getCod_regis_com());
				}
			pst1.setString(1,m.getComentario());
			pst1.setString(2, m.getTipo_movimiento());
			
			
			pst1.setDouble(5,m.getEntrada());
			pst1.setDouble(6,m.getSalida());
			pst1.setDouble(7,m.getSaldo());
			pst1.setInt(8, m.getCodcaja());
			
			
			rs=pst1.executeUpdate();
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia"+e.getMessage());
		}finally {
			try {
				if(pst1!=null)pst1.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
			
		}
		return rs;
	}

	
}
