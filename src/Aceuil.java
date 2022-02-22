import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aceuil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aceuil frame = new Aceuil();
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
	public Aceuil() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 263, 525);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("FindJobEasly");
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(40, 83, 201, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\downloadFolder\\imgJOB (1).png"));
		lblNewLabel.setBounds(0, 163, 263, 202);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(265, 0, 533, 525);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbTitre = new JLabel("<html>Welcome to our platform which will allow you to have an idea of ​​the job market and the most requested profiles</html>");
		lbTitre.setForeground(new Color(0, 0, 128));
		lbTitre.setFont(new Font("Traditional Arabic", Font.BOLD, 22));
		lbTitre.setBounds(10, 35, 511, 105);
		panel_1.add(lbTitre);
		
		JButton btnSignUp = new JButton("SignUp");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register.main(null);
				dispose();
			}
		});
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		btnSignUp.setBackground(new Color(64, 224, 208));
		btnSignUp.setBounds(371, 452, 152, 35);
		panel_1.add(btnSignUp);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.main(null);
				dispose();
			}
		});
		Login.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		Login.setBackground(new Color(255, 0, 0));
		Login.setForeground(new Color(255, 255, 255));
		Login.setBounds(155, 452, 158, 35);
		panel_1.add(Login);
	}
}
