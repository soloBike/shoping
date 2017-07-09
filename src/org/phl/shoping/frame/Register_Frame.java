package org.phl.shoping.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Register_Frame {

	private JFrame frameRegister;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Frame window = new Register_Frame();
					window.frameRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register_Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameRegister = new JFrame("用户注册");
		frameRegister.setBounds(100, 100, 684, 647);

		frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRegister.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(110, 95, 72, 18);
		frameRegister.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(110, 232, 72, 18);
		frameRegister.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_2.setBounds(110, 279, 72, 18);
		frameRegister.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u6027\u522B");
		label_3.setBounds(110, 141, 72, 18);
		frameRegister.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u7535\u8BDD");
		label_4.setBounds(110, 187, 72, 18);
		frameRegister.getContentPane().add(label_4);

		textField = new JTextField();
		textField.setBounds(221, 92, 146, 24);
		frameRegister.getContentPane().add(textField);
		textField.setColumns(10);

		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setBounds(220, 137, 43, 27);
		frameRegister.getContentPane().add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setBounds(285, 137, 48, 27);
		frameRegister.getContentPane().add(radioButton_1);

		ButtonGroup sexRadioButtonGroup = new ButtonGroup();
		sexRadioButtonGroup.add(radioButton);
		sexRadioButtonGroup.add(radioButton_1);

		textField_1 = new JTextField();
		textField_1.setBounds(221, 184, 146, 24);
		frameRegister.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(221, 232, 146, 24);
		frameRegister.getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(221, 276, 146, 24);
		frameRegister.getContentPane().add(passwordField_1);

		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Login.main(null);
				frameRegister.setVisible(false);

			}
		});
		button.setBounds(120, 357, 113, 27);
		frameRegister.getContentPane().add(button);

		JButton button_1 = new JButton("提交");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button_1.setBounds(254, 357, 113, 27);
		frameRegister.getContentPane().add(button_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(421, 13, 231, 544);
		frameRegister.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\work\\workspace\\shoping\\src\\img\\admin.jpg"));

	}
}
