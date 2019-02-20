
/**
 * Class Wall - A wall of a room in the game.
 * 
 * Walls may have exits, and the rooms which the exits connect to are stored in 
 * the wall class. Walls may also contain one item.
 * 
 * @author  Sophia Jones, based on code by Michael Kölling and David J. Barnes
 * @version 1
 */

public class Wall {
	
	private String imageName;
	private Room exit1;
	private Room exit2;
	private Items wallItem;
	
	/**
	 * Create a wall with the image of that wall. Initially a wall has no exits or 
	 * items.
	 * @param imageName The image that should be visible when facing the wall
	 */
	public Wall(String imageName) {
		this.imageName=imageName;
	}

	/**
	 * Fetch the image name of the wall
	 * @return The name of the image of the wall
	 */
	public String getImageName() {
        return imageName;
	}
	
	// Methods for the item on a wall
	
	/**
	 * Place an item onto a wall
	 * @param itemName The name of the item
	 */
	public void addWallItems(Items itemName) {
		wallItem = itemName;
	}
	
	/**
	 * Remove the item from the wall, first checking that the item was on the wall
	 * @param itemName The name of the item
	 */
	public void removeWallItem(Items itemName) {
		if (wallItem == itemName);
		wallItem = null;
	}
	
	/**
	 * If there is an item on the wall, return the item name. Else return null.
	 * @return the name of the item on the wall
	 */
	public Items getWallItems() {
		if (wallItem != null) {
			return wallItem;
		}
		else return null;
	}
	
	/**
	 * Fetch the image name of an item
	 * @param the item whose image name will be fetched
	 * @return image name 
	 */
	public String itemImageName(Items item) {
		return item.getItemName();
	}
	
	/**
	 * Determine whether there is an item on the wall
	 * @return True if there is an item on the wall, or false if the wall is empty
	 */
	public boolean wallItemsEmpty() {
		if (wallItem == null) {
			return true;
		}
		else return false;
	}
	
	
	// Methods for the exits on a wall
	
	/**
	 * Set up the first exit on the wall, linking the exit to a room
	 * @param exit1 The room that should be entered when the first exit is taken
	 */
	public void setExit1(Room exit1) {
		this.exit1 = exit1;
	}
	
	/**
	 * Set up the second exit on the wall, linking the exit to a room
	 * @param exit2 The room that should be entered when the second exit is taken
	 */
	public void setExit2(Room exit2) {
		this.exit2 = exit2;
	}
	
	/**
	 * If there is a room linked to exit 1, return the room. Else return null.
	 * @return The room linked to exit 1
	 */
	public Room getExit1() {
		if(exit1 != null) {
	        return exit1;
		}
		else return null;
	}
	
	/**
	 * If there is a room linked to exit 2, return the room. Else return null.
	 * @return The room linked to exit 2
	 */
	public Room getExit2() {
		if(exit2 != null) {
	        return exit2;
		}
		else return null;
	}
	
}
