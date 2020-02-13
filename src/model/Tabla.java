package model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.chart.axis.StandardTickUnitSource;
import org.jfree.layout.CenterLayout;
import org.omg.CORBA.PUBLIC_MEMBER;

import mantenimientos.GestionEmpledos;

public class Tabla {
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
		model.addColumn("Apellido Paterno");
		model.addColumn("Apellido Materno");
		model.addColumn("Sexo");
		model.addColumn("Email");
		model.addColumn("Sueldo");
		model.addColumn("Estado");
		model.addColumn("Direccion");
		model.addColumn("Telefono");
		model.addColumn("Celular");
		model.addColumn("Dni");
		model.addColumn("Nick");
		model.addColumn("Contraseña");
		model.addColumn("Cargo");
		model.addColumn("Modificar");
		model.addColumn("Eliminar");
		model.addColumn("fecha");

        tabla.setModel(model);
		setBox(tabla, tabla.getColumnModel().getColumn(17));
		
		
        tabla.setRowHeight(30);
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
        listar();

    }
	
public void setBox(JTable tabla ,TableColumn column) {
	column.setCellEditor(new JDateChooserEditor(new JCheckBox()));
	DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
	column.setCellRenderer(renderer);
;
	

	
}

public static void listar() {
   
	
	GestionEmpledos gc = new GestionEmpledos();
	ArrayList<Empleados> lista = gc.listado();
	
	for (Empleados cl : lista) {
		Object datos[] = { cl.getId_emp(), cl.getNom_emp(),cl.getApe_pat_emp(),  cl.getApe_mat_emp(),
				cl.getSex_emp(),cl.getEmail_emp(),cl.getSueldo_emp(),cl.getEstado_emp(),cl.getDirec_emp(),cl.getTelf_emp()
				,cl.getCell_emp(),cl.getDni_emp(),cl.getLogin_emp(),cl.getPsw_emp(),null,btn1,btn2 };

		model.addRow(datos);

	}
}
	public static void listarNombre(ArrayList<Empleados> listado) {
		   
	
		
		for (Empleados cl : listado) {
			Object datos[] = { cl.getId_emp(), cl.getNom_emp(),cl.getApe_pat_emp(),  cl.getApe_mat_emp(),
					cl.getSex_emp(),cl.getEmail_emp(),cl.getSueldo_emp(),cl.getEstado_emp(),cl.getDirec_emp(),cl.getTelf_emp()
					,cl.getCell_emp(),cl.getDni_emp(),cl.getLogin_emp(),cl.getPsw_emp(),null,btn1,btn2 };

			model.addRow(datos);
		}
	
}
	

}

