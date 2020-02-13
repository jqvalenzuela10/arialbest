 package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author David
 */
public class CustomUI extends BasicComboBoxUI{
    
    
    Color c = new Color(255,255,255);
    
    public static ComboBoxUI createUI1(FrmRegistroCompra frmRegistroCompra){
        return new CustomUI();
    }
    public static ComboBoxUI createUI(JComponent com){
        return new CustomUI();
    }

    @Override
    protected JButton createArrowButton() {
        JButton btn = new JButton();
        btn.setIcon(new ImageIcon(getClass().getResource("/iconos/arrowbot.png")));
        btn.setBorder(BorderFactory.createLineBorder(c,4));
        btn.setContentAreaFilled(false);
        return btn;
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(c);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    
    
    @Override
    protected ListCellRenderer createRenderer() {
        
        return new DefaultListCellRenderer(){

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
                
                
                list.setSelectionBackground(new Color(0,0,0));
                
                if(index!=-1){
                  
                }
                
                
                return this;
            }

        };
    }
    
    
    

}