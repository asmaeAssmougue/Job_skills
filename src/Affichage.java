import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controle.based;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Affichage extends JFrame {
    private JFrame frame;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Affichage frame = new Affichage();
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
	public Affichage() {
		setTitle("Affichage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 598);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewRslt = new JButton("See the results");
		btnViewRslt.setBackground(new Color(64, 224, 208));
		btnViewRslt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				based b = new based();
			     Connection con = b.connect();
			     ResultSet rs=b.selection(con);
			     table.setModel(DbUtils.resultSetToTableModel(rs));
			     
			}
		});
		btnViewRslt.setForeground(new Color(255, 255, 255));
		btnViewRslt.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnViewRslt.setBounds(515, 30, 273, 31);
		contentPane.add(btnViewRslt);
		
		JButton btnDownload = new JButton("download");
		btnDownload.setBackground(new Color(255, 69, 0));
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection connection=null;
				 based obj_DB_Connection=new based();
				 connection=obj_DB_Connection.connect();
				 download file = new download();
				 String path = "D:\\downloadFolder";
				 file.downloadFile(path, connection);
				 JOptionPane.showMessageDialog(frame, "the file is downloaded");
				 Classification.main(null);
				 dispose();
			}
		});
		
		btnDownload.setForeground(new Color(255, 255, 255));
		btnDownload.setFont(new Font("Traditional Arabic", Font.BOLD, 22));
		btnDownload.setBounds(786, 497, 200, 31);
		contentPane.add(btnDownload);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 261, 559);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("log out");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Aceuil.main(null);
			}
		});
		btnNewButton.setFont(new Font("Traditional Arabic", Font.BOLD, 26));
		btnNewButton.setBounds(53, 504, 146, 44);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("FindJobEasly");
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(48, 62, 203, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\downloadFolder\\imgJOB (1) (1).png"));
		lblNewLabel_1.setBounds(0, 195, 261, 196);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 90, 733, 385);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		//table.setPreferredSize(new Dimension(3000,7200));
        JTableHeader header = table.getTableHeader();
       
        header.setBackground(Color.pink);
       
      

        
	}
}
