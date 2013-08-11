package pieces;

import java.util.List;

public class Empty extends Piece {
	public Empty(Color color, Position position) {
		super(color, Type.EMPTY, position);
	}

	// 일단 다른 기물들과 똑같은 방식으로 구현을 합니다
	// Direction 클래스에 아무 방향도 들어있지 않은 emptyDirection이라는 배열을 생성하여 최종적으로 반환하는 배열의
	// 사이즈가 0이 됩니다.

	@Override
	public List<Position> getPossibleMoves() {
		PositionController possibleMoves = new PositionController(
				super.getPosition());

		return possibleMoves.setEmpty();
	}
}
