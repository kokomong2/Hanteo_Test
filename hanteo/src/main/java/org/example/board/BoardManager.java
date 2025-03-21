package org.example.board;

public class BoardManager {
	private static int anonymousBoardId = 0;
	private static int nextBoardId = 1;
	private static Board anonymousBoard = null;
	private static final String ANONYMOUS_BOARD_NAME = "익명게시판";

	public static Board createBoard(String name) {
		skipAnonymousBoardId();
		return new Board(nextBoardId++, name);
	}

	public static Board getAnonymousBoard() {
		if (anonymousBoard == null) {
			anonymousBoardId = nextBoardId++;
			anonymousBoard = new Board(anonymousBoardId, ANONYMOUS_BOARD_NAME);
		}
		return anonymousBoard;
	}

	public static int getAnonymousBoardId() {
		return anonymousBoardId;
	}

	private static void skipAnonymousBoardId() {
		if (anonymousBoardId != 0 && nextBoardId == anonymousBoardId) {
			nextBoardId++;
		}
	}
}
