package org.phl.shoping.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.phl.model.Car;
import org.phl.network.TCPClient;
import org.phl.service.GoodsService;

public class CarFrame {

	private JFrame frame;
	private JTable table1;
	private TCPClient client;
	private Car car;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarFrame window = new CarFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CarFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(14, 45, 776, 356);
		frame.getContentPane().add(panel);

		// table = new JTable();
		// panel.add(table);

		table1 = new JTable();
		panel.add(table1);
		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("\u5546\u54C1\u7F16\u53F7");
		model.addColumn("\u540D\u79F0");
		model.addColumn("\u5355\u4EF7(\u4EBA\u6C11\u5E01)");
		model.addColumn("\u5E93\u5B58");
		model.addColumn("\u5546\u54C1\u63CF\u8FF0");

		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		panel.setLayout(null);

		table.setPreferredScrollableViewportSize(new Dimension(900, 420));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(14, 13, 748, 330);
		panel.add(scrollPane);

		JLabel label = new JLabel("\u6211\u7684\u8D2D\u7269\u8F66");
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBackground(Color.BLACK);
		label.setBounds(14, 13, 120, 30);
		frame.getContentPane().add(label);

		JButton button = new JButton("结账");
		button.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				try {
					GoodsService goodsService = new GoodsService(client.getClient());
					goodsService.sendPayRequest(car);
					frame.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			final CarFrame this$0;

			{
				this$0 = CarFrame.this;
				// super();
			}
		});
		button.setBackground(Color.RED);
		button.setBounds(659, 408, 127, 45);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserStore.main(null);
				frame.setVisible(false);
			}
		});
		button_1.setBounds(512, 408, 102, 45);
		frame.getContentPane().add(button_1);

		JLabel label_1 = new JLabel(
				(new StringBuilder("\u603B\u5546\u54C1\u6570\u91CF: ")).append(Car.getTotalQuantity()).toString());
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(47, 407, 158, 42);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel((new StringBuilder("\u603B\u91D1\u989D: ")).append(Car.getTotalPrice()).toString());
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(225, 407, 132, 42);
		frame.getContentPane().add(label_2);
	}
}