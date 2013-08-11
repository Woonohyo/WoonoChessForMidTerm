package pieces;

import java.util.List;

public class Pawn extends Piece{
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController possibleMoves = new PositionController(super.getPosition());

		if (this.getPosition().getY() == 1 && this.isWhite())
			return possibleMoves.findsNorthPositionTwice();
		else if (this.isWhite())
			return possibleMoves.findsNorthPositionOnce();
		else if (this.getPosition().getY() == 6 && this.isBlack())
			return possibleMoves.findsSouthPositionTwice();
		else
			return possibleMoves.findsSouthPositionOnce();
	}
}
