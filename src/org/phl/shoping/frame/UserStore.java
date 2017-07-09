package org.phl.shoping.frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.phl.model.Car;
import org.phl.model.Goods;
import org.phl.network.TCPClient;

public class UserStore extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Car car;
	private java.util.List goodsList;
	private TCPClient client;

	private JFrame frame;
	private static JTable table1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserStore window = new UserStore(null, null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Goods getGoodsById(java.util.List goodsList, int gid) {
		for (Iterator iterator = goodsList.iterator(); iterator.hasNext();) {
			Goods goods = (Goods) iterator.next();
			if (goods.getGood_id() == gid)
				return goods;
		}
		return null;
	}

	public static void updateGoodsList(List goods) {
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		removeAllRows(model);
		addGoodsToRows(goods, model);//
		table1.updateUI();
	}

	public static void removeAllRows(DefaultTableModel model) {
		for (; model.getRowCount() > 0; model.removeRow(model.getRowCount() - 1))
			;

	}

	public static void addGoodsToRows(java.util.List goods, DefaultTableModel model) {
		Goods g;
		for (Iterator iterator = goods.iterator(); iterator.hasNext(); model
				.addRow(new String[] { Integer.toString(g.getGood_id()), g.getGoodsName(), Float.toString(g.getPrice()),
						Integer.toString(g.getInventory()) }))
			g = (Goods) iterator.next();
	}

	public static void callUser(String message) {
		JOptionPane.showMessageDialog(null, message, "吃吃次和i吃货i和i和i", 2);
	}

	public void cleanCar() {
		car.getShoppingCar().clear();
		// AbstractButton label_3 = null;
		// label_3.setText((new
		// StringBuilder("威威威威威威威威")).append(car.getShoppingCar().size()).append("什么").toString());
		// label_3.updateUI();
	}

	/**
	 * Create the application.
	 */
	public UserStore(TCPClient client, String username, java.util.List goodsList) {
		car = new Car();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param goodsList
	 */
	private void initialize() {
		frame = new JFrame("中东购物");
		frame.setBounds(100, 100, 1029, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// setTitle((new StringBuilder("当前用户为:")).append(user_name).toString());

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 968, 492);
		frame.getContentPane().add(panel);

		table1 = new JTable();
		table1.setFont(new Font("宋体", Font.BOLD, 20));
		panel.add(table1);
		this.goodsList = goodsList;
		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("\u5546\u54C1\u7F16\u53F7");
		model.addColumn("\u540D\u79F0");
		model.addColumn("\u5355\u4EF7(\u4EBA\u6C11\u5E01)");
		model.addColumn("\u5E93\u5B58");
		model.addColumn("\u5546\u54C1\u63CF\u8FF0");

		JTable table = new JTable(model);
		updateGoodsList(goodsList);

		JScrollPane scrollpane = new JScrollPane(table);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		panel.setLayout(null);

		table.setPreferredScrollableViewportSize(new Dimension(900, 420));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(14, 75, 940, 340);
		panel.add(scrollPane);

		JLabel label_3 = new JLabel();
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(181, 391, 21, 24);
		panel.add(label_3);

		JLabel label_4 = new JLabel();
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(339, 391, 36, 24);
		panel.add(label_4);

		JButton button_2 = new JButton("商品搜索");
		// button_2.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// String text = textField.getText().trim();
		// if (text == null || text.equals("")) {
		// JOptionPane.showMessageDialog(null,
		// "\u60A8\u6CA1\u6709\u8F93\u5165\u4EFB\u4F55\u5185\u5BB9\uFF0C\u9ED8\u8BA4\u663E\u793A\u5168\u90E8\u5546\u54C1\u4FE1\u606F\uFF01");
		// UserStore.updateGoodsList(IOUtils.getAllGoods(), model);
		// UserStore.table1.updateUI();
		// return;
		// }
		// if (RegexUtility.isInteger(text)) {
		// JOptionPane.showMessageDialog(null,
		// "\u60A8\u7684\u8F93\u5165\u4E0D\u5408\u6CD5\uFF0C\u8BF7\u8F93\u5165\u6B63\u6574\u6570\uFF01");
		// return;
		// }
		// int id = Integer.parseInt(text);
		// Goods goods = IOUtils.getGoodsById(id);
		// if (goods == null) {
		// JOptionPane.showMessageDialog(null,
		// (new
		// StringBuilder("\u6CA1\u6709\u627E\u5230\u7F16\u53F7\u4E3A")).append(id)
		// .append("\u7684\u5546\u54C1\uFF01").toString());
		// UserStore.updateGoodsList(IOUtils.getAllGoods(), model);
		// UserStore.table1.updateUI();
		// return;
		// } else {
		// java.util.List gList = new ArrayList();
		// gList.add(goods);
		// UserStore.updateGoodsList(gList);
		// UserStore.table1.updateUI();
		// return;
		// }
		// }
		//
		// final UserStore this$0;
		//
		// {
		// this$0 = UserStore.this;
		// // super();
		// }
		//
		// });
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		button_2.setBounds(208, 35, 132, 27);
		panel.add(button_2);

		JLabel label = new JLabel("\u5546\u54C1\u7F16\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(28, 39, 97, 18);
		panel.add(label);

		textField = new JTextField();
		textField.setBounds(116, 38, 86, 24);
		panel.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("退出登陆");
		button.setFont(new Font("宋体", Font.PLAIN, 20));

		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "是否退出登录?");
				if (select == 0) {
					try {
						client.stopClient();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					System.exit(0);
				}

			}

			final UserStore this$0;
			{
				this$0 = UserStore.this;
				// super();
			}
		});
		button.setBounds(816, 35, 123, 27);
		panel.add(button);

		JButton button_1 = new JButton("查看商品详情");

		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectRow = table.getSelectedRow();
				if (selectRow == -1) {
					JOptionPane.showMessageDialog(null,
							"\u60A8\u6CA1\u6709\u9009\u62E9\u5546\u54C1\uFF0C\u8BF7\u60A8\u9009\u4E2D\u67D0\u4E2A\u5546\u54C1\u540E\u518D\u5355\u51FB\u6B64\u6309\u94AE\uFF01",
							"\u63D0\u793A", 2);
					return;
				} else {
					int num = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
					Goods goods = getGoodsById(goodsList, num);
					// UserGoods d = new UserGoods();
					UserGoods.main(null);
					// d.setDefaultCloseOperation(1);
					// d.setVisible(true);
					return;
				}
			}
		});
		button_1.setBounds(534, 35, 218, 27);
		panel.add(button_1);

		JButton button_3 = new JButton("添加到购物车");
		button_3.setFont(new Font("宋体", Font.PLAIN, 20));
		button_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectRow = table.getSelectedRow();
				if (selectRow == -1) {
					JOptionPane.showMessageDialog(null,
							"\u60A8\u6CA1\u6709\u9009\u62E9\u5546\u54C1\uFF0C\u8BF7\u60A8\u9009\u4E2D\u67D0\u4E2A\u5546\u54C1\u540E\u518D\u5355\u51FB\u6B64\u6309\u94AE\uFF01",
							"\u63D0\u793A", 2);
					return;
				} else {
					int num = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
					Goods goods = getGoodsById(goodsList, num);
					// UserGoods d = new UserGoods();
					UserGoods.main(null);
					// d.setDefaultCloseOperation(1);
					// d.setVisible(true);
					return;
				}
			}
		});
		button_3.setBounds(567, 433, 185, 46);
		panel.add(button_3);

		JButton button_4 = new JButton("结算");
		button_4.setFont(new Font("宋体", Font.PLAIN, 20));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarFrame.main(null);
				frame.setVisible(false);
			}
		});
		button_4.setBounds(785, 434, 123, 45);
		panel.add(button_4);
		panel.setVisible(true);
	}
}
