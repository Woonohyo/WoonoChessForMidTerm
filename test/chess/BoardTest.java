package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece.Color;
import pieces.PieceOperations;
import pieces.Position;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + GeneratingBoard.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + GeneratingBoard.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + GeneratingBoard.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + GeneratingBoard.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + GeneratingBoard.NEW_LINE;
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		System.out.println(board.generateBoard());
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		PieceOperations sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}
	
	public void testSameColorAttack() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("b2");
		
		board.movePiece(source, target);
		assertEquals(new Pawn(Color.WHITE, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
	}
	
	public void testImpossibleMove() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("d5");
		
		board.movePiece(source, target);
		assertEquals(new Pawn(Color.WHITE, source), board.findPiece(source));
		assertEquals(new Empty(Color.NOCOLOR, target), board.findPiece(target));;
	}
	
	public void testPrintUsingInterface() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + GeneratingBoard.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + GeneratingBoard.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + GeneratingBoard.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + GeneratingBoard.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
		
		//웹페이지로 출력하기 위한 메소드 호
		board.setGenerateBoard(new GeneratingBoardForWeb());
		assertEquals("이 메세지가 보인다면 웹 페이지용으로 출력이 가능한 상태입니다.", board.generateBoard());
		System.out.println(board.generateBoard());
	}
}
