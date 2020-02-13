package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import mantenimientos.GestionClientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.Clientes;
import model.HintTextField;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;

public class RegistroCliente extends JDialog {
	private HintTextField txtNombreCliente;
	private HintTextField txtNombreComercial;
	private HintTextField txtDireccion;
	private HintTextField txtTelefono;
	private HintTextField txtCelular;
	private HintTextField txtCorreo;
	private HintTextField txtDepartamento;
	private HintTextField txtDistrito;
	private HintTextField txtFormaPago;
	private HintTextField txtTipoDocumento;
	private HintTextField txtNumeroDocumento;
	private JSpinner spLimiteCredito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroCliente dialog = new RegistroCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroCliente() {
		setBounds(100, 100, 908, 728);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
			panel.setBackground(new Color(45, 54, 63));
			panel.setBounds(0, 0, 898, 90);
			getContentPane().add(panel);
			{
				JLabel lblNuevoCliente = new JLabel("Nuevo Cliente");
				lblNuevoCliente.setForeground(Color.WHITE);
				lblNuevoCliente.setFont(new Font("Segoe UI", Font.BOLD, 18));
				lblNuevoCliente.setBounds(128, 26, 176, 53);
				panel.add(lblNuevoCliente);
			}
			{
				JLabel lblImagen = new JLabel("imagen");
				lblImagen.setForeground(Color.WHITE);
				lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
				lblImagen.setBounds(52, 26, 66, 50);
				panel.add(lblImagen);
			}
		}
		{
			JLabel lblDatosCliente = new JLabel("Datos Cliente");
			lblDatosCliente.setForeground(Color.BLACK);
			lblDatosCliente.setFont(new Font("Segoe UI", Font.BOLD, 15));
			lblDatosCliente.setBounds(41, 138, 143, 14);
			getContentPane().add(lblDatosCliente);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(41, 191, 193, 40);
			getContentPane().add(panel);
			{
				txtNombreCliente = new HintTextField("Nombre Cliente");
				txtNombreCliente.setColumns(10);
				txtNombreCliente.setBorder(null);
				txtNombreCliente.setBackground(new Color(247, 249, 249));
				txtNombreCliente.setBounds(59, 4, 124, 32);
				panel.add(txtNombreCliente);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(41, 273, 193, 40);
			getContentPane().add(panel);
			{
				txtNombreComercial = new HintTextField("Nombre Comercial");
				txtNombreComercial.setColumns(10);
				txtNombreComercial.setBorder(null);
				txtNombreComercial.setBackground(new Color(247, 249, 249));
				txtNombreComercial.setBounds(59, 4, 124, 32);
				panel.add(txtNombreComercial);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(41, 370, 193, 40);
			getContentPane().add(panel);
			{
				txtDireccion = new HintTextField("Direccion");
				txtDireccion.setColumns(10);
				txtDireccion.setBorder(null);
				txtDireccion.setBackground(new Color(247, 249, 249));
				txtDireccion.setBounds(59, 4, 124, 32);
				panel.add(txtDireccion);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(41, 462, 193, 40);
			getContentPane().add(panel);
			{
				txtTelefono = new HintTextField("Telefono");
				txtTelefono.setColumns(10);
				txtTelefono.setBorder(null);
				txtTelefono.setBackground(new Color(247, 249, 249));
				txtTelefono.setBounds(59, 4, 124, 32);
				panel.add(txtTelefono);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(41, 547, 193, 40);
			getContentPane().add(panel);
			{
				txtCelular = new HintTextField("Celular");
				txtCelular.setColumns(10);
				txtCelular.setBorder(null);
				txtCelular.setBackground(new Color(247, 249, 249));
				txtCelular.setBounds(59, 4, 124, 32);
				panel.add(txtCelular);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(41, 638, 193, 40);
			getContentPane().add(panel);
			{
				txtCorreo = new HintTextField("Correo");
				txtCorreo.setColumns(10);
				txtCorreo.setBorder(null);
				txtCorreo.setBackground(new Color(247, 249, 249));
				txtCorreo.setBounds(59, 4, 124, 32);
				panel.add(txtCorreo);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JLabel lblOtrosDatos = new JLabel("Otros Datos");
			lblOtrosDatos.setForeground(Color.BLACK);
			lblOtrosDatos.setFont(new Font("Segoe UI", Font.BOLD, 15));
			lblOtrosDatos.setBounds(475, 138, 143, 14);
			getContentPane().add(lblOtrosDatos);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(408, 138, 2, 536);
			getContentPane().add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(475, 191, 193, 40);
			getContentPane().add(panel);
			{
				txtDepartamento = new HintTextField("Departamento");
				txtDepartamento.setColumns(10);
				txtDepartamento.setBorder(null);
				txtDepartamento.setBackground(new Color(247, 249, 249));
				txtDepartamento.setBounds(59, 4, 124, 32);
				panel.add(txtDepartamento);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(678, 191, 193, 40);
			getContentPane().add(panel);
			{
				txtDistrito = new HintTextField("Distrito");
				txtDistrito.setColumns(10);
				txtDistrito.setBorder(null);
				txtDistrito.setBackground(new Color(247, 249, 249));
				txtDistrito.setBounds(59, 4, 124, 32);
				panel.add(txtDistrito);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(475, 390, 193, 40);
			getContentPane().add(panel);
			{
				txtFormaPago = new HintTextField("Forma Pago");
				txtFormaPago.setColumns(10);
				txtFormaPago.setBorder(null);
				txtFormaPago.setBackground(new Color(247, 249, 249));
				txtFormaPago.setBounds(59, 4, 124, 32);
				panel.add(txtFormaPago);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(475, 547, 193, 40);
			getContentPane().add(panel);
			{
				txtNumeroDocumento = new HintTextField("Numero documento");
				txtNumeroDocumento.setColumns(10);
				txtNumeroDocumento.setBorder(null);
				txtNumeroDocumento.setBackground(new Color(247, 249, 249));
				txtNumeroDocumento.setBounds(59, 4, 124, 32);
				panel.add(txtNumeroDocumento);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			panel.setBackground(new Color(247, 249, 249));
			panel.setBounds(475, 496, 193, 40);
			getContentPane().add(panel);
			{
				txtTipoDocumento = new HintTextField("Tipo Documento");
				txtTipoDocumento.setColumns(10);
				txtTipoDocumento.setBorder(null);
				txtTipoDocumento.setBackground(new Color(247, 249, 249));
				txtTipoDocumento.setBounds(59, 4, 124, 32);
				panel.add(txtTipoDocumento);
			}
			{
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(3, 4, 42, 32);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(48, 0, 1, 49);
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel() {
				protected void paintComponent(Graphics g) {
				}
				public void updateUI() {
				}
			};
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				registrar();
				IntCliente.model.setRowCount(0);
				IntCliente.listar();
				dispose();
				}
			});
			panel.setLayout(null);
			panel.setBackground(new Color(15, 149, 236));
			panel.setBounds(489, 638, 193, 40);
			getContentPane().add(panel);
			{
				JLabel label = new JLabel("Registrar");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				label.setBounds(62, 0, 80, 40);
				panel.add(label);
			}
		}
		
		spLimiteCredito = new JSpinner();
		spLimiteCredito.setBounds(475, 309, 106, 25);
		getContentPane().add(spLimiteCredito);
		
		JLabel lblLimiteCredito = new JLabel("limite credito");
		lblLimiteCredito.setBounds(599, 309, 94, 25);
		getContentPane().add(lblLimiteCredito);
	}
	void registrar() {
		
		String nombre,nombreComercial,direccion,depart,distri,telf,cel,correo,formaPago,nDomento,tipoDocumento;
		double limite_credito;
		
		nombre=txtNombreCliente.getText();
		nombreComercial=txtNombreComercial.getText();
		direccion=txtDireccion.getText();
		depart=txtDepartamento.getText();
		distri=txtDistrito.getText();
		telf=txtTelefono.getText();
		cel=txtCelular.getText();
		correo=txtCorreo.getText();
		formaPago=txtFormaPago.getText();
		nDomento=txtNumeroDocumento.getText();
		tipoDocumento=txtTipoDocumento.getText();
		limite_credito=Double.parseDouble(spLimiteCredito.getValue().toString());
		
		
		
		Clientes c=new Clientes();
		
		c.setNomb_cli(nombre);
		c.setNom_comercial(nombreComercial);
		c.setDirec_cli(direccion);
		c.setDepartamento_cli(depart);
		c.setDistrito_cli(distri);
		c.setTelf_cli(telf);
		c.setCelular(cel);
		c.setCorreo(correo);
		c.setFormaPago_cli(formaPago);
		c.setNum_doc_cli_(nDomento);
		c.setTip_doc_cli(tipoDocumento);
		c.setLimite_credito(limite_credito);
		
		int ok=new GestionClientes().registrar(c);
		if(ok!=0){
			JOptionPane.showMessageDialog(null, "registro exitoso");
		}
		else {
			JOptionPane.showMessageDialog(null, "error al registrar");
		}
	}
}
