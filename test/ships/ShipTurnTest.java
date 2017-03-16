package ships;

import static org.junit.Assert.*;

import org.junit.Test;

import directions.CannotTurnException;
import directions.Direction;

public class ShipTurnTest {

	@Test
	public void properTurn() {
		AbstractShip ship = new SmallShip(Faction.PIRATES);
		ship.face=Direction.NORTH;
		try {
			ship.turn(Direction.EAST);
		} catch (Exception e) {
			fail();
		}
		assertEquals(ship.face,Direction.EAST);
	}
	
	@Test(expected = CannotTurnException.class)
	public void illegalTurn() throws CannotTurnException{
		AbstractShip ship = new SmallShip(Faction.PIRATES);
		ship.face=Direction.NORTH;
		ship.turn(Direction.NORTH);
	}
	
	

}
