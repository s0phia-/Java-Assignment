import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

/**
 * This is the main class of the "Virtual World" application, which lets
 * you move between rooms and rotate around them. 
 * 
 * This class creates and initialises the walls, rooms, items and exits. 
 * 
 * 
 * @author Sophia Jones, using code by Paul Anderson
 * @version 1
 *
 */
public class WorldController {
	
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView bag;
	@FXML
	private ImageView bagItem;
	@FXML
	private ImageView wallItem;

	@FXML
	private Button invRight;
	@FXML
	private Button invLeft;
	@FXML
	private MenuItem pickUpItem;
	@FXML
	private MenuItem dropOffItem;
	@FXML 
	private MenuItem exit1;
	@FXML
	private MenuItem exit2;
	
	private Room startRoom;
	private Direction startDirection;
	private Player player = new Player();
	
	/**
	 * Initialise the Virtual World and display an image according to 
	 * indicated start room and direction.
	 * create a picture of a bag to represent the inventory
	 * Update the interface with current settings
	 */
	public void Initialise() {
		build();
		player.setCurrentRoom(startRoom);
		player.setCurrentDirection(startDirection);
		Image bagImage = new Image("bag.png");
		bag.setImage(bagImage);
		updateMain();
		updateWallItem();
		updateInventory();
	}
	
	/**
	 * Create all the rooms, walls, items and exits
	 * 
	 */
	private void build() {
		
		//Create the rooms
		Room bedroom = new Room();
		Room hall = new Room();
		Room kitchen = new Room();
		Room lounge = new Room();
		
		//Create the walls
		Wall hallN = new Wall("hallN.jpg");
		Wall hallS = new Wall("hallS.jpg");
		Wall hallE = new Wall("hallE.jpg");
		Wall hallW = new Wall("hallW.jpg");
		
		Wall kitchenN = new Wall("kitchenN.jpg");
		Wall kitchenS = new Wall("kitchenS.jpg");
		Wall kitchenE = new Wall("kitchenE.jpg");
		Wall kitchenW = new Wall("kitchenW.jpg");
		
		Wall loungeN = new Wall("loungeN.jpg");
		Wall loungeS = new Wall("loungeS.jpg");
		Wall loungeE = new Wall("loungeE.jpg");
		Wall loungeW = new Wall("loungeW.jpg");
		
		Wall bedroomN = new Wall("bedroomN.jpg");
		Wall bedroomS = new Wall("bedroomS.jpg");
		Wall bedroomE = new Wall("bedroomE.jpg");
		Wall bedroomW = new Wall("bedroomW.jpg");
		
		//Indicate which direction the walls are on
		bedroom.setWalls(Direction.NORTH, bedroomN);
		bedroom.setWalls(Direction.SOUTH, bedroomS);
		bedroom.setWalls(Direction.EAST, bedroomE);
		bedroom.setWalls(Direction.WEST, bedroomW);
		
		kitchen.setWalls(Direction.NORTH, kitchenN);
		kitchen.setWalls(Direction.SOUTH, kitchenS);
		kitchen.setWalls(Direction.EAST, kitchenE);
		kitchen.setWalls(Direction.WEST, kitchenW);
		
		lounge.setWalls(Direction.NORTH, loungeN);
		lounge.setWalls(Direction.SOUTH, loungeS);
		lounge.setWalls(Direction.EAST, loungeE);
		lounge.setWalls(Direction.WEST, loungeW);
		
		hall.setWalls(Direction.NORTH, hallN);
		hall.setWalls(Direction.SOUTH, hallS);
		hall.setWalls(Direction.EAST, hallE);
		hall.setWalls(Direction.WEST, hallW);
		
		//Create items
		Items book = new Items("book.png");
		Items cake = new Items("cake.png");
		
		//Put items on walls
		loungeN.addWallItems(cake);
		bedroomW.addWallItems(book);
		
		//Create exits on walls, and set which room they lead to
		hallN.setExit1(kitchen);
		hallE.setExit1(lounge);
		hallE.setExit2(bedroom);
		bedroomW.setExit1(hall);
		loungeW.setExit1(hall);
		kitchenS.setExit1(hall);
		
		//Indicate where the game should start
		startRoom=lounge;
		startDirection = Direction.NORTH;
	}
	
	
	//Establish which action should happen when buttons or menu items are pressed
	/**
	 * Shift the current direction to the direction on the right and update the
	 * interface accordingly
	 * 
	 * @param event the right button is pressed
	 */
	public void goRight(ActionEvent event) {
		player.goRight();
		updateMain();
		updateWallItem();
	}
	
	/**
	 * Shift the current direction to the direction on the left and update the 
	 * interface accordingly
	 * 
	 * @param event the left button is pressed
	 */
	public void goLeft(ActionEvent event) {
		player.goLeft();
		updateMain();
		updateWallItem();
	}
	
	/**
	 * Change rooms to the room associated with the exit 1 on that wall, and update the 
	 * interface accordingly.
	 * 
	 * @param event The exit 1 menu item is selected
	 */
	public void goExit1(ActionEvent event) {
		player.goExit1();
		updateMain();
		updateWallItem();
	}
	
	/**
	 * Change rooms to the room associated with the exit 1 on that wall, and update the 
	 * interface accordingly.
	 * 
	 * @param event The exit 1 menu item is selected
	 */
	public void goExit2(ActionEvent event) {
		player.goExit2();
		updateMain();
		updateWallItem();
	}
	
	/** 
	 * Switch the current inventory item to the next item in my inventory
	 * @param event the right arrow in the inventory is pressed
	 */
	public void invRight(ActionEvent event) {
		player.goInvRight();
		updateInventory();
	}
	
	/**
	 * Switch the current inventory item to the previous item in my inventory
	 * @param event the left arrow in the inventoy is pressed
	 */
	public void invLeft(ActionEvent event) {
		player.goInvLeft();
		updateInventory();
	}

	/**
	 * Pick up the item that was placed in the current room, and move it into 
	 * my inventory
	 * @param event "Pick up item" in the menu is pressed
	 */
	public void pickUpItem(ActionEvent event) {
		player.pickUpItem();
		updateWallItem();
		updateInventory();
	}
	
	/**
	 * Drop an item from the inventory and place it in the current room.
	 * The current inventory item becomes the nearest item in my inventory,
	 * if one exists.
	 * @param event "Drop off Item" in the menu is pressed
	 */
	public void dropOffItem(ActionEvent event) {
		player.dropOffItem();
		updateWallItem();
		updateInventory();
	}
	
	
	// Update the interface to reflect changes caused by actions
	/**
	 * Update the main interface, which includes the main picture and the right, left, and 
	 * forward buttons, to reflect any actions
	 */
	private void updateMain() {
		player.getCurrentWall();
		setImage();
		checkExit1Valid();
		checkExit2Valid();
	}
	
	/**
	 * Update any items on a wall, and the item menu
	 */
	private void updateWallItem() {
		player.setCurrentWallItem();
		checkPickUpValid();
		checkDropOffValid();
		setWallItemImage();
	}
	
	/**
	 * Update the inventory display and the buttons to move through the inventory
	 */
	private void updateInventory() {
		checkInvLeftValid();
		checkInvRightValid();
		setBagImage();
	}

	
	// Check that the actions are valid	
	/**
	 * Enable the right inventory button if and only if there is an item in the inventory
	 * after the current one
	 */
	private void checkInvRightValid() {
		if (player.invRight()==null) {
				invRight.setDisable(true);
			}
		else invRight.setDisable(false);
	}
	
	/**
	 * Enable the left inventory button if and only if there is an item in the inventory
	 * before the current one
	 */
	private void checkInvLeftValid() {
		//if (player.inventoryLeft()==null) {
		if (player.invLeft()== null) {
			invLeft.setDisable(true);
		}
	else invLeft.setDisable(false);
	}
	
	/**
	 * Enable the pick up menu item if and only if there is an item on the wall
	 */
	private void checkPickUpValid() {
		if (player.getCurrentWallItem() == null) {
			pickUpItem.setDisable(true);
		}
		else pickUpItem.setDisable(false);
	}

	/**
	 * Enable the drop off menu item if and only if the room has no items and there is an 
	 * item in the inventory
	 */
	private void checkDropOffValid() {
		if (player.myInventoryEmpty() == true || player.getCurrentWallItem() != null) {
			dropOffItem.setDisable(true);
		}
		else dropOffItem.setDisable(false);
	}
	
	/**
	 *For the current wall,enable the exit 1 menu item if and only if exit 1 is initialised
	 */
	private void checkExit1Valid() {
		if (player.getExit1()==null) {
			exit1.setDisable(true);
		}
		else exit1.setDisable(false);
	}
	
	/**
	 *For the current wall,enable the exit 1 menu item if and only if exit 1 is initialised
	 */
	private void checkExit2Valid() {
		if (player.getExit2()==null) {
			exit2.setDisable(true);
		}
		else exit2.setDisable(false);
	}
	
	//Put the correct image into the image viewers
	/**
	 * If there is an item on the current wall, display its image in the viewer
	 */
	private void setWallItemImage() {
		if (player.getCurrentWallItem() != null) {
			Image item = new Image(player.getCurrentWallItemName(),64,64,false,false);
			wallItem.setImage(item);
		}
		else {
			wallItem.setImage(null);
		}
	}

	/**
	 * If there is a current inventory item, display its image in the viewer.
	 */
	private void setBagImage() {
		if (player.myInventoryEmpty()==false) {
		Image myItem = new Image(player.getCurrentInventoryItemName(),64,64,false,false);
			bagItem.setImage(myItem);
		}
		else {
			bagItem.setImage(null);
		}
	}
	
	/**
	 * For the current room and direction, fetch the wall located there,
	 * and show the image associated with that wall on the screen. 
	 */
	private void setImage() {
		Image current = new Image(player.getCurrentWallName(),512,384,false,false);
		imageView.setImage(current);
	}
	
}