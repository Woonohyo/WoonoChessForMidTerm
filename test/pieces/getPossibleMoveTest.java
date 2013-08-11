package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class getPossibleMoveTest extends TestCase {

	public void testEmpty() throws Exception {
		Position position = new Position("a1");
		PieceOperations empty = new Empty(Color.NOCOLOR, position);
		List<Position> emptyPossibleMove = empty.getPossibleMoves();
		assertEquals(0, emptyPossibleMove.size());
	}

	public void testRook() throws Exception {
		Position position = new Position("d3");
		PieceOperations rook = new Rook(Color.WHITE, position);
		List<Position> rookPossibleMove = rook.getPossibleMoves();
		assertEquals(14, rookPossibleMove.size());
	}

	public void testBishop() throws Exception {
		Position position = new Position("e4");
		PieceOperations bishop = new Bishop(Color.WHITE, position);
		List<Position> rookPossibleMove = bishop.getPossibleMoves();
		assertEquals(13, rookPossibleMove.size());
	}

	public void testQueen() throws Exception {
		Position position = new Position("f5");
		PieceOperations queen = new Queen(Color.WHITE, position);
		List<Position> queenPossibleMove = queen.getPossibleMoves();
		assertEquals(25, queenPossibleMove.size());
	}

	public void testKing() throws Exception {
		Position position1 = new Position("h8");
		Position position2 = new Position("d5");
		PieceOperations kingCorner = new King(Color.WHITE, position1);
		PieceOperations kingCenter = new King(Color.WHITE, position2);
		List<Position> kingPossibleMove1 = kingCorner.getPossibleMoves();
		List<Position> kingPossibleMove2 = kingCenter.getPossibleMoves();
		assertEquals(3, kingPossibleMove1.size()); // 구석에서 이동하므로 3
		assertEquals(8, kingPossibleMove2.size()); // 중앙에서 이동시 8
	}

	public void testPawn() throws Exception {
		Position position1 = new Position("h2");
		Position position2 = new Position("h3");
		Position position3 = new Position("h7");
		Position position4 = new Position("h6");

		PieceOperations whitePawn1 = new Pawn(Color.WHITE, position1);
		PieceOperations whitePawn2 = new Pawn(Color.WHITE, position2);
		PieceOperations blackPawn1 = new Pawn(Color.BLACK, position3);
		PieceOperations blackPawn2 = new Pawn(Color.BLACK, position4);

		List<Position> whitePawnMove1 = whitePawn1.getPossibleMoves();
		List<Position> whitePawnMove2 = whitePawn2.getPossibleMoves();
		List<Position> blackPawnMove1 = blackPawn1.getPossibleMoves();
		List<Position> blackPawnMove2 = blackPawn2.getPossibleMoves();

		assertEquals(2, whitePawnMove1.size());
		assertEquals(1, whitePawnMove2.size());
		assertEquals(2, blackPawnMove1.size());
		assertEquals(1, blackPawnMove2.size());
	}

	public void testKnight() throws Exception {
		Position position1 = new Position("d4");
		Position position2 = new Position("h8");
		PieceOperations whiteKnight = new Knight(Color.WHITE, position1);
		PieceOperations whiteKnight2 = new Knight(Color.WHITE, position2);

		List<Position> whiteKnightMove = whiteKnight.getPossibleMoves();
		List<Position> whiteKnightMove2 = whiteKnight2.getPossibleMoves();

		assertEquals(8, whiteKnightMove.size());
		assertEquals(2, whiteKnightMove2.size());
	}
}
