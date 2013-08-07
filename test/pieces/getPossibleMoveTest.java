package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class getPossibleMoveTest extends TestCase {
	
	public void testEmpty() throws Exception {
		Position position = new Position("a0");
		Piece empty = new Empty(Color.NOCOLOR, position);
		List<Position> emptyPossibleMove = empty.getPossibleMoves();
		assertEquals(0, emptyPossibleMove.size());
		
	}
	
	public void testRook() throws Exception {
		Position position = new Position("d3");
		Piece rook = new Rook(Color.WHITE, position);
		List<Position> rookPossibleMove = rook.getPossibleMoves();
		assertEquals(14, rookPossibleMove.size());
	}
	
	public void testBishop() throws Exception {
		Position position = new Position("e4");
		Piece bishop = new Bishop(Color.WHITE, position);
		List<Position> rookPossibleMove = bishop.getPossibleMoves();
		assertEquals(13, rookPossibleMove.size());
		
	}

}
