package org.phl.shoping.frame;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.phl.model.Car;
import org.phl.model.Goods;
import org.phl.shoping.io.RegexUtility;

public class UserGoods {

	private JFrame frame;
	private Car car;
	private Goods goods;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGoods window = new UserGoods();
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
	public UserGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("…Ã∆∑œÍ«È");
		frame.setBounds(100, 100, 298, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel goodsName = new JLabel(goods.getGoodsName());
		goodsName.setBounds(166, 47, 72, 18);
		frame.getContentPane().add(goodsName);

		JLabel price = new JLabel(Float.toString(goods.getPrice()));
		price.setBounds(166, 120, 72, 18);
		frame.getContentPane().add(price);

		JLabel info = new JLabel(goods.getInfo());
		info.setBounds(166, 196, 72, 18);
		frame.getContentPane().add(info);

		JLabel label_4 = new JLabel((new StringBuilder("ø‚¥Ê£∫")).append(goods.getInventory()).toString());
		label_4.setBounds(31, 334, 81, 18);
		frame.getContentPane().add(label_4);

		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0");
		label.setBounds(31, 47, 72, 18);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u5355\u4EF7");
		label_1.setBounds(31, 120, 72, 18);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u7B80\u4ECB");
		label_2.setBounds(31, 196, 72, 18);
		frame.getContentPane().add(label_2);

		JLabel label_5 = new JLabel("\u8D2D\u4E70\u91CF");
		label_5.setBounds(31, 259, 72, 18);
		frame.getContentPane().add(label_5);

		textField = new JTextField();
		textField.setBounds(152, 256, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton button = new JButton("\u52A0\u5165\u8D2D\u7269\u8F66");
		button.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				String text = textField.getText();// quantity
				if (!RegexUtility.isInteger(text))
					JOptionPane.showMessageDialog(null, "\u5E93\u5B58\u91CF\u8BF7\u8F93\u5165\u6574\u6570\u503C\uFF01",
							"\u63D0\u793A", 2);
				Map shoppingCar = car.getShoppingCar();
				int count = Integer.parseInt(text);
				car.add(goods, count);
				label.setText((new StringBuilder("\u8D2D\u7269\u8F66: ")).append(shoppingCar.size())
						.append("\u4EF6\u5546\u54C1").toString());
				label.updateUI();
				frame.setVisible(false);
			}

			final UserGoods this$0;

			{
				this$0 = UserGoods.this;
				// super();
			}
		});
		button.setBounds(81, 390, 127, 52);
		frame.getContentPane().add(button);

	}
}
