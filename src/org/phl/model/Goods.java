package org.phl.model;

import java.io.Serializable;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int good_id;
	public String GoodsName;
	public char type;
	public String info;
	public int number;
	public int price;
	public int inventory;// ¿â´æ

	public int getGood_id() {
		return good_id;
	}

	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String toString() {
		return (new StringBuilder("Goods [good_id=")).append(good_id).append(", goodsName=").append(GoodsName)
				.append(", price=").append(price).append(", inventory=").append(inventory).append(", info=")
				.append(info).append("]").toString();
	}

}
