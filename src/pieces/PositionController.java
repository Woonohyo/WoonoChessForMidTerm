package pieces;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
	private Position position;

	public PositionController(Position position) {
		this.position = position;
	}
	
	public List<Position> setEmpty() {
		Direction[] empty = Direction.emptyDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : empty) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

	public List<Position> findsLinearPositionAll() {
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

	public List<Position> findsDiagonalPositionAll() {
		Direction[] diagonals = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : diagonals) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}
	
	// 퀸이 이동할 수 있는 방향을 구하 메소드입니다.
	// 모든 방향이 담긴 Direction 배열을 가져와서 이동할 수 있는 위치를 모두 구합니다.
	public List<Position> findsAllPositionAll() {
		Direction[] all = Direction.allDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : all) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

}
