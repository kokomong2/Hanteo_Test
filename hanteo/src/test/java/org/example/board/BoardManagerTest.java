package org.example.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardManagerTest {

	@Test
	void 일반게시판_생성시_ID_자동증가_확인() {
		Board board1 = BoardManager.createBoard("공지사항");
		Board board2 = BoardManager.createBoard("첸");

		assertEquals(board1.getId() + 1, board2.getId());
	}

	@Test
	void 익명게시판_싱글턴_테스트() {
		Board anon1 = BoardManager.getAnonymousBoard();
		Board anon2 = BoardManager.getAnonymousBoard();

		assertSame(anon1, anon2);
	}

	@Test
	void 익명게시판_ID와_일반게시판_ID_충돌_방지() {
		Board anon = BoardManager.getAnonymousBoard();
		Board normal = BoardManager.createBoard("일반게시판");

		assertNotEquals(anon.getId(), normal.getId());
	}
}
