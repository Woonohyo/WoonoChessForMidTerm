package pieces;

import java.util.ArrayList;
import java.util.List;

import chess.GeneratingBoard;

public class Position {
	private static final char COLUMN_START_CHAR = 'a';

	private int x;
	private int y;

	public Position(String position) {
		// 에러 상태에 대한 처리 필요함.
		this.x = generateColumnIndex(position.charAt(0));
		this.y = Integer.parseInt(position.substring(1)) - 1;
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int generateColumnIndex(char columnIndex) {
		int target = Character.getNumericValue(columnIndex);
		int source = Character.getNumericValue(COLUMN_START_CHAR);
		return target - source;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	Position move(Direction direction) {
		return new Position(this.x + direction.getXDegree(), this.y
				+ direction.getYDegree());
	}

	List<Position> findsPosition(Direction direction) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		while (currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.move(direction);
		}
		return positions;
	}

	// 1칸만 이동할 수 있는 기물에게 필요한 메소드입니다.
	List<Position> findsPositionOnce(Direction direction) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		if (currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.move(direction);
		}
		return positions;
	}

	// 2칸만 이동할 경우에 필요한 메소드입니다.
	List<Position> findsPositionTwice(Direction direction) {
		int i = 0;
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		while (currentPosition.isValid() && i < 2) {
			positions.add(currentPosition);
			currentPosition = currentPosition.move(direction);
			i++;
		}
		return positions;
	}

	// 나이트의 이동을 구현하기 위해 필요한 메소드입니다.
	List<Position> findsPositionKnight(Direction via, Direction move) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(via);
		currentPosition = currentPosition.move(move);
		if (currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.move(move);
		}
		return positions;
	}

	boolean isValid() {
		if (y < 0 || y >= GeneratingBoard.ROW_SIZE) {
			return false;
		}

		if (x < 0 || x >= GeneratingBoard.COLUMN_SIZE) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

}
