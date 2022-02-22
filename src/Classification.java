import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;

import ML.ClassificationTask;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Classification extends JFrame {

	private JPanel contentPane;
	private ArrayList lista=new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classification frame = new Classification();
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
	public Classification() {
		setTitle("Classification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(-11, 0, 269, 738);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FindJobEasy");
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(35, 64, 205, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\downloadFolder\\imgJOB (1) (1).png"));
		lblNewLabel_2.setBounds(10, 179, 259, 227);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(258, 0, 497, 738);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Select skills that you want to use for classification");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(10, 19, 446, 35);
		panel_1.add(lblNewLabel_1);
		
		String compétences[] = {"jee","sap", "html5", "python", "css3", "javascript" ,"react ",
				"jquery", "angular", "linux",  "php" ,"html","sql", "c++", "c#" ,"css", "vue" ,
				"docker","git","rest","boostrap",".net","js"};
		
		for(int i=0;i<compétences.length;i++) {
			lista.add(0.0);
		}
	  //  System.out.println("avant:"+lista);
		JList Skills = new JList(compétences);
		Skills.setForeground(new Color(0, 0, 0));
		Skills.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		//Skills.setSelectedIndex(1);
		Skills.setBackground(new Color(240, 255, 255));
		Skills.setBounds(90, 65, 272, 588);
		panel_1.add(Skills);
		Skills.setVisibleRowCount(23);
		Skills.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	
		
		JButton btnNewButton = new JButton("Execute");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 List<String> SelectedSkills = Skills.getSelectedValuesList();
				    	
			    	 int j=0;
			    	 for(int i=0; i<compétences.length;i++) {
			    		 if(SelectedSkills.get(j)==compétences[i]) {
			    			 lista.set(i, 1.0);
			    			 
			    			 if(SelectedSkills.size()>j+1) {
			    				 j++;
			    			 }
			    		 }
			    	 }
			    	
					ClassificationTask classf = new ClassificationTask();
					classf.classification(lista);
					dispose();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(314, 664, 173, 35);
		panel_1.add(btnNewButton);
	}
}
