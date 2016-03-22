/**
 * 
 */
package com.hmrc.shop.inventory;

import java.util.List;

import com.hmrc.shop.Inventory;
import com.hmrc.shop.Item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The fruit inventory maintains information related to Fruits.
 * 
 * @author Rajesh
 *
 */
public class FruitInventory implements Inventory {
	private static final Logger LOGGER = LoggerFactory.getLogger(FruitInventory.class);
	
	private List<Fruit> fruitStore;
	
	FruitInventory(String fruitfile) {
		//TODO : Update the collection from the given fruit file.
	}

	@Override
	public Item getItem(String name, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAvailable(String name, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

}
