package pieces;

import junit.framework.TestCase;

public class PositionTest extends TestCase {
	public void testCreate() throws Exception {
		Position position = new Position("a8");
		assertEquals(0, position.getX());
		assertEquals(7, position.getY());

		position = new Position("e2");
		assertEquals(4, position.getX());
		assertEquals(1, position.getY());
	}
}
