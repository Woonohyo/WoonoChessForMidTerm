package pieces;

import java.util.List;
import pieces.PositionController;

public class Rook extends Piece{
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController possibleMoves = new PositionController(
				super.getPosition());

		return possibleMoves.findsLinearPositionAll();
	}
}
