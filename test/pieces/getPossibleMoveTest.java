package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class getPossibleMoveTest extends TestCase {
	
	public void testEmpty() throws Exception {
		Position position = new Position("a1");
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
	
	public void testQueen() throws Exception {
		Position position = new Position("f5");
		Piece queen = new Queen(Color.WHITE, position);
		List<Position> queenPossibleMove = queen.getPossibleMoves();
		assertEquals(25, queenPossibleMove.size());
	}
	
	public void testKing() throws Exception {
		Position position1 = new Position("h8");
		Position position2 = new Position("d5");
		Piece kingCorner = new King(Color.WHITE, position1);
		Piece kingCenter = new King(Color.WHITE, position2);
		List<Position> kingPossibleMove1 = kingCorner.getPossibleMoves();
		List<Position> kingPossibleMove2 = kingCenter.getPossibleMoves();
		assertEquals(3, kingPossibleMove1.size()); // 구석에서 이동하므로 3
		assertEquals(8, kingPossibleMove2.size()); // 중앙에서 이동시 8
	}
}
