package model;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.chart.axis.CategoryTick;
import org.jfree.chart.axis.StandardTickUnitSource;
import org.jfree.layout.CenterLayout;
import org.omg.CORBA.PUBLIC_MEMBER;

import mantenimientos.GestionEmpledos;

public class Tabla_Reutilizable {

	static JButton btn1;
	static JButton btn2;
	static JButton btnVer;
	static JButton btnVer2;
	static JCheckBox checkBox;
	
	public static DefaultTableModel model;
	public static DefaultTableModel model2;
public void ver_tabla(JTable tabla,ArrayList<DefaultTableModel>models,int longitud ){
	model=new DefaultTableModel();
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
    	Image ia = delete.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
    	Icon ic = new ImageIcon(ia);
    	btn2.setIcon(ic);
        btn2.setName("e");
        
        

  	  btnVer = new JButton();
      btnVer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      ImageIcon ver = new ImageIcon(getClass().getResource("/img/ver.png"));
  	Image r = ver.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
  	Icon icon = new ImageIcon(r);
  	btnVer.setIcon(icon);
  	btnVer.setName("v");


    
    
             model.isCellEditable(0,0);
          
        for(int i=0;i<longitud;i++) {
        	model.addColumn(models.get(0).getColumnName(i));
        
        	System.out.println(models.get(0).getColumnName(i));
        }

        tabla.setModel(model);
      
		
		
        tabla.setRowHeight(30);
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());

       

    }
public void ver_otraTabla(JTable tabla,ArrayList<DefaultTableModel>models,int longitud ){

	 
	 model2=new DefaultTableModel();
	 model2.setColumnCount(0);
	 model2.setRowCount(0);
        tabla.setDefaultRenderer(Object.class, new Render());
       
         btn1 = new JButton("");
        ImageIcon edit = new ImageIcon(getClass().getResource("/img/editar.png"));
    	Image im = edit.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
    	Icon ico = new ImageIcon(im);
    	btn1.setIcon(ico);
        btn1.setName("m");
        
        
         btn2 = new JButton();
        ImageIcon delete = new ImageIcon(getClass().getResource("/img/eliminar.png"));
    	Image ia = delete.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
    	Icon ic = new ImageIcon(ia);
    	btn2.setIcon(ic);
        btn2.setName("e");
        
        

        btnVer = new JButton();
        btnVer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ImageIcon ver = new ImageIcon(getClass().getResource("/img/ver.png"));
    	Image r = ver.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
    	Icon icon = new ImageIcon(r);
    	btnVer.setIcon(icon);
    	btnVer.setName("v");
        
    
    
    
            
             model2.isCellEditable(0,0);
        for(int i=0;i<longitud;i++) {
        	
        	model2.addColumn(models.get(0).getColumnName(i));
        	System.out.println(models.get(0).getColumnName(i));
        }

      
        
        tabla.setModel(model2);
      
        tabla.setRowHeight(30);
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
       

    }

public static  void listar(ArrayList<Producto> lista) {
   
	
	
	
	for (Producto cl : lista) {
		Object datos[] = {cl.getCodbarra(),cl.getDescripcion(),cl.getStock(),cl.getPrecioProCom() ,cl.getPrecioProVen(),cl.getCodregistrosani(),btn1,btn2 };

		model.addRow(datos);

	}
}

	

public static  void listarCaja(ArrayList<Caja> listado) {
   
	
	
	
	for (Caja cl : listado) {
		Object datos[] = {cl.getCodCaja(),cl.getNomCaja(),btn1,btn2 };

		model.addRow(datos);

	}
}

public static  void listarCorteCaja(ArrayList<CorteCajaListadito> list) {
   
	
	
	
	for (CorteCajaListadito cl : list) {
		Object datos[] = {cl.getCodCaja(),cl.getFecha(),cl.getNomCaja(),cl.getContado(),cl.getCalculado(),cl.getDiferencia(),cl.getRetirado(),cl.getDesUsu(),cl.getNomUsu() };

		model.addRow(datos);

	}
}





public static  void listarCobranza(ArrayList<Cobranza> listado) {
   
	
	
	
	for (Cobranza cl : listado) {
		Object datos[] = {cl.getNomCli(),cl.getTipDoc(),cl.getNumDoc(),cl.getTipPag(),cl.getNumVen(),cl.getFormaPag(),cl.getFechEmi(),cl.getFechVenc(),cl.getNomVendedor(),"S/.",cl.getTotalVen()
				,"","",cl.getVenceDias(),cl.getDiasMora(),btnVer};

		model.addRow(datos);

	}
}

public static  void listarCobranzaHoy(ArrayList<Cobranza> listado) {
   
	
	
	
	for (Cobranza cl : listado) {
		Object datos[] = {cl.getNomCli(),"S./",cl.getTotalVen(),btnVer};

		model2.addRow(datos);

	}
}


public static  void listarCobranzaCliente(ArrayList<Cobranza> listado) {
   
	
	
	
	for (Cobranza cl : listado) {
		Object datos[] = {cl.getTipDoc(),cl.getNumVen(),cl.getFechVenc(),cl.getDiasMora(),"S./",cl.getTotalVen(),true};

		model2.addRow(datos);

	}
}


public void setBox(JTable tabla ,TableColumn column) {
	column.setCellEditor(new JDateChooserEditor(new JCheckBox()));
	DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
	column.setCellRenderer(renderer);

	

	
}

}

