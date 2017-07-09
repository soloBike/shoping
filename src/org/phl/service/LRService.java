package org.phl.service;

import java.net.Socket;

import org.phl.shoping.io.IOUtils;

public class LRService {
	public LRService(Socket client) {
		this.client = client;
	}
	//
	// public Socket getClient() {
	// return client;
	// }

	public void setClient(Socket client) {
		this.client = client;
	}

	public void userLogin(String user_name, String password) throws Exception {
		Request request = new Request();
		request.setType(0);
		request.setUser_name(user_name);
		request.setPassword(password);
		IOUtils.persistObjectNoClose(request, client.getOutputStream());

	}

	public void userRegister(String user_name, String password) throws Exception {
		System.out.println(client.getOutputStream());
		Request request = new Request();
		request.setType(1);
		request.setUser_name(user_name);
		request.setPassword(password);
		IOUtils.persistObjectNoClose(request, client.getOutputStream());
	}

	private Socket client;

}
