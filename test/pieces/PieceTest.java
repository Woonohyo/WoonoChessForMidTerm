package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testIsWhite() throws Exception {
		Piece whitePawn = new Pawn(Color.WHITE, null);
		assertTrue(whitePawn.isWhite());
	}

	public void testIsBlack() throws Exception {
		Piece blackPawn = new Pawn(Color.BLACK, null);
		assertTrue(blackPawn.isBlack());
	}

	public void testMove() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		PieceOperations whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));
	}

	public void testLeave() throws Exception {
		Position source = new Position("a1");
		PieceOperations whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Empty(Color.NOCOLOR, source), whitePawn.leave());
	}

	public void testEmptyMove() throws Exception {
		Position source = new Position("d4");
		Position target = new Position("d5");
		PieceOperations emptyChessman = new Empty(Color.NOCOLOR, source);
		assertEquals(new Empty(Color.NOCOLOR, source), emptyChessman.move(target)); // move 메소드를 사용했음에도 불구하고, 이동하지
																					// 못했으므로 원래 위치와 비교했을 때 equal이 뜸.
	}

	public void testInvalidMove() throws Exception {
		Position source = new Position("d4");
		Position invalidTarget1 = new Position("i4");
		Position invalidTarget2 = new Position("d9");
		Position invalidTarget3 = new Position("i9");

		PieceOperations testQueen = new Queen(Color.WHITE, source);
		assertEquals(testQueen, testQueen.move(invalidTarget1));
		assertEquals(testQueen, testQueen.move(invalidTarget2));
		assertEquals(testQueen, testQueen.move(invalidTarget3));
	}
}
