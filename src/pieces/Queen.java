package pieces;

import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController possibleMoves = new PositionController(super.getPosition());
		
		return possibleMoves.findsAllPositionAll();
	}
}
