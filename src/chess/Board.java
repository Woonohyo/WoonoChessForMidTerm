package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.PieceOperations;
import pieces.Position;

public class Board {
	List<Rank> ranks = new ArrayList<Rank>();

	private InitializingBoard initializeBoard = new InitializingBoardRegular();
	private GeneratingBoard generateBoard = new GeneratingBoardForConsole();
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;

	Board() {
	}

	public void initialize() {
		initializeBoard.initialize(this);
	}

	public void setInitialize(InitializingBoard mode) {
		this.initializeBoard = mode;
	}

	PieceOperations findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	PieceOperations findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) throws Exception {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) throws Exception {
		try {
			isColorSame(source, target);
			isPossibleMove(source, target);
		} catch (SameColorTargetException e) {
			System.out.println(e.getMessage());
			return;
		} catch (ImpossibleMoveException e) {
			System.out.println(e.getMessage());
			return;
		}

		PieceOperations targetPiece = findPiece(source);
		PieceOperations sourcePiece = targetPiece.leave();

		Rank sourceRank = ranks.get(source.getY());
		sourceRank.move(sourcePiece, source);

		Rank targetRank = ranks.get(target.getY());
		targetRank.move(targetPiece, target);
	}

	private void isPossibleMove(Position source, Position target)
			throws Exception, ImpossibleMoveException {
		PieceOperations sourcePiece = findPiece(source);
		List<Position> possibleMoves = sourcePiece.getPossibleMoves();

		if (!(possibleMoves.contains(target)))
			throw new ImpossibleMoveException("해당 기물은 목표 위치로 이동할 수 없습니다.");
	}

	private void isColorSame(Position source, Position target)
			throws Exception, SameColorTargetException {
		PieceOperations targetPiece = findPiece(target);
		PieceOperations sourcePiece = findPiece(source);

		if (targetPiece.getColor() == sourcePiece.getColor())
			throw new SameColorTargetException("이동하려는 위치에 같은 편 말이 존재합니다.");
	}

	String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

	void setGenerateBoard(GeneratingBoard generateType) {
		this.generateBoard = generateType;
	}

	public String generateBoard() {
		return generateBoard.generateBoard(this, ranks);
	}
}
