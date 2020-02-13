package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.InterfaceEmpleados;
import model.Clientes;
import model.DetalleVentas;
import model.Empleados;
import model.PerfilUsuario;
import model.Privilegios;
import model.TipoEmpleado;
import utils.MySQLconexion;

public class GestionEmpledos implements InterfaceEmpleados {

	// este ya no funcina porsekacaso funciona el (ValidaAcceso2)
	public Empleados ValidaAcceso(String TIPO, String USU, String PSW) {
		Empleados e = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = "{call sp_login (?,?,?)}"; // sentencia sql

			pst = con.prepareStatement(sql);
			pst.setString(1, TIPO);
			pst.setString(2, USU);
			pst.setString(3, PSW);
			// parámetros según la sentencia

			rs = pst.executeQuery(); // tipo de ejecución

			// Acciones adicionales en caso de consultas
			while (rs.next()) {
				e = new Empleados();
				e.setLogin_emp(rs.getString(4));
				e.setPsw_emp(rs.getString(5));
				e.setNom_emp(rs.getString(2));
				e.setApe_pat_emp(rs.getString(3));

			}
		} catch (Exception ex) {
			System.out.println("Error en la sentencia " + ex.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException exc) {
				System.out.println("Error al cerrar ");
			}
		}

		return e;
	}

	// LLENAR COMBOBOX TIPO EMPLEADO
	public ArrayList<TipoEmpleado> tipo() {
		ArrayList<TipoEmpleado> lista = new ArrayList<TipoEmpleado>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLconexion.getConexion();
			String sql = "select*from tipo_empleado";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TipoEmpleado te = new TipoEmpleado();
				te.setId_tip_emp(rs.getString(1));
				te.setDesc_emp(rs.getString(2));
				lista.add(te);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar");
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Empleados> listado() {
		// TODO Auto-generated method stub
		ArrayList<Empleados> lista = new ArrayList<Empleados>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = " select *from usuario";
			pst = (PreparedStatement) con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Empleados e = new Empleados();

				e.setId_emp(rs.getInt(1));
				e.setNom_emp(rs.getString(2));
				e.setApe_pat_emp(rs.getString(3));
				e.setApe_mat_emp(rs.getString(4));
				e.setSex_emp(rs.getString(5));
				e.setEmail_emp(rs.getString(6));
				e.setSueldo_emp(rs.getDouble(7));
				e.setEstado_emp(rs.getString(8));
				e.setDirec_emp(rs.getString(9));
				e.setTelf_emp(rs.getString(10));
				e.setCell_emp(rs.getString(11));
				e.setDni_emp(rs.getString(12));
				e.setLogin_emp(rs.getString(13));
				e.setPsw_emp(rs.getString(14));
				lista.add(e);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;

	}

	@Override
	public ArrayList<Empleados> listado(String nombre) {
		ArrayList<Empleados> lista = new ArrayList<Empleados>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = "select *from usuario where nom_usu like concat(?,'%')";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, nombre);
			rs = pst.executeQuery();

			while (rs.next()) {
				Empleados e = new Empleados();

				e.setId_emp(rs.getInt(1));
				e.setNom_emp(rs.getString(2));
				e.setApe_pat_emp(rs.getString(3));
				e.setApe_mat_emp(rs.getString(4));
				e.setSex_emp(rs.getString(5));
				e.setEmail_emp(rs.getString(6));
				e.setSueldo_emp(rs.getDouble(7));
				e.setEstado_emp(rs.getString(8));
				e.setDirec_emp(rs.getString(9));
				e.setTelf_emp(rs.getString(10));
				e.setCell_emp(rs.getString(11));
				e.setDni_emp(rs.getString(12));
				e.setLogin_emp(rs.getString(13));
				e.setPsw_emp(rs.getString(14));
				lista.add(e);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;
	}

	@Override
	public int registrar(Empleados reg, ArrayList<Privilegios> priv) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			con.setAutoCommit(false);
			String sql = " insert into usuario values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, reg.getNom_emp());
			pst.setString(2, reg.getApe_pat_emp());
			pst.setString(3, reg.getApe_mat_emp());
			pst.setString(4, reg.getSex_emp());
			pst.setString(5, reg.getEmail_emp());
			pst.setDouble(6, reg.getSueldo_emp());
			pst.setString(7, reg.getEstado_emp());

			pst.setString(8, reg.getDirec_emp());
			pst.setString(9, reg.getTelf_emp());
			pst.setString(10, reg.getCell_emp());
			pst.setString(11, reg.getDni_emp());
			pst.setString(12, reg.getLogin_emp());
			pst.setString(13, reg.getPsw_emp());
			pst.setString(14, reg.getId_tip_emp());

			rs = pst.executeUpdate();

			con.commit();
			String sql3 = "insert into  privilegios values(?,?,?)";
			
			for (Privilegios dt : priv) {
				pst = con.prepareStatement(sql3);
				pst.setInt(1, reg.getId_emp());
				pst.setString(2, dt.getNom_privilegio());
				pst.setBoolean(3, dt.isEstado_privilegio());
				rs = pst.executeUpdate();
			}
			con.commit();
		} catch (Exception ex) {
			try {
				con.rollback();
				System.out.println("Ocurrio un evento inesperado en el metodo insertar boleta : " + ex.getMessage());
				rs = 0;
			} catch (SQLException e) {
				System.out.println("Error en el Rollback " + e.getMessage());
			}
		} finally {
			try {
				if (pst != null)
					pst.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar :" + e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public int actualizarEmpleado(Empleados c) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			
			String sql = " update usuario  set nom_usu=? ,ape_pat_usu=? ,ape_mat_usu=?,email_usu=?,sueldo_usu=?,direc_usu=?,telf_usu=? ,cell_usu=?,dni_usu=?,login_usu=?,psw_usu=?  where id_usu=?";

			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, c.getNom_emp());
			pst.setString(2, c.getApe_pat_emp());
			pst.setString(3, c.getApe_mat_emp());
			// pst.setString(4,c.getSex_emp());
			pst.setString(4, c.getEmail_emp());
			pst.setDouble(5, c.getSueldo_emp());
			// pst.setString(7,c.getEstado_emp());
			pst.setString(6, c.getDirec_emp());
			pst.setString(7, c.getTelf_emp());
			pst.setString(8, c.getCell_emp());
			pst.setString(9, c.getDni_emp());
			pst.setString(10, c.getLogin_emp());
			pst.setString(11, c.getPsw_emp());
			pst.setInt(12, c.getId_emp());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cliente en uso");
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public int eliminar(String id) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null,pst2 = null;
		try {
			con = MySQLconexion.getConexion();
			con.setAutoCommit(false);
			String sql = " delete from privilegios where id_usu=?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, id);
				rs = pst.executeUpdate();
			

			

	
			
				String sql3 = "delete from usuario where id_usu=?";
				pst2 = (PreparedStatement) con.prepareStatement(sql3);
				pst2.setString(1, id);
				rs = pst2.executeUpdate();
			
			

			con.commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (pst2 != null)
					pst2.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public Empleados ValidaAcceso2(String USU, String PSW) {
		Empleados e = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = "select * from usuario where login_usu=? and psw_usu=?"; // sentencia sql

			pst = con.prepareStatement(sql);

			pst.setString(1, USU);
			pst.setString(2, PSW);
			// parámetros según la sentencia

			rs = pst.executeQuery(); // tipo de ejecución

			// Acciones adicionales en caso de consultas
			while (rs.next()) {
				e = new Empleados();
				e.setId_emp(rs.getInt(1));
				e.setNom_emp(rs.getString(2));
				e.setApe_pat_emp(rs.getString(3));
				e.setApe_mat_emp(rs.getString(4));
				e.setSex_emp(rs.getString(5));
				e.setEmail_emp(rs.getString(6));
				e.setSueldo_emp(rs.getDouble(7));
				e.setEstado_emp(rs.getString(8));
				e.setDirec_emp(rs.getString(9));
				e.setTelf_emp(rs.getString(10));
				e.setCell_emp(rs.getString(11));
				e.setDni_emp(rs.getString(12));
				e.setLogin_emp(rs.getString(13));
				e.setPsw_emp(rs.getString(14));
				e.setId_tip_emp(rs.getString(15));

			}
		} catch (Exception ex) {
			System.out.println("Error en la sentencia " + ex.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException exc) {
				System.out.println("Error al cerrar ");
			}
		}

		return e;
	}

	@Override
	public int cambiarContraseña(int id, String psw) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = " update usuario  set Psw_usu=? where id_usu=?";

			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, psw);
			pst.setInt(2, id);

			rs = pst.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cliente en uso");
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public ArrayList<Empleados> privilegios(String id) {
		ArrayList<Empleados> lista = new ArrayList<Empleados>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = "select *from privilegios where id_usu=?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				Empleados e = new Empleados();

				e.setNom_privilegio(rs.getString(2));
				e.setEstadoPrivilegio(rs.getBoolean(3));

				lista.add(e);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;
	}

	@Override
	public int actualizarEmp_Priv(Empleados c, ArrayList<Privilegios> priv) {

		Connection con = null;
		PreparedStatement pst = null;

		int rs = 0;
		try {

			con = MySQLconexion.getConexion();
			con.setAutoCommit(false);
			// insert ventas values(null,'Factura','2018/11/10',1,1);
			String sql = " update usuario  set nom_usu=? ,ape_pat_usu=? ,ape_mat_usu=?,email_usu=?,sueldo_usu=?,direc_usu=?,telf_usu=? ,cell_usu=?,dni_usu=?,login_usu=?,psw_usu=?  where id_usu=?";

			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, c.getNom_emp());
			pst.setString(2, c.getApe_pat_emp());
			pst.setString(3, c.getApe_mat_emp());
			// pst.setString(4,c.getSex_emp());
			pst.setString(4, c.getEmail_emp());
			pst.setDouble(5, c.getSueldo_emp());
			// pst.setString(7,c.getEstado_emp());
			pst.setString(6, c.getDirec_emp());
			pst.setString(7, c.getTelf_emp());
			pst.setString(8, c.getCell_emp());
			pst.setString(9, c.getDni_emp());
			pst.setString(10, c.getLogin_emp());
			pst.setString(11, c.getPsw_emp());
			pst.setInt(12, c.getId_emp());

			rs += pst.executeUpdate();

			String sql3 = "update privilegios set estado=? where id_usu=? and desc_priv=?";
			for (Privilegios dt : priv) {
				pst = con.prepareStatement(sql3);
				pst.setBoolean(1, dt.isEstado_privilegio());
				pst.setInt(2, c.getId_emp());
				pst.setString(3, dt.getNom_privilegio());
				rs += pst.executeUpdate();
			}

			con.commit();
		} catch (Exception ex) {
			try {
				con.rollback();
				System.out.println("Ocurrio un evento inesperado en el metodo insertar boleta : " + ex.getMessage());
				rs = 0;
			} catch (SQLException e) {
				System.out.println("Error en el Rollback " + e.getMessage());
			}
		} finally {
			try {
				if (pst != null)
					pst.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar :" + e.getMessage());
			}
		}
		return rs;

	}

	@Override
	public int actualizarPerfilEmp(Empleados c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = " update usuario  set nom_usu=? ,ape_pat_usu=? ,ape_mat_usu=?,direc_usu=?,telf_usu=? ,cell_usu=?,login_usu=? where id_usu=?";

			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, c.getNom_emp());
			pst.setString(2, c.getApe_pat_emp());
			pst.setString(3, c.getApe_mat_emp());
			pst.setString(4, c.getDirec_emp());
			pst.setString(5, c.getTelf_emp());
			pst.setString(6, c.getCell_emp());
			pst.setString(7, c.getLogin_emp());
			pst.setInt(8, c.getId_emp());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cliente en uso");
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public ArrayList<PerfilUsuario> listadoPerfilUsu() {
		ArrayList<PerfilUsuario> lista = new ArrayList<PerfilUsuario>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = " select *from tipo_usuario";
			pst = (PreparedStatement) con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				PerfilUsuario e = new PerfilUsuario();

				e.setIdPerfil(rs.getInt(1));
				e.setDescPerfil(rs.getString(2));
			
				lista.add(e);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;

	}

	@Override
	public int actualizarPerfil(PerfilUsuario c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			
			String sql = " update usuario  set desc_usu=?  where id_tip_usu=?";

			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, c.getDescPerfil());
			pst.setInt(2, c.getIdPerfil());
		

			rs = pst.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cliente en uso");
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public int eliminarPerfil(String id) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			
			String sql = " delete from tipo_usuario where id_tip_usu=?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, id);
				rs = pst.executeUpdate();

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public int registrarPerfil(PerfilUsuario reg) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
		
			String sql = " insert into tipo_usuario values(null,?)";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, reg.getDescPerfil());
		

			rs = pst.executeUpdate();

		
			
		} catch (Exception ex) {
			
		} finally {
			try {
				if (pst != null)
					pst.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar :" + e.getMessage());
			}
		}
		return rs;
	}

}
