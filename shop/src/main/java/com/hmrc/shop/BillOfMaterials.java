/**
 * 
 */
package com.hmrc.shop;

/**
 * @author Rajesh
 * The BillOfMaterials is responsible to provide a bill for the given list of materials
 */
@FunctionalInterface
public interface BillOfMaterials {
	public double generate(String... materials);
}