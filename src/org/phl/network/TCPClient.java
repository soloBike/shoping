package org.phl.network;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

import org.omg.CORBA_2_3.portable.InputStream;
import org.phl.service.Request;
import org.phl.service.Response;
import org.phl.shoping.frame.UserStore;
import org.phl.shoping.frame.User_Login;
import org.phl.shoping.io.IOUtils;

public class TCPClient extends Thread {
	private Socket client;
	private volatile boolean flag;
	private User_Login loginframe;
	private UserStore userStore;

	public TCPClient(User_Login loginframe) {
		this.loginframe = loginframe;
		try {
			client = new Socket("127.0.0.1", 9999);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			flag = true;
			while (flag) {
				Response response = (Response) IOUtils.getObjectNoClose((InputStream) client.getInputStream());
				if (response != null) {
					switch (response.getMessageType()) {
					case 1:
					default:
						break;
					case 0:
						if (response.getResult()) {
							List goodsList = (List) response.getObj();
							userStore = new UserStore(this, response.getMessage(), goodsList);
							UserStore.main(null);
							// UserStore.setVisible(true);
							// loginframe.setVisible(false);
						} else {
							loginframe.callUser(
									"\u767B\u5F55\u5931\u8D25,\u9519\u8BEF\u7684\u7528\u6237\u540D\u548C\u5BC6\u7801\uFF01");

						}
						break;
					case 2:
						List goodsList = (List) response.getObj();
						UserStore.updateGoodsList(goodsList);
						break;
					case 3:
						User_Login.main(null);
						break;
					case 4:
						if (response.getResult())
							userStore.cleanCar();
						List newList = (List) response.getObj();
						UserStore.updateGoodsList(newList);
						UserStore.callUser(response.getMessage());
						break;
					}
				}
			}
		} catch (EOFException eofexception) {
		} catch (SocketException e) {
			System.out.println(
					"\u5BA2\u6237\u7AEF\u65E0\u6545\u6389\u7EBF\u6216\u7F51\u7EDC\u51FA\u73B0\u6545\u969C\uFF01");
			try {
				if (client != null && client.isClosed())
					client.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopClient() throws Exception {
		Request request = new Request();
		request.setType(3);
		IOUtils.persistObjectNoClose(request, client.getOutputStream());
		flag = false;
	}

	public Socket getClient() {
		return client;
	}

}
