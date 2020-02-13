package Interfaces ;

import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import model.Empleados;
import model.PerfilUsuario;
import model.Privilegios;
import model.TipoEmpleado;

public interface InterfaceEmpleados {
	public Empleados ValidaAcceso(String TIPO,String USU,String PSW);
	public Empleados ValidaAcceso2(String USU,String PSW);
	
	ArrayList<TipoEmpleado> tipo();
	
	public ArrayList<Empleados>listado(); 
	public ArrayList<Empleados>listado(String nombre);
	public ArrayList<Empleados>privilegios(String id);

	
	public int cambiarContraseña(int id,String psw);
	
	public int registrar(Empleados reg,ArrayList<Privilegios>priv);
	public int actualizarEmpleado(Empleados c);
	
	public int actualizarEmp_Priv(Empleados c,ArrayList<Privilegios>priv);
	public int actualizarPerfilEmp(Empleados c);
	public int eliminar(String id);
	
	public ArrayList<PerfilUsuario>listadoPerfilUsu(); 
	public int actualizarPerfil(PerfilUsuario c);
	public int eliminarPerfil(String id);
	public int registrarPerfil(PerfilUsuario reg);
}
