package chess;

import java.util.List;

public class GeneratingBoardForConsole implements GeneratingBoard{
	public String generateRank(Board board, int rankIndex) {
		Rank rank = board.ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

	@Override
	public String generateBoard(Board board, List<Rank> ranks) {
		StringBuilder sb = new StringBuilder();
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(board, i - 1) + NEW_LINE);
		}
		return sb.toString();
	}
}
