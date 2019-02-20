/**
 * The directions Enum holds the possible directions walls can be placed 
 * in, and information about how they can be rotated through.
 * 
 * @author Sophia Jones, based on code by  Ryan Seys, Vinayak Bansal, Jarred Linthorne-Shaw
 *
 *@version 1
 *
 */
public enum Direction {
 //All directions possible
 NORTH, EAST, SOUTH, WEST;

/**
 	* Associates a direction with the direction to the right 
 * @return The direction to the right 
 */
	public Direction goRight() {
		//Place East right of North
		if (equals(Direction.NORTH)) {
    			return Direction.EAST;
		}
		//Place South right of East
		else if (equals(Direction.EAST)) {
    			return Direction.SOUTH;
		}
		//Place West right of South
		else if (equals(Direction.SOUTH)) {
			return Direction.WEST;
		}
		//Place North right of West
		else if (equals(Direction.WEST)) {
    			return Direction.NORTH;
		}
		else return null;
	}

	/**
	* Associates a direction with the direction to the left
	* @return The direction to the left
	*/
  	public Direction goLeft() {
  		//Place West left of North
  		if (equals(Direction.NORTH)) {
  			return Direction.WEST;
  		}
  		//Place North left of East
  		else if (equals(Direction.EAST)) {
  			return Direction.NORTH;
  		}
  		//Place East left of South
  		else if (equals(Direction.SOUTH)) {
  			return Direction.EAST;
  		}
  		//Place South left of West
  		else if (equals(Direction.WEST)) {
  			return Direction.SOUTH;
  		}
  		else return null;
  	}
}
