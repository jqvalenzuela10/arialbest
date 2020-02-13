package model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionEmpledos;

public class TablaPerfiles {
	public static DefaultTableModel model=new DefaultTableModel();
	static JButton btn1;
	static JButton btn2;

public void ver_tabla(JTable tabla){
	 model.setColumnCount(0);
	 model.setRowCount(0);
        tabla.setDefaultRenderer(Object.class, new Render());
        

        
  
         btn1 = new JButton("");
        ImageIcon edit = new ImageIcon(getClass().getResource("/img/editar.png"));
    	Image im = edit.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
    	Icon ico = new ImageIcon(im);
    	btn1.setIcon(ico);
        btn1.setName("m");
        
        
         btn2 = new JButton();
        ImageIcon delete = new ImageIcon(getClass().getResource("/img/eliminar.png"));
    	Image i = delete.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
    	Icon ic = new ImageIcon(i);
    	btn2.setIcon(ic);
        btn2.setName("e");
        
        
    
    
             model.isCellEditable(0,0);
       
        model.addColumn("ID");
        model.addColumn("Nombre");
	
		model.addColumn("Modificar");
		model.addColumn("Eliminar");
		model.addColumn("caducidad");
		listar();
        
        tabla.setModel(model);
        tabla.setRowHeight(30);
       
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
  

    }
	
public static void listar() {
   
	
	GestionEmpledos gc = new GestionEmpledos();
	ArrayList<PerfilUsuario> lista = gc.listadoPerfilUsu();
	
	for (PerfilUsuario cl : lista) {
		Object datos[] = { cl.getIdPerfil(), cl.getDescPerfil(),btn1,btn2 };

		model.addRow(datos);

	}
}
	

}
