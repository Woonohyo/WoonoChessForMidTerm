package chess;

public class InitializingBoardEmpty implements InitializingBoard {

	@Override
	public void initialize(Board board) {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			board.ranks.add(rank);
		}
	}
}
