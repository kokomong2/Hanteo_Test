package org.example.category;

import org.example.board.BoardManager;

public class App {
	public static void main(String[] args) {
		CategoryTree tree = new CategoryTree();

		// 카테고리 등록
		tree.addCategory(1, "남자");
		tree.addCategory(2, "엑소");
		tree.addCategory(3, "방탄소년단");
		tree.addCategory(4, "여자");
		tree.addCategory(5, "블랙핑크");

		// 카테고리 관계 연결
		tree.addCategoryRelation(1, 2);
		tree.addCategoryRelation(1, 3);
		tree.addCategoryRelation(4, 5);

		// 게시판 추가 (엑소)
		tree.addBoardToCategory(2, BoardManager.createBoard("공지사항"));
		tree.addBoardToCategory(2, BoardManager.createBoard("첸"));
		tree.addBoardToCategory(2, BoardManager.createBoard("백현"));
		tree.addBoardToCategory(2, BoardManager.createBoard("시우민"));

		// 게시판 추가 (방탄소년단)
		tree.addBoardToCategory(3, BoardManager.createBoard("공지사항"));
		tree.addBoardToCategory(3, BoardManager.getAnonymousBoard());
		tree.addBoardToCategory(3, BoardManager.createBoard("뷔"));

		// 게시판 추가 (블랙핑크)
		tree.addBoardToCategory(5, BoardManager.createBoard("공지사항"));
		tree.addBoardToCategory(5, BoardManager.getAnonymousBoard());
		tree.addBoardToCategory(5, BoardManager.createBoard("로제"));

		// JSON 출력 테스트
		printCategoryTreeByName(tree, "여자");
		printCategoryTreeById(tree,1);
	}

	private static void printCategoryTreeByName(CategoryTree tree, String name) {
		System.out.println("=================================================");
		System.out.println("카테고리: " + name);
		tree.searchByName(name)
			.ifPresentOrElse(
				category -> System.out.println(tree.toJson(category)),
				() -> System.out.println("검색 결과가 없습니다.")
			);
	}

	private static void printCategoryTreeById(CategoryTree tree, int id) {
		System.out.println("=================================================");
		System.out.println("Id: " + id);
		tree.searchById(id)
			.ifPresentOrElse(
				category -> System.out.println(tree.toJson(category)),
				() -> System.out.println("검색 결과가 없습니다.")
			);
	}
}
