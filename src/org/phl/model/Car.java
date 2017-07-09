package org.phl.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map shoppingCar;
	private static double totalPrice;
	private static int totalQuantity;

	public Map getShoppingCar() {
		return shoppingCar;
	}

	public void setShoppingCar(Map shoppingCar) {
		this.shoppingCar = shoppingCar;
	}

	public static double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public static int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public void car() {
		shoppingCar = new HashMap();
		totalPrice = 0.0D;
		totalQuantity = 0;
	}

	public int add(Goods goods, int quantity) {
		if (shoppingCar.get(goods) == null) {
			shoppingCar.put(goods, Integer.valueOf(quantity));

		} else {
			int oldcount = ((Integer) shoppingCar.get(goods)).intValue();
			int newcount = quantity + oldcount;
			shoppingCar.remove(goods);
			shoppingCar.put(goods, Integer.valueOf(newcount));

		}
		total();
		return ((Integer) shoppingCar.get(goods)).intValue();
	}

	public int remove(Goods goods) {
		int q = ((Integer) shoppingCar.remove(goods)).intValue();
		total();
		return q;

	}

	public int remove(int gid) {
		Goods goods = new Goods();
		goods.setGood_id(gid);
		return remove(goods);
	}

	private void total() {
		totalPrice = 0.0D;
		totalQuantity = 0;
		Set goodsSet = shoppingCar.keySet();
		for (Iterator iterator = goodsSet.iterator(); iterator.hasNext();) {

			Goods goods = (Goods) iterator.next();
			int count = ((Integer) shoppingCar.get(goods)).intValue();
			totalQuantity = totalQuantity + count;
			totalPrice = totalPrice + (double) (goods.getPrice() * (float) count);

		}

	}

}
