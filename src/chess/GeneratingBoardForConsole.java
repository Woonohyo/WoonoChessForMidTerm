package chess;

import java.util.ArrayList;
import java.util.List;

public class GeneratingBoardForConsole implements GeneratingBoard{
	List<Rank> ranks = new ArrayList<Rank>();
	
	public String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

	@Override
	public String generateBoard(List<Rank> ranks) {
		this.ranks = ranks;
		StringBuilder sb = new StringBuilder();
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(i - 1) + NEW_LINE);
		}
		return sb.toString();
	}

}
