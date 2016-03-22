package com.hmrc.shop;
/**
 * The representation of the Item
 * The Item may come under any classification, fruit, veg or juice or anything.
 * 
 * @author Rajesh
 *
 */
public interface Item {
	public String getName();
	public Double getUnitCost();
	public int getQuantity();
	public Double getItemCost();
	void updateQuantity(int quantity);
}
