import java.util.HashMap;

/**
 * Room class - A room in the game.
 * Rooms contain walls, which are associated with a direction
 * 
 * @author Sophia Jones
 * @version 1
 *
 */
public class Room {
	private HashMap<Direction, Wall> room; 
	
	/**
	 * Create a room and initialise a hashmap which contains a wall and the
	 * direction of the wall
	 */
	public Room() {
		room = new HashMap<>();
	}
	
	/**
	 * Add a wall and an associated direction into the room hashmap
	 * @param direction The direction the wall should be put 
	 * @param wall The wall to be placed into the room hashmap
	 */
	public void setWalls(Direction direction, Wall wall) {
		room.put(direction, wall);
	}
	
	/**
	 * Given a direction, retrieve the wall associated with it in the 
	 * room hashmap
	 * @param direction the direction 
	 * @return the wall associated with the direction
	 */
	public Wall getWall(Direction direction) {
		return room.get(direction);
	}
		
}
