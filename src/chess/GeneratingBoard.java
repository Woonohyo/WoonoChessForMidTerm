package chess;

import java.util.List;

public interface GeneratingBoard {

	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	
	public String generateBoard(Board board, List<Rank> ranks);
	String generateRank(Board board, int rankIndex);
}