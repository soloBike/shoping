package org.phl.shoping.frame;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.phl.model.User;
import org.phl.service.LRService;

public class User_Login {

	private static final String thisFrame = null;

	ArrayList<User> list = new ArrayList<User>();

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public User user;
	// private JPasswordField rePassWord;
	private Socket client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		new User_Login();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Login window = new User_Login();
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
	public User_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("用户登陆");
		frame.setBounds(100, 100, 683, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel 用户名 = new JLabel("用户名");
		用户名.setBounds(223, 307, 45, 18);
		frame.getContentPane().add(用户名);

		JLabel 密码 = new JLabel("密 码");
		密码.setBounds(223, 357, 45, 18);
		frame.getContentPane().add(密码);

		// 登陆
		JButton btnNewButton = new JButton("登陆");

		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String user_name = textField.getText().trim();//
				String Password = (new String(passwordField.getPassword())).trim();
				if (user_name == null || Password == null || user_name.equals("") || Password.equals("")) {
					JOptionPane.showMessageDialog(null, "您填的用户名或密码不正确");
					return;
				}
				LRService lrs = new LRService(client.getClient());// .getClient()

				try {
					lrs.userLogin(user_name, Password);
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "用户不存在");

					e1.printStackTrace();
				}

			}

			final User_Login this$0;
			{
				// super();
				this$0 = User_Login.this;

			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setBounds(221, 421, 86, 27);
		frame.getContentPane().add(btnNewButton);
		// 注册
		JButton btnNewButton_1 = new JButton("注册");

		btnNewButton_1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				String user_name = textField.getText();//
				String Password = new String(passwordField.getPassword());
				if (user_name == null || Password == null || user_name.equals("") || Password.equals("")) {
					JOptionPane.showMessageDialog(null, "用户名或密码错误！", "温馨提示", 2);
					return;
				}
				LRService lrs = new LRService(client.getClient());// .getClient()

				try {
					lrs.userRegister(user_name, Password);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "u989D\uFF0C\u7F51\u7EDC\u4E0D\u901A\uFF01", "\u63D0\u793A", 2);
					e1.printStackTrace();
				}
			}

			final User_Login this$0;
			{
				this$0 = User_Login.this;
				// super();
			}

		});

		btnNewButton_1.setBounds(321, 422, 92, 27);
		frame.getContentPane().add(btnNewButton_1);
		// client = new TCPClient(thisFrame);
		// client.start();

		textField = new JTextField();
		textField.setBounds(282, 304, 135, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(282, 354, 135, 24);
		frame.getContentPane().add(passwordField);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(204, 64, 221, 220);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\work\\workspace\\shoping\\src\\img\\admin.jpg"));
	}

	public void callUser(String message) {
		JOptionPane.showMessageDialog(null, message, "u63D0\u793A", 2);
	}
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
// match = true;
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
