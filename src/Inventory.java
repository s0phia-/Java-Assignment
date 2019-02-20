import java.util.ArrayList;
import java.util.List;

/**
 * Inventory Class stores items. It adds items a player picks up, and removes 
 * items they put down. It also contains information on how to change the 
 * current inventory item to another item selected in the inventory.
 * 
 * 
 * @author Sophia Jones
 * @version 1
 *
 */
public class Inventory {
	private List<Items> inventory;
	
	/**
	 * Creates the inventory - an array list to store inventory items in
	 */
	public Inventory() {
		inventory = new ArrayList<>();
	}
	
	/**
	 *  Fetch the image name of an item 
	 * @param item the item whose image name is fetched
	 * @return the image name 
	 */
	public String itemImageName(Items item) {
		return item.getItemName();
	}
	
	/**
	 * Retrieves an item from the inventory with a given index.
	 * @param index the index of the item you would like to retrieve from
	 * the inventory
	 * @return The item with index "index"
	 */
	public Items getInventoryItems(int index) {
		//Before retrieving the item, check first that the index isn't empty.
		//If it is, return null.
		if (inventoryEmpty() == true) {
			return null;
		}
		return inventory.get(index);
	}

	/**
	 * Given an initial item, retrieve the item stored after it in the 
	 * inventory.
	 * @param initial the initial item
	 * @return the item stored after the initial item
	 */
	public Items getNextItem(Items initial) {
		//Check first that the inventory stores an item after the initial
		//one. If it doesn't, return null.
		int index = inventory.indexOf(initial);
		if (index < inventory.size()-1) {
			return inventory.get(inventory.indexOf(initial)+1);
		}
		else return null;
	}
	
	/**
	 * Given an initial item, retrieve the item stored after it in the 
	 * inventory.
	 * @param item the initial item
	 * @return the item stored before the initial item
	 */
	public Items getPrevItem(Items item) {
		//Check first that the inventory stores a previous item. If it
		//doesn't, return null.
		int index = inventory.indexOf(item);
		if (0 < index) {
			return inventory.get(inventory.indexOf(item)-1);
		}
		else return null;
	}
	
	/**
	 * Given an initial item, return the item stored nearest to it, giving 
	 * priority to the item after
	 * @param item the initial item
	 * @return If it exists, the next item. Otherwise, the previous item.
	 * 
	 */
	public Items getNearest(Items item) {
		if (getNextItem(item) == null) {
			return getPrevItem(item);
		}
		else return getNextItem(item);
	}
	

	/** 
	 * Determine whether the inventory is empty
	 * @return true if the inventory is empty, false otherwise
	 */
	public boolean inventoryEmpty() {
		return inventory.isEmpty();
	}

	
	/**
	 * Add an item to the inventory
	 * @param itemName the name of the item to be added
	 */
	public void addInventoryItems(Items itemName) {
		inventory.add(itemName);
	}

	
	/**
	 * Remove an item from the inventory
	 * @param itemName the name of the item to be removed
	 */
	public void removeInventoryItem(Items itemName) {
		inventory.remove(itemName);
	}
	
}
