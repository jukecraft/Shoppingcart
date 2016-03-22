package com.hmrc.shop.bom;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmrc.shop.BillCalculator;
import com.hmrc.shop.Inventory;
import com.hmrc.shop.Item;
import com.hmrc.shop.TechnicalFailureException;
import com.hmrc.shop.inventory.FruitInventory;

/**
 * A simple calculator for the bill of materials.
 * 
 * @author Rajesh
 *
 */
public class Calculator implements BillCalculator {
	private List<Item> billableItemList;
	private double totalCost;
	private Inventory fruitInventory = null;
	private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);
	
	public enum PROPERTY_KEYS {
		FRUIT_PROPERTYFILE
	}
	
	public Calculator(Map<String, String> initFiles) throws TechnicalFailureException {
		if (!initFiles.containsKey(PROPERTY_KEYS.FRUIT_PROPERTYFILE.toString())) {
			LOGGER.debug("The property specified in the initFile is mandatory");
			throw new TechnicalFailureException("Fruit File is mandatory");
		}
		try {
			String fruitFile = initFiles.get(PROPERTY_KEYS.FRUIT_PROPERTYFILE.toString());
			fruitInventory = new FruitInventory(fruitFile);
		} catch (Exception e) {
			throw new TechnicalFailureException(e.getMessage());
		}
	}
	/**
	 * Generate the Cost
	 */
	@Override
	public double generate(String[] items) {
		//Group the items as a Map
		List<String> customerItemList = Arrays.asList(items);
		Map<String, Long> itemMap = customerItemList.stream()
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//Iterate through the map to collect the items in the billableItemList
		billableItemList = itemMap.entrySet().stream()
				.filter(itemEntry -> fruitInventory.isAvailable(itemEntry.getKey()))
				.map(itemEntry -> fruitInventory.getItem(itemEntry.getKey(), itemEntry.getValue().intValue()))
				.collect(Collectors.toList());
		//Calculate the total cost and return
		totalCost = billableItemList.stream().mapToDouble(item-> item.getItemCost()).sum();
		return totalCost;
	}

}
