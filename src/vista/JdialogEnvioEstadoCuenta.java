package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import java.util.Properties;
import java.util.Base64.Decoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.SystemColor;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JdialogEnvioEstadoCuenta extends JDialog {
	private JTextField textField_1;
	private JTextField txtAsunto;
	private JTextField txtRemitente;
	private JTextField txtReceptor;
	private JTextArea txtObservaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogEnvioEstadoCuenta dialog = new JdialogEnvioEstadoCuenta();
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
	public JdialogEnvioEstadoCuenta() {
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 504, 538);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1493e1"));
		panel.setBounds(0, 0, 488, 47);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCobranzaMedios = new JLabel("ENVIO DE CORREO");
		lblCobranzaMedios.setForeground(new Color(240,240,240));
		lblCobranzaMedios.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCobranzaMedios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCobranzaMedios.setBounds(125, 11, 248, 14);
		panel.add(lblCobranzaMedios);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Properties propiedad = new Properties();
			        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
			        propiedad.setProperty("mail.smtp.starttls.enable", "true");
			        propiedad.setProperty("mail.smtp.port", "587");
			        propiedad.setProperty("mail.smtp.auth","true");
			        

			        
			        Session sesion = Session.getDefaultInstance(propiedad);
			        String correoEnvia = txtRemitente.getText();
			        String contrasena = "ciclope2210";
			        String receptor = txtReceptor.getText();
			        String asunto = txtAsunto.getText();
			        String mensaje=txtObservaciones.getText();
			        
			        MimeMessage mail = new MimeMessage(sesion);
			        try {
			            mail.setFrom(new InternetAddress (correoEnvia));
			            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
			            mail.setSubject(asunto);
			            mail.setText(mensaje);
			            
			            Transport transportar = sesion.getTransport("smtp");
			            transportar.connect(correoEnvia,contrasena);
			            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
			            transportar.close();
			            
			            JOptionPane.showMessageDialog(null, "Listo, Estado de cuenta enviado");
			            
			            dispose();
			        } catch (AddressException ex) {
			            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
			            JOptionPane.showMessageDialog(null, "Error al enviar");
			        } catch (MessagingException ex) {
			            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
			            JOptionPane.showMessageDialog(null, "Error al enviar");
			        }
			        
			}
		});
		btnEnviar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnEnviar.setBackground(new Color(240,240,240));
		btnEnviar.setBounds(200, 465, 89, 23);
		getContentPane().add(btnEnviar);
		
		JLabel lblDe = new JLabel("De :");
		lblDe.setForeground(new Color(119, 119, 119));
		lblDe.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDe.setBounds(22, 58, 52, 21);
		getContentPane().add(lblDe);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(SystemColor.menu);
		separator_5.setBackground(SystemColor.menu);
		separator_5.setBounds(84, 104, 389, 2);
		getContentPane().add(separator_5);
		
		JLabel lblArchivosAdjuntos = new JLabel("Archivos adjuntos");
		lblArchivosAdjuntos.setForeground(new Color(110, 203, 240));
		lblArchivosAdjuntos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblArchivosAdjuntos.setBounds(22, 391, 159, 21);
		getContentPane().add(lblArchivosAdjuntos);
		
		JLabel lblPara = new JLabel("Para :");
		lblPara.setForeground(new Color(119, 119, 119));
		lblPara.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblPara.setBounds(22, 86, 52, 21);
		getContentPane().add(lblPara);
		
		JLabel lblCc = new JLabel("CC :");
		lblCc.setForeground(new Color(119, 119, 119));
		lblCc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCc.setBounds(22, 118, 52, 21);
		getContentPane().add(lblCc);
		
		JLabel lblAsunto = new JLabel("Asunto :");
		lblAsunto.setForeground(new Color(119, 119, 119));
		lblAsunto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAsunto.setBounds(22, 150, 52, 21);
		getContentPane().add(lblAsunto);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtObservaciones.setBounds(22, 182, 451, 198);
		getContentPane().add(txtObservaciones);
		
		JButton btnAdjuntar = new JButton("Adjuntar");
		btnAdjuntar.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnAdjuntar.setBackground(SystemColor.menu);
		btnAdjuntar.setBounds(384, 391, 89, 23);
		getContentPane().add(btnAdjuntar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.menu);
		separator.setBackground(SystemColor.menu);
		separator.setBounds(84, 135, 389, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.menu);
		separator_1.setBackground(SystemColor.menu);
		separator_1.setBounds(84, 169, 389, 2);
		getContentPane().add(separator_1);
		
		txtReceptor = new JTextField();
		txtReceptor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtReceptor.setBorder(null);
		txtReceptor.setColumns(10);
		txtReceptor.setBounds(84, 85, 389, 20);
		getContentPane().add(txtReceptor);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setBorder(null);
		textField_1.setColumns(10);
		textField_1.setBounds(84, 116, 389, 20);
		getContentPane().add(textField_1);
		
		txtAsunto = new JTextField();
		txtAsunto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtAsunto.setBorder(null);
		txtAsunto.setColumns(10);
		txtAsunto.setBounds(84, 150, 389, 20);
		getContentPane().add(txtAsunto);
		
		JSeparator separator_5_1 = new JSeparator();
		separator_5_1.setForeground(SystemColor.menu);
		separator_5_1.setBackground(SystemColor.menu);
		separator_5_1.setBounds(84, 77, 389, 2);
		getContentPane().add(separator_5_1);
		
		txtRemitente = new JTextField();
		txtRemitente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtRemitente.setText("gquilcaval@gmail.com");
		txtRemitente.setColumns(10);
		txtRemitente.setBorder(null);
		txtRemitente.setBounds(84, 58, 389, 20);
		getContentPane().add(txtRemitente);

	}
}
