package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class IntIngreso extends JInternalFrame {
	private JTable table;
	private JTextField textField;
	private JTree tree;
	private JLabel lblEstablecimiento;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntIngreso frame = new IntIngreso();
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
	public IntIngreso() {
		setBounds(223, 122, 1626, 789);
		getContentPane().setLayout(null);
		/*---------------------------------- > QUITAR BORDES DEL JINTERNALFRAME <--------------------*/
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*---------------------------------------------------------------------------------------*/
		
		
		table = new JTable();
		table.setBounds(224, 75, 1365, 673);
		getContentPane().add(table);
		
		textField = new JTextField();
		textField.setBounds(962, 26, 307, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(1441, 27, 89, 23);
		getContentPane().add(btnNuevo);
		
		tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Ingreso a Almacen") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("2016");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("2017");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("2018");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
				}
			}
		));
		tree.setBounds(10, 11, 204, 737);
		getContentPane().add(tree);
		
		lblEstablecimiento = new JLabel("Establecimiento");
		lblEstablecimiento.setBounds(257, 31, 89, 14);
		getContentPane().add(lblEstablecimiento);
		
		comboBox = new JComboBox();
		comboBox.setBounds(356, 28, 115, 20);
		getContentPane().add(comboBox);

	}
}
