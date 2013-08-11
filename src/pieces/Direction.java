package pieces;

public enum Direction {
	NORTH(0, 1), 
	NORTHEAST(1, 1), 
	EAST(1, 0), 
	SOUTHEAST(1, -1), 
	SOUTH(0, -1), 
	SOUTHWEST(-1, -1), 
	WEST(-1, 0), 
	NORTHWEST(-1, 1);

	private int xDegree;
	private int yDegree;

	private Direction(int xDegree, int yDegree) {
		this.xDegree = xDegree;
		this.yDegree = yDegree;
	}

	public int getXDegree() {
		return xDegree;
	}

	public int getYDegree() {
		return yDegree;
	}

	public static Direction[] linearDirection() {
		return new Direction[] { NORTH, EAST, SOUTH, WEST };
	}

	public static Direction[] diagonalDirection() {
		return new Direction[] { NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST };
	}

	// Empty를 위한 아무 방향도 담기지 않은 배열.
	public static Direction[] emptyDirection() {
		return new Direction[] {};
	}

	// Queen을 위한 모든 방향이 담긴 배열.
	public static Direction[] allDirection() {
		return new Direction[] { NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH,
				SOUTHWEST, WEST, NORTHWEST };
	}

	public static Direction[] northDirection() {
		return new Direction[] { NORTH };
	}

	public static Direction[] southDirection() {
		return new Direction[] { SOUTH };
	}

}
