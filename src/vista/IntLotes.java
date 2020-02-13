package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class IntLotes extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntLotes frame = new IntLotes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntLotes() {
		setBounds(223, 122, 1626, 789);
		
		/*---------------------------------- > QUITAR BORDES DEL JINTERNALFRAME <--------------------*/
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*---------------------------------------------------------------------------------------*/
		
		getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Disponible");
		rdbtnNewRadioButton.setBounds(426, 45, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFinalizado = new JRadioButton("Finalizado");
		rdbtnFinalizado.setBounds(570, 45, 109, 23);
		getContentPane().add(rdbtnFinalizado);
		
		textField = new JTextField();
		textField.setBounds(809, 46, 322, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEstablecimiento = new JLabel("Establecimiento");
		lblEstablecimiento.setBounds(77, 49, 109, 14);
		getContentPane().add(lblEstablecimiento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(196, 46, 134, 20);
		getContentPane().add(comboBox);
		
		JButton btnNuevi = new JButton("Nuevo");
	
		btnNuevi.setBounds(1212, 45, 89, 23);
		getContentPane().add(btnNuevi);
		
		table = new JTable();
		table.setBounds(10, 125, 1590, 623);
		getContentPane().add(table);

	}
}
