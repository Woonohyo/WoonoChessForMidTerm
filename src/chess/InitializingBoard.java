package chess;

public interface InitializingBoard {
	
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;

	public abstract void initialize(Board board);
}