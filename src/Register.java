	import java.awt.BorderLayout;
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	
	import Dao.user;
	import controle.based;
	
	import java.awt.Color;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	
	import java.awt.Font;
	import javax.swing.ImageIcon;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.Statement;
	
	import javax.swing.JScrollPane;
import java.awt.event.MouseMotionAdapter;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
	
	public class Register extends JFrame {
	
		private JPanel contentPane;
		private JFrame frame;
		
		private JTextField TFFirstN;
		private JTextField tfLastN;
		private JTextField TFUser;
		private JTextField tFeMAIL;
		private JPasswordField passwordF;
		private JPasswordField PFConf;
	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Register frame = new Register();
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
		@SuppressWarnings("deprecation")
		public Register() {
			setTitle("SignUp");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 851, 703);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(64, 224, 208));
			panel.setBounds(0, 0, 261, 664);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("FindJobEasly");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(42, 59, 180, 40);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
			
			JLabel lblNewLabel_3 = new JLabel("Click here to login");
			lblNewLabel_3.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					dispose(); 
					gui loginP = new gui();
					loginP.setVisible(true);
					loginP.setLocationRelativeTo(null);
					loginP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				}
			});
			lblNewLabel_3.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
			lblNewLabel_3.setBounds(10, 628, 212, 25);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("D:\\downloadFolder\\imgJOB (1) (1).png"));
			lblNewLabel_1.setBounds(0, 173, 261, 227);
			panel.add(lblNewLabel_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(260, 0, 575, 664);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Sign up");
			lblNewLabel_2.setBounds(246, 11, 165, 43);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_2.setForeground(new Color(64, 224, 208));
			panel_1.add(lblNewLabel_2);
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBounds(225, 11, 1, 1);
			panel_1_1.setLayout(null);
			panel_1_1.setBackground(Color.WHITE);
			panel_1.add(panel_1_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Sign up");
			lblNewLabel_1_1.setForeground(new Color(64, 224, 208));
			lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
			lblNewLabel_1_1.setBounds(111, 23, 210, 33);
			panel_1_1.add(lblNewLabel_1_1);
			
			JLabel lbFirstName = new JLabel("First name");
			lbFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbFirstName.setBounds(10, 124, 124, 27);
			panel_1_1.add(lbFirstName);
			
			
			
			JLabel lbLastName = new JLabel("Last name");
			lbLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbLastName.setBounds(10, 198, 93, 33);
			panel_1_1.add(lbLastName);
			
			
			
			JLabel lbUsername = new JLabel("Username");
			lbUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbUsername.setBounds(10, 289, 93, 27);
			panel_1_1.add(lbUsername);
			
			JLabel lbEmail = new JLabel("Email");
			lbEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbEmail.setBounds(10, 371, 80, 27);
			panel_1_1.add(lbEmail);
			
			
			
			JLabel lbPwd = new JLabel("Password");
			lbPwd.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbPwd.setBounds(10, 446, 93, 14);
			panel_1_1.add(lbPwd);
			
			
			
			JLabel lbFirstN = new JLabel("First name");
			lbFirstN.setBounds(10, 131, 137, 14);
			lbFirstN.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbFirstN.setForeground(new Color(0, 0, 0));
			panel_1.add(lbFirstN);
			
			TFFirstN = new JTextField();
			TFFirstN.setBounds(157, 118, 390, 43);
			panel_1.add(TFFirstN);
			TFFirstN.setColumns(10);
			
			JLabel LBLastName = new JLabel("Last name");
			LBLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
			LBLastName.setBounds(10, 196, 92, 17);
			panel_1.add(LBLastName);
			
			tfLastN = new JTextField();
			tfLastN.setBounds(157, 185, 390, 43);
			panel_1.add(tfLastN);
			tfLastN.setColumns(10);
			
			JLabel lbUser = new JLabel("Username");
			lbUser.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbUser.setBounds(10, 277, 92, 14);
			panel_1.add(lbUser);
			
			TFUser = new JTextField();
			TFUser.setBounds(157, 261, 390, 43);
			panel_1.add(TFUser);
			TFUser.setColumns(10);
			
			JLabel lbemail = new JLabel("Email");
			lbemail.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbemail.setBounds(10, 341, 85, 14);
			panel_1.add(lbemail);
			
			tFeMAIL = new JTextField();
			tFeMAIL.setBounds(157, 343, 390, 43);
			panel_1.add(tFeMAIL);
			tFeMAIL.setColumns(10);
			
			JLabel lbpwd = new JLabel("Password");
			lbpwd.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbpwd.setBounds(10, 431, 104, 14);
			panel_1.add(lbpwd);
			
			passwordF = new JPasswordField();
			passwordF.setBounds(157, 423, 390, 43);
			panel_1.add(passwordF);
			
			JLabel lbConfPwd = new JLabel("Confirm Password");
			lbConfPwd.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbConfPwd.setBounds(10, 511, 137, 14);
			panel_1.add(lbConfPwd);
			
			PFConf = new JPasswordField();
			PFConf.setBounds(157, 503, 390, 35);
			panel_1.add(PFConf);
			
			JButton btnRegister = new JButton("Register");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nom,prenom,username,email,password,passwordC;
					nom=tfLastN.getText();
					prenom=TFFirstN.getText();
					email=tFeMAIL.getText();
					username=TFUser.getText();
				    password=(String.valueOf(passwordF.getPassword())).trim();		
				    passwordC=(String.valueOf(PFConf.getPassword())).trim();
				    if(nom.isEmpty()||prenom.isEmpty()||email.isEmpty()||username.isEmpty()||password.isEmpty()||passwordC.isEmpty()) {
				    	JOptionPane.showMessageDialog(frame, "Please enter all field");
						
				    }else {
				    	if (passwordC.length() < 8 || password.length() < 8) {
				    		JOptionPane.showMessageDialog(frame, "Password should be at least 8 characters long");
				           
				        }
				    	else {
				    		if(passwordC.equals(password)) {
					    		
					    		based b = new based();
						    	Connection con = b.connect();
						    	try {
						    		String sql="SELECT * FROM `users` WHERE `email`='"+email+"'";
							    	Statement smt=con.createStatement();
						       		ResultSet rs=smt.executeQuery(sql);
						       		if(rs.next()) {
						       			JOptionPane.showMessageDialog(frame, "The email is already taken try another");
						       		}else {
						       			user User = new user(nom,prenom,username,password,email);
						       			
						       			boolean result = b.insertU(con, User);
						       			if(result) {
						       				JOptionPane.showMessageDialog(frame, "Your account has been created successflly");
						       				
						       			}else {
						       				JOptionPane.showMessageDialog(frame, "Ooops!unknown error occurred, please try again!");
						       			}
						       		}
						    	}catch(Exception e1) {
						    		e1.printStackTrace();
						    	}
					    	}
					    	else {
					    	
					    		JOptionPane.showMessageDialog(frame, "the confirmation password does not match");
					    	}
				    	}
				    	
				    	
				    	
				    }
				}
			});
			btnRegister.setBackground(new Color(64, 224, 208));
			btnRegister.setForeground(new Color(255, 255, 255));
			btnRegister.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
			btnRegister.setBounds(410, 607, 137, 35);
			panel_1.add(btnRegister);
			
			JButton btnClear = new JButton("Clear");
			btnClear.setForeground(new Color(255, 255, 255));
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfLastN.setText("");
					TFFirstN.setText("");
					tFeMAIL.setText("");
					TFUser.setText("");
					passwordF.setText("");
					PFConf.setText("");
					
				}
			});
			btnClear.setBackground(new Color(192,192,192));
			btnClear.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
			btnClear.setBounds(225, 607, 150, 35);
			panel_1.add(btnClear);
		}
	}
