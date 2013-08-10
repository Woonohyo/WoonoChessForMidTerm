package pieces;

import java.util.List;
import pieces.Piece.Color;

public interface PieceOperations {

	public abstract char getSymbol();

	public abstract PieceOperations leave();

	public abstract PieceOperations move(Position target) throws Exception;

	public abstract List<Position> getPossibleMoves();

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

	public abstract Position getPosition();

	public abstract Color getColor();

}