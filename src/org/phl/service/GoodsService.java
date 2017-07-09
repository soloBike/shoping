package org.phl.service;

import java.net.Socket;

import org.phl.model.Car;
import org.phl.shoping.io.IOUtils;

public class GoodsService {
	private Socket client;

	public GoodsService(Socket client) {
		this.client = client;
	}

	public void searchGoods(String name) throws Exception {
		Request request = new Request();
		request.setType(2);
		request.setGoodsName(name);
		IOUtils.persistObjectNoClose(request, client.getOutputStream());
	}

	public void sendPayRequest(Car car) throws Exception {
		Request request = new Request();
		request.setType(4);
		request.setCar(car);
		IOUtils.persistObjectNoClose(request, client.getOutputStream());

	}

}
