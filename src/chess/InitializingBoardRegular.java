package chess;

public class InitializingBoardRegular implements InitializingBoard {

	@Override
	public void initialize(Board board) {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i == 0) {
				rank.initializeWhiteExceptPawn();
			} else if (i == 1) {
				rank.initializeWhitePawn();
			} else if (i == 6) {
				rank.initializeBlackPawn();
			} else if (i == 7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			board.ranks.add(rank);
		}
	}
}
