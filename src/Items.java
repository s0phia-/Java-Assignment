/**
 * Class Items creates the items in the game
 * 
 * @author Sophia Jones
 * @version 1
 *
 */
public class Items {
	private String itemName;
	
	/**
	 * Create an item and provide its image name 
	 * @param itemName the image name of the item
	 */
	public Items(String itemName) {
		this.itemName=itemName;
	}
	
	/**
	 * Get the name of the item
	 * @return the item name 
	 */
	public String getItemName() {
		return itemName;
	}

}
