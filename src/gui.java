

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controle.based;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class gui extends JFrame {
    private JFrame frame;
	private JPanel contentPane;
	private JTextField usernameF;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
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
	public gui() {
		setTitle("login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(-10, 0, 268, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel titre = new JLabel("FindJobEasly");
		titre.setBounds(20, 79, 238, 29);
		panel.add(titre);
		titre.setForeground(new Color(255, 255, 255));
		titre.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
		titre.setBackground(SystemColor.menu);
		
		JLabel image = new JLabel("New label");
		image.setIcon(new ImageIcon("D:\\downloadFolder\\imgJOB (1) (1).png"));
		image.setBounds(10, 162, 258, 210);
		panel.add(image);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(256, 0, 508, 511);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(117, 129, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel titreLogin = new JLabel("Login");
		titreLogin.setForeground(new Color(64, 224, 208));
		titreLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		titreLogin.setBounds(178, 11, 277, 44);
		panel_1.add(titreLogin);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		username.setBounds(10, 144, 120, 33);
		panel_1.add(username);
		
		usernameF = new JTextField();
		usernameF.setBounds(141, 144, 357, 33);
		panel_1.add(usernameF);
		usernameF.setColumns(10);
		
		JLabel lbPasswrd = new JLabel("Password");
		lbPasswrd.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbPasswrd.setBounds(10, 220, 105, 27);
		panel_1.add(lbPasswrd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 220, 357, 33);
		panel_1.add(passwordField);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=usernameF.getText();
				String pwd = String.valueOf(passwordField.getPassword());
				if(username.isEmpty() || pwd.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please enter all field");
					return;
		
				}else {
					based test = new based();
					Connection con = test.connect();
					try {
			    		String sql="SELECT * FROM `users` WHERE username = '"+username+"' and password = '"+pwd+"';";
			    		Statement smt=con.createStatement();
			    		ResultSet rs=smt.executeQuery(sql);
			    		if(rs.next()) {
			    			Scrapper.main(null);
			    			dispose();
			    		}else {
			    			JOptionPane.showMessageDialog(frame, "username or password incorrect");
			    		}
			    		
			    		
			    	}catch(Exception e1) {
			    		e1.printStackTrace();
			    		
			    		
			    	}
				}
				
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(64, 224, 208));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(341, 456, 157, 33);
		panel_1.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        dispose();     
				Aceuil.main(null);
			}

			

		
		});
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnCancel.setBounds(178, 457, 153, 31);
		panel_1.add(btnCancel);
	}
}
