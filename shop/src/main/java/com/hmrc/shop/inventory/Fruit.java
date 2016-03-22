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

	public Fruit(String name, double unitCost) {
		this.name = name;
		this.unitCost = unitCost;
	}
	
	@Override
	public void updateQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Double getUnitCost() {
		return this.unitCost;
	}

	@Override
	public int getQuantity() {
		return this.quantity;
	}

	@Override
	public Double getItemCost() {
		return unitCost * quantity;
	}

}
