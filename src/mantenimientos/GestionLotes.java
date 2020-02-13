package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;



import Interfaces.InterfaceLotes;
import model.Lotes;
import utils.MySQLconexion;

public class GestionLotes implements InterfaceLotes {

	@Override
	public int registrar(ArrayList<Lotes> lista) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="insert into lote values(?,?,?,?,?,venceDias(fecha_produccion,fecha_caducidad),curdate(),?);";
			
			
			for (Lotes l : lista) {
				pst = con.prepareStatement(sql);
				pst.setInt(1, l.getCod_lote());
				pst.setString(2, l.getFecha_produccion());
				pst.setString(3, l.getFecha_caducidad());
				pst.setInt(4, l.getExistenciaInicial());
				pst.setInt(5, l.getExistenciaActual());
				pst.setInt(6, l.getIdPro());
				rs=pst.executeUpdate();
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
		return rs;
	}

}
