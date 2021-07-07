package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Application extends JFrame {
	
	private JPanel pn_main;
	private JTextField tf_nama;
	private JTextField tf_alamat;
	private JTextField tf_no_tlp;
	private JTextField tf_tagihan;
	private JCheckBox cbx_steak;
	private JCheckBox cbx_spaghetti;
	private JCheckBox cbx_pizza;
	private JLabel lb_tagihan;
	private JTextPane tpn_display;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
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
	public Application() {
		setTitle("Aplikasi Pemesanan Makanan");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 600);
		
		// Main Panel
		pn_main = new JPanel();
		pn_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pn_main);
		pn_main.setLayout(null);
		
		
		// Label for Title App
		JLabel lb_title_app = new JLabel("APLIKASI PEMESANAN");
		lb_title_app.setBounds(148, 11, 172, 29);
		lb_title_app.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		pn_main.add(lb_title_app);
		
		// Customer Data Panel
		JPanel pn_cs_data = new JPanel();
		pn_cs_data.setBounds(10, 67, 310, 156);
		pn_main.add(pn_cs_data);
		pn_cs_data.setBorder(BorderFactory.createTitledBorder("Data Customer"));
		pn_cs_data.setLayout(null);
		
		// label nama
		JLabel lb_nama = new JLabel("Nama:");
		lb_nama.setBounds(10, 37, 46, 14);
		pn_cs_data.add(lb_nama);
		
		// textfield nama
		tf_nama = new JTextField();
		tf_nama.setBounds(76, 34, 134, 20);
		pn_cs_data.add(tf_nama);
		tf_nama.setColumns(10);
		
		// label alamat
		JLabel lb_alamat = new JLabel("Alamat:");
		lb_alamat.setBounds(10, 71, 46, 14);
		pn_cs_data.add(lb_alamat);
		
		// textfield alamat
		tf_alamat = new JTextField();
		tf_alamat.setBounds(76, 68, 134, 20);
		pn_cs_data.add(tf_alamat);
		tf_alamat.setColumns(10);
		
		// label no tlp
		JLabel lb_no_tlp = new JLabel("No Tlp:");
		lb_no_tlp.setBounds(10, 106, 46, 14);
		pn_cs_data.add(lb_no_tlp);
		
		// text field no tlp
		tf_no_tlp = new JTextField();
		tf_no_tlp.setBounds(76, 103, 134, 20);
		pn_cs_data.add(tf_no_tlp);
		tf_no_tlp.setColumns(10);
		
		// Menu Panel
		JPanel pn_menu = new JPanel();
		pn_menu.setBounds(352, 83, 193, 140);
		pn_main.add(pn_menu);
		pn_menu.setBorder(BorderFactory.createTitledBorder("Pilih Menu"));
		pn_menu.setLayout(null);
		
		// checkbox steak
		cbx_steak = new JCheckBox("Steak");
		cbx_steak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTotalBayar();
			}
		});
		cbx_steak.setBounds(6, 30, 97, 23);
		pn_menu.add(cbx_steak);
		
		cbx_spaghetti = new JCheckBox("Spaghetti");
		cbx_spaghetti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTotalBayar();
			}
		});
		cbx_spaghetti.setBounds(6, 56, 97, 23);
		pn_menu.add(cbx_spaghetti);
		
		cbx_pizza = new JCheckBox("Pizza");
		cbx_pizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTotalBayar();
			}
		});
		cbx_pizza.setBounds(6, 82, 97, 23);
		pn_menu.add(cbx_pizza);
		
		// Panel Data penjualan
		JPanel pn_data_penjualan = new JPanel();
		pn_data_penjualan.setBounds(10, 345, 535, 181);
		pn_main.add(pn_data_penjualan);
		pn_data_penjualan.setBorder(BorderFactory.createTitledBorder("Data Penjualan"));
		pn_data_penjualan.setLayout(null);
		
		JScrollPane scr_display = new JScrollPane();
		scr_display.setBounds(10, 23, 515, 147);
		pn_data_penjualan.add(scr_display);
		
		tpn_display = new JTextPane();
		scr_display.setViewportView(tpn_display);
		
		// Panel Tagihan
		JPanel pn_tagihan = new JPanel();
		pn_tagihan.setBounds(317, 234, 228, 100);
		pn_main.add(pn_tagihan);
		pn_tagihan.setLayout(null);
		
		// Label Tagihan
		lb_tagihan = new JLabel("TOTAL BAYAR");
		lb_tagihan.setBounds(10, 11, 90, 12);
		lb_tagihan.setFont(new Font("Tahoma", Font.BOLD, 12));
		pn_tagihan.add(lb_tagihan);
		
		// text field tagihan
		tf_tagihan = new JTextField();
		tf_tagihan.setEditable(false);
		tf_tagihan.setBounds(10, 34, 208, 27);
		tf_tagihan.setBackground(Color.black);
		tf_tagihan.setForeground(Color.yellow);
		tf_tagihan.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_tagihan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf_tagihan.setText("0");
		pn_tagihan.add(tf_tagihan);
		
		
		// button tambah
		JButton btn_tambah = new JButton("TAMBAH");
		btn_tambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inputValidation())
					tambahData();
			}
		});
		btn_tambah.setBounds(129, 72, 89, 23);
		pn_tagihan.add(btn_tambah);
	}
	
	private void getTotalBayar()
	{
		int totalBayar = 0;
		if(cbx_steak.isSelected())
			totalBayar += 50000;
		
		if(cbx_spaghetti.isSelected())
			totalBayar += 40000;
		
		if(cbx_pizza.isSelected())
			totalBayar += 80000;
		
		tf_tagihan.setText(Integer.toString(totalBayar));
	}
	
	private void tambahData()
	{
		String data = "";
		
		// Concatenate Customer data
		data += "Nama : " + tf_nama.getText() + "\n";
		data += "Alamat : " + tf_alamat.getText() + "\n";
		data += "Telp : " + tf_no_tlp.getText() + "\n";
		data += "-----------------------------------\n";
		
		// Concatenate Menu Order
		data += "Pesanan :\n";
		if(cbx_steak.isSelected())
			data += " - Steak(50000)\n";
		
		if(cbx_spaghetti.isSelected())
			data += " - Spaghetti(40000)\n";
		
		if(cbx_pizza.isSelected())
			data += " - Pizza(80000)\n";
		data += "-----------------------------------\n";
		
		// Concatenate Total Bill
		data += "Total Bayar:\n";
		data += "   Rp.";
		data += tf_tagihan.getText();
		data += "\n\n";
		
		// Display in display text
		tpn_display.setText(tpn_display.getText() + data);
		
		// reset all input data
		resetInputData();
	}
	
	private void resetInputData()
	{
		tf_nama.setText("");
		tf_alamat.setText("");
		tf_no_tlp.setText("");
		tf_tagihan.setText("0");
		
		cbx_steak.setSelected(false);
		cbx_spaghetti.setSelected(false);
		cbx_pizza.setSelected(false);
	}
	
	private boolean inputValidation()
	{
		if(tf_nama.getText().length() == 0 || tf_alamat.getText().length() == 0 || tf_no_tlp.getText().length() == 0)
		{
			JOptionPane.showMessageDialog(null, "Data Customer Harus di Isi Lengkap");
			return false;
		}
		
		if(tf_tagihan.getText().compareTo("0") == 0)
		{
			JOptionPane.showMessageDialog(null, "Kamu tidak memesan apa-apa");
			return false;
		}
		
		return true;
	}
}
