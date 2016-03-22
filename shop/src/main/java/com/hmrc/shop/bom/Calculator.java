package com.hmrc.shop.bom;

import java.util.List;

import com.hmrc.shop.BillOfMaterials;
import com.hmrc.shop.Item;
/**
 * A simple calculator for the bill of materials.
 * 
 * @author Rajesh
 *
 */
public class Calculator implements BillOfMaterials {
	private List<Item> itemList;
	private double totalCost;
	
	@Override
	public double generate(String... items) {
		return 0;
	}

}
