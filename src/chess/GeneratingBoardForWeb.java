package chess;

import java.util.List;

public class GeneratingBoardForWeb implements GeneratingBoard {

	@Override
	public String generateBoard(List<Rank> ranks) {
		return "이 메세지가 보인다면 웹 페이지용으로 출력이 가능한 상태입니다.";
	}

	@Override
	public String generateRank(int rankIndex) {
		return null;
	}

}
