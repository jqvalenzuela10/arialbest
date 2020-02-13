package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import mantenimientos.GestionCaja;
import mantenimientos.GestionCorteCaja;
import model.Caja;
import model.CorteCaja;
import model.CorteCajaListadito;
import model.DetalleCorteCaja;
import model.Movimiento;
import model.RoundedCornerBorder;
import utils.clsArial;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JdialogCajaCorte extends JDialog {
	private JTextField lblcontado;
	public static JTextField lblcalculado;
	private JTextField lbldiferencia;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField lblretirado;
	private JPanel panel_1_1;
	private JLabel lblCalculado;
	public int numeroConcatenado = 0;
	public String concatenado = "";
	
	

	public int numeroCodigoCorteCaja=new GestionCorteCaja().ObtenerNumero();
	private java.text.DecimalFormat formato =
            new java.text.DecimalFormat("0.0"); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogCajaCorte dialog = new JdialogCajaCorte();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public JdialogCajaCorte() {

		setTitle("Corte de Caja");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 727, 413);
		setLocationRelativeTo(null);
		setModal(true);

		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(new clsArial().colorHover));
		panel.setBounds(0, 0, 711, 60);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCaja = new JLabel("Caja :");
		lblCaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaja.setForeground(new Color(240, 240, 240, 240));
		lblCaja.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblCaja.setBounds(294, 11, 74, 37);
		panel.add(lblCaja);

		JLabel lblCaja_2 = new JLabel(FrmMenuPrincipal.lblCaja_1.getText());
		lblCaja_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaja_2.setForeground(new Color(240, 240, 240, 240));
		lblCaja_2.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblCaja_2.setBounds(365, 11, 97, 37);
		panel.add(lblCaja_2);

		JLabel lblEfectivo = new JLabel("Efectivo");
		lblEfectivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEfectivo.setForeground(Color.BLACK);
		lblEfectivo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblEfectivo.setBounds(26, 134, 64, 14);
		getContentPane().add(lblEfectivo);

		lblcontado = new JTextField();
		lblcontado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
float numeroParse=Integer.parseInt(lblcontado.getText());
			
				
				
				double calculado=Double.parseDouble(lblcalculado.getText());
				double resultado=calculado-numeroParse;
				
			//	String n=String.format("%.1f", numeroParse+.0);
				lbldiferencia.setText(resultado+"");
			}
		});

	

		
		lblcontado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblcontado.setBounds(112, 133, 102, 20);
		getContentPane().add(lblcontado);
		lblcontado.setColumns(10);

		lblcalculado = new JTextField();
		lblcalculado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblcalculado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblcalculado.setColumns(10);
		lblcalculado.setBounds(224, 133, 102, 20);
		getContentPane().add(lblcalculado);

		lbldiferencia = new JTextField();
		lbldiferencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldiferencia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lbldiferencia.setColumns(10);
		lbldiferencia.setBounds(336, 133, 102, 20);
		getContentPane().add(lbldiferencia);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(540, 133, 102, 20);
		getContentPane().add(textField_3);

		JLabel lblContado = new JLabel("Contado");
		lblContado.setHorizontalAlignment(SwingConstants.CENTER);
		lblContado.setForeground(Color.BLACK);
		lblContado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblContado.setBounds(128, 108, 64, 14);
		getContentPane().add(lblContado);

		lblCalculado = new JLabel("Calculado");
		lblCalculado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculado.setForeground(Color.BLACK);
		lblCalculado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblCalculado.setBounds(242, 108, 64, 14);
		getContentPane().add(lblCalculado);

		JLabel lblDiferencia = new JLabel("Diferencia");
		lblDiferencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiferencia.setForeground(Color.BLACK);
		lblDiferencia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDiferencia.setBounds(349, 108, 70, 14);
		getContentPane().add(lblDiferencia);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(336, 164, 102, 20);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(224, 164, 102, 20);
		getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(112, 164, 102, 20);
		getContentPane().add(textField_6);

		JLabel lblCheque = new JLabel("Cheque");
		lblCheque.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheque.setForeground(Color.BLACK);
		lblCheque.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblCheque.setBounds(26, 165, 64, 14);
		getContentPane().add(lblCheque);

		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(336, 195, 102, 20);
		getContentPane().add(textField_7);

		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_8.setColumns(10);
		textField_8.setBounds(224, 195, 102, 20);
		getContentPane().add(textField_8);

		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_9.setColumns(10);
		textField_9.setBounds(112, 195, 102, 20);
		getContentPane().add(textField_9);

		JLabel lblTarjeta = new JLabel("Tarjeta");
		lblTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTarjeta.setForeground(Color.BLACK);
		lblTarjeta.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblTarjeta.setBounds(26, 196, 64, 14);
		getContentPane().add(lblTarjeta);

		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_10.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_10.setColumns(10);
		textField_10.setBounds(336, 258, 102, 20);
		getContentPane().add(textField_10);

		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_11.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_11.setColumns(10);
		textField_11.setBounds(224, 258, 102, 20);
		getContentPane().add(textField_11);

		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_12.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_12.setColumns(10);
		textField_12.setBounds(112, 258, 102, 20);
		getContentPane().add(textField_12);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblTotal.setBounds(26, 259, 64, 14);
		getContentPane().add(lblTotal);

		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_13.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_13.setColumns(10);
		textField_13.setBounds(540, 164, 102, 20);
		getContentPane().add(textField_13);

		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_14.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_14.setColumns(10);
		textField_14.setBounds(540, 195, 102, 20);
		getContentPane().add(textField_14);

		lblretirado = new JTextField();
		lblretirado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblretirado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblretirado.setColumns(10);
		lblretirado.setBounds(540, 258, 102, 20);
		getContentPane().add(lblretirado);

		JLabel lblRetiroPorCorte = new JLabel("Retiro por Corte");
		lblRetiroPorCorte.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetiroPorCorte.setForeground(Color.BLACK);
		lblRetiroPorCorte.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblRetiroPorCorte.setBounds(535, 108, 113, 14);
		getContentPane().add(lblRetiroPorCorte);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(235, 240, 244));
		panel_1_2.setBounds(100, 236, 548, 1);
		getContentPane().add(panel_1_2);

		JPanel panel_3 = new JPanel() {
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertarCorteCaja();
				
				actualizarSaldo();
				
				ArrayList<CorteCajaListadito> list=new GestionCorteCaja().listadito(numeroCodigoCorteCaja);
				if(list.isEmpty()) {
					
				}else {
					
				
				IntCajaCortes.lblcaja.setText(list.get(0).getNomCaja());
				IntCajaCortes.lblusuario.setText(list.get(0).getDesUsu());
				IntCajaCortes.lblnombre.setText(list.get(0).getNomUsu());
				IntCajaCortes.lblfecha.setText(list.get(0).getFechaCorteCaja());
				IntCajaCortes.lblhora.setText(list.get(0).getHoraCorteCaja());
				
				
			}
				dispose();	
			}

		});
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(35, 43, 55));
		panel_3.setBounds(308, 330, 130, 34);
		getContentPane().add(panel_3);

		JLabel lblT = new JLabel("Aceptar");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setForeground(SystemColor.menu);
		lblT.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblT.setBounds(16, 8, 96, 20);
		panel_3.add(lblT);

		panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(235, 240, 244));
		panel_1_1.setBounds(500, 97, 1, 189);
		getContentPane().add(panel_1_1);

	}

	ArrayList<DetalleCorteCaja> detalle = new ArrayList<>();
	ArrayList<DetalleCorteCaja> detallito = new ArrayList<>();

	void insertarCorteCaja() {

		int codCaja;

		

		/* tabla corte caja */


		int numeroCodigoCorteCaja = new GestionCorteCaja().ObtenerNumero();


		double contado,calculado,diferencia,retirado;
		
		codCaja=Integer.parseInt(FrmMenuPrincipal.lblCodCaja.getText());
		contado=Double.parseDouble(lblcontado.getText());
		calculado=Double.parseDouble(lblcalculado.getText());
		diferencia=Double.parseDouble(lbldiferencia.getText());
		retirado=Double.parseDouble(lblretirado.getText());
		
		/*tabla corte caja*/
		CorteCaja c=new CorteCaja();
		
	
		

		c.setCodCorteCaja(numeroCodigoCorteCaja);
		c.setCodCaja(codCaja);
		c.setContado(contado);
		c.setCalculado(calculado);
		c.setDiferencia(diferencia);
		c.setRetirado(retirado);

		c.setNomUsu(FrmMenuPrincipal.lblUsuario.getText().toString());
		c.setDescripcion(FrmMenuPrincipal.lblCargo.getText().toString());

		/*--------*
		
		/*listado para le detalle*/
		detalle = new GestionCorteCaja().listadoParaElDetalle(Integer.parseInt(FrmMenuPrincipal.lblCodCaja.getText()));

		for (DetalleCorteCaja d : detalle) {
			System.out.println("el codigo movi " + d.getCodMovi());
			System.out.println("el nombre de la caja " + d.getNomCaja());
			DetalleCorteCaja deta = new DetalleCorteCaja();
			deta.setCodMovi(d.getCodMovi());
			deta.setNomCaja(d.getNomCaja());
			detallito.add(deta);
		}

		/* metodo insertarCorteCaja */
		int ok = new GestionCorteCaja().registrarCorteDeCaja(c, detallito);
		if (ok != 0) {
			JOptionPane.showMessageDialog(null, "registro correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "hubo errores");
		}
	}

	private void actualizarSaldo() {
		// TODO Auto-generated method stub
		Caja c=new Caja();
		double saldito=Double.parseDouble(FrmMenuPrincipal.lblSaldo.getText())-Double.parseDouble(lblretirado.getText());
		c.setSaldo(saldito);
		FrmMenuPrincipal.lblSaldo.setText(saldito+"");
		c.setCodCaja(Integer.parseInt(FrmMenuPrincipal.lblCodCaja.getText()));
		int ok =new GestionCaja().actualizar(c);
		
		if(ok!=0) {
			System.out.println("el saldo se actualizo correctamente");
		}
		else {
			System.out.println("hubo errores al actualizar el saldo");
		}
	}
}
