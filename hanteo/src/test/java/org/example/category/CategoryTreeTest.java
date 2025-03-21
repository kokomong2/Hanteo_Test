package org.example.category;

import org.example.board.Board;
import org.example.board.BoardManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTreeTest {

	private CategoryTree tree;

	@BeforeEach
	void setUp() {
		tree = new CategoryTree();
		tree.addCategory(1, "남자");
		tree.addCategory(2, "엑소");
		tree.addCategory(3, "여자");
	}

	@Test
	void 카테고리_등록_및_조회_성공() {
		Optional<Category> found = tree.searchById(1);
		assertTrue(found.isPresent());
		assertEquals("남자", found.get().getName());
	}

	@Test
	void 카테고리_등록되지_않은_ID_조회_실패() {
		Optional<Category> found = tree.searchById(99);
		assertFalse(found.isPresent());
	}

	@Test
	void 카테고리_관계_연결_및_하위카테고리_확인() {
		tree.addCategoryRelation(1, 2);
		Optional<Category> parent = tree.searchById(1);

		assertTrue(parent.isPresent());
		assertEquals(1, parent.get().getSubCategories().size());
		assertEquals("엑소", parent.get().getSubCategories().get(0).getName());
	}

	@Test
	void 게시판_추가_성공() {
		Board board = BoardManager.createBoard("공지사항");
		tree.addBoardToCategory(1, board);

		Optional<Category> found = tree.searchById(1);
		assertTrue(found.isPresent());
		assertEquals(1, found.get().getBoards().size());
		assertEquals("공지사항", found.get().getBoards().get(0).getName());
	}

	@Test
	void 익명게시판_싱글턴_동작_테스트() {
		Board anonymousBoard1 = BoardManager.getAnonymousBoard();
		Board anonymousBoard2 = BoardManager.getAnonymousBoard();

		assertSame(anonymousBoard1, anonymousBoard2);
		assertEquals("익명게시판", anonymousBoard1.getName());
	}

	@Test
	void 익명게시판_ID_중복_방지_테스트() {
		BoardManager.getAnonymousBoard();
		Board normalBoard = BoardManager.createBoard("일반게시판");

		assertNotEquals(BoardManager.getAnonymousBoard().getId(), normalBoard.getId());
	}
}
