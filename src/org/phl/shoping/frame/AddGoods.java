package org.phl.shoping.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddGoods {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGoods window = new AddGoods();
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
	public AddGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("添加商品");
		frame.setBounds(100, 100, 585, 661);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u5546\u54C1\u7F16\u53F7");
		label.setBounds(125, 61, 72, 18);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		label_1.setBounds(125, 124, 72, 18);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u4EF7\u683C");
		label_2.setBounds(125, 201, 72, 18);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u5E93\u5B58");
		label_3.setBounds(125, 264, 72, 18);
		frame.getContentPane().add(label_3);

		textField = new JTextField();
		textField.setBounds(307, 58, 142, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(307, 121, 142, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(307, 198, 142, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(307, 261, 142, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserStore.main(null);
				frame.setVisible(false);
			}
		});
		button.setBounds(325, 434, 113, 27);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserStore.main(null);
				frame.setVisible(false);
			}
		});
		button_1.setBounds(138, 434, 113, 27);
		frame.getContentPane().add(button_1);
	}

}
