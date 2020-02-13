package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class JdialogOlvidateContraseña extends JDialog {
	private JTextField txtCorreoReceptor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogOlvidateContraseña dialog = new JdialogOlvidateContraseña();
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
	public JdialogOlvidateContraseña() {
		setModal(true);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Olvidaste Tu Contrase\u00F1a");
		setBounds(100, 100, 451, 182);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		txtCorreoReceptor = new JTextField();
		txtCorreoReceptor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCorreoReceptor.setBounds(48, 57, 275, 33);
		getContentPane().add(txtCorreoReceptor);
		txtCorreoReceptor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Escribe Tu Correo Electronico");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel.setBounds(48, 29, 194, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Recuperar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        Properties propiedad = new Properties();
		        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
		        propiedad.setProperty("mail.smtp.starttls.enable", "true");
		        propiedad.setProperty("mail.smtp.port", "587");
		        propiedad.setProperty("mail.smtp.auth","true");
		        

		        
		        Session sesion = Session.getDefaultInstance(propiedad);
		        String correoEnvia = "gian221097@gmail.com";
		        String contrasena = "ciclope2210";
		        String receptor = txtCorreoReceptor.getText();
		        String asunto = "Recuperacion de Contraseña";
		        String mensaje="n\\estimado imbecil : SU CONTRASEÑA ES --------";
		        
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
		            
		            JOptionPane.showMessageDialog(null, "Listo, revise su correo");
		            
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
		btnNewButton.setBounds(153, 109, 106, 23);
		getContentPane().add(btnNewButton);

	}
}
