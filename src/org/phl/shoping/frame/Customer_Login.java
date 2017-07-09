package org.phl.shoping.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.phl.model.User;
import org.phl.network.TCPClient;
import org.phl.service.LRService;

public class Customer_Login {

	ArrayList<User> list = new ArrayList<User>();

	private TCPClient client;
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private JDialog jDialog = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Login window = new Customer_Login();
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
	public Customer_Login() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("用户登陆");
		frame.setBounds(100, 100, 584, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(177, 196, 72, 18);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u5BC6 \u7801");
		label_1.setBounds(177, 237, 205, 18);
		frame.getContentPane().add(label_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(231, 234, 140, 24);
		frame.getContentPane().add(passwordField);

		textField = new JTextField();
		textField.setBounds(231, 193, 140, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton button = new JButton("登陆");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserStore.main(null);
				frame.setVisible(false);
			}
		});

		button.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				String user_name = textField.getText();
				String Password = (new String(passwordField.getPassword())).trim();
				if (user_name == null || Password == null || user_name.equals("") || Password.equals("")) {
					JOptionPane.showMessageDialog(null, "您填的用户名或密码不正确");
					return;
				}
				LRService lrs = new LRService(client.getClient());
				try {
					// readFromFile();
					lrs.userLogin(user_name, Password);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "哈哈哈哈哈哈哈哈哈哈哈哈");
					e1.printStackTrace();
				}
			}

			final Customer_Login this$0;
			{

				this$0 = Customer_Login.this;
				// super();
			}

		});

		button.setBounds(177, 268, 86, 27);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("注册");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register_Frame.main(null);
				frame.setVisible(false);
			}

		});
		button_1.setBounds(292, 268, 86, 27);
		frame.getContentPane().add(button_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(261, 85, 72, 93);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\work\\workspace\\shoping\\src\\img\\a.jpg"));

	}

	// public void readFromFile() throws IOException, Exception {
	// FileInputStream fis = new FileInputStream(new
	// File("D:\\work\\workspace\\shoping\\user.dat"));
	// ObjectInputStream ois = new ObjectInputStream(fis);
	// User read = null;
	// try {
	// while (true) {
	// read = (User) ois.readObject();
	// if (read == null) {
	// break;
	// }
	//
	// list.add(read);
	// }
	// } catch (Exception e) {
	//
	// }
	// User temp = new User();
	// match(temp);
	// ois.close();
	//
	// }
	//
	// public void writeToFile() throws IOException {
	// File file = new File("D:\\work\\workspace\\shoping\\user.dat");
	// file.createNewFile();
	// ObjectOutputStream oos = new ObjectOutputStream(new
	// FileOutputStream(file, true));// 多个用户
	// for (User usr : list) {
	// oos.writeObject(usr);
	// }
	// oos.flush();
	// oos.close();
	//
	// }
	//
	// private void match(User user) {
	// boolean match = false;
	// for (User usr : list) {
	// if (usr.getName().equals(user.getName()) &&
	// usr.getPassword().equals(user.getPassword())) {
	// frame.setTitle("登陆成功");
	//
	// match = true;
	// UserStore.main(null);
	// frame.setVisible(false);
	// break;
	// }
	// }
	// if (!match) {
	// frame.setTitle("用户名或密码错误，请重新输入！");
	// textField.setText("");
	// passwordField.setText("");
	// textField.requestFocus();
	// }
	// }
}
