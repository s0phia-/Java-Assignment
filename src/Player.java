/**
 * The Player Class communicates with the World Controller and the other 
 * classes to feed information about the inventory, current wall, current
 * room current items and current direction of the player to the World 
 * Controller.
 * 
 * @author Sophia Jones
 * @version 1
 *
 */
public class Player {
	
	private Room currentRoom;
	private Direction currentDirection;
	private Wall currentWall;
	private Inventory myInventory = new Inventory();
	private Items currentWallItem;
	private Items currentInventoryItem;
	
	
	//Update the current direction

	/**
	 * Set the value of the current direction
	 * @param direction will become the current direction
	 */
	public void setCurrentDirection(Direction direction) {
		this.currentDirection = direction;
	}
	
	/**
	 * Update the current direction to the direction on the left
	 * @return the new current direction
	 */
	public Direction goLeft() {
		currentDirection = currentDirection.goLeft();
		return currentDirection;
	}
	
	/**
	 * Update the current direction to the direction on the right
	 * @return the new current direction
	 */
	public Direction goRight() {
		currentDirection = currentDirection.goRight();
		return currentDirection;
	}
	
	
	//Current Wall
	
	/**
	 * fetch the current wall
	 * @return the current wall
	 */
	public Wall getCurrentWall() {
		currentWall = currentRoom.getWall(currentDirection);
		return currentWall;
	}
		
	/**
	 * return the image name of the current wall
	 * @return the image name 
	 */
	public String getCurrentWallName() {
		return currentWall.getImageName();
	}
	
		
	//Wall Exits
	
	/**
	 * fetch the room that is stored in exit 1 of the current wall
	 * @return the room in exit 1
	 */
	public Room getExit1() {
		return currentWall.getExit1();
	}

	/**
	 * returm the room that is stored in exit 2 of the current wall
	 * @return the room in exit 2
	 */
	public Room getExit2() {
		return currentWall.getExit2();
	}
	
	
	//Update the current room
	
	/**
	 * Sets the value of the current room
	 * @param currentRoom the room that will become the current room
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	/**
	 * Update the room to the room stored in exit 1 of the current wall
	 * @return the new room
	 */
	public Room goExit1() {
		currentRoom = currentWall.getExit1();
		return currentRoom;
	}
	
	/**
	 * Update the room to the room stored in exit 2 of the current wall
	 * @return the new room
	 */
	public Room goExit2() {
		currentRoom = currentWall.getExit2();
		return currentRoom;
	}
	
	
	//Current Wall Item
	
	/**
	 * fetch the item currently on the wall
	 * @return the current wall item
	 */
	public Items getCurrentWallItem() {
		return currentWallItem;
	}
	
	/**
	 * Update the current wall item to be the item contained in the current 
	 * wall
	 */
	public void setCurrentWallItem() {
		
		if (currentWall.wallItemsEmpty()==false) {
			currentWallItem=currentWall.getWallItems();
		}
		//if the current wall does not have an item, the current wall item 
		//is null
		else {
			currentWallItem = null;
		}
	}

	/**
	 * fetch the image name of the item on the current wall
	 * @return the image name
	 */
	public String getCurrentWallItemName() {
		return currentWall.itemImageName(currentWallItem);
	}
	
	
	// Interactions with inventory
	
	/**
	 * Fetch the current inventory item
	 * @return the current inventory item
	 */
	public Items getCurrentInventoryItem() {
		return currentInventoryItem;
	}
	
	/**
	 * returm the image name of the current inventory item
	 * @return the image name 
	 */
	public String getCurrentInventoryItemName() {
		return myInventory.itemImageName(currentInventoryItem);
	}
	
	/**
	 * Update the current inventory item to the inventory item stored next 
	 * in the inventory
	 * @return the new current inventory item
	 */
	public Items goInvRight() {
		//check first that there is an inventory item stored in the 
		//inventory after the current one 
		if (invRight()==null) {
			return null;
		}
		else
			currentInventoryItem = invRight();
			return currentInventoryItem;
	}

	/**
	 * Update the current inventory item to the inventory item stored
	 * previous in the inventory
	 * @return the new current inventory item
	 */
	public Items goInvLeft() {
		//check first that there is an item stored previous in the inventory
		if (invLeft() == null) {
			return null;
		}
		else
			currentInventoryItem = invLeft();
			return currentInventoryItem;
	}
	
	/**
	 * fetch the item stored next in the inventory 
	 * @return the next item
	 */
	public Items invRight() {
		return myInventory.getNextItem(currentInventoryItem);
	}
	
	/**
	 * fetch the item stored previous in the inventory
	 * @return the previous item
	 */
	public Items invLeft() {
		return myInventory.getPrevItem(currentInventoryItem);
	}

	/**
	 * Determine whether the inventory is empty 
	 * @return true if empty, false otherwise
	 */
	public boolean myInventoryEmpty() {
		return myInventory.inventoryEmpty();
	}

	/**
	 * Place the item on the wall in the inventory, and make it the current 
	 * inventory item
	 */
	public void pickUpItem() {
		currentWall.removeWallItem(currentWallItem);
		myInventory.addInventoryItems(currentWallItem);
		currentInventoryItem = currentWallItem;
	}
	
	/**
	 * Place the current inventory item onto the wall. Update the current 
	 * inventory item to be the nearest inventory item
	 */
	public void dropOffItem() {
		currentWall.addWallItems(currentInventoryItem);
		myInventory.removeInventoryItem(currentInventoryItem);
		currentInventoryItem = myInventory.getNearest(currentInventoryItem);
	}


}
