package com.hmrc.shop.inventory;

import com.hmrc.shop.Item;
/**
 * A Classification of Item that represents fruit
 * This is not just a data holder; this is capable of calculating the individual cost
 * in its own business logic
 * 
 * @author Rajesh
 *
 */
public class Fruit implements Item {
	
	private String name;
	private double unitCost;
	private int quantity;
	Fruit(String name, double unitCost, int quantity) {
		this.name = name;
		this.unitCost = unitCost;
		this.quantity = quantity;
	}

	Fruit(String name, double unitCost) {
		this.name = name;
		this.unitCost = unitCost;
	}
	
	@Override
	public void updateQuantity(int quantity) {
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getUnitCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Double getItemCost() {
		// TODO Auto-generated method stub
		return null;
	}

}
