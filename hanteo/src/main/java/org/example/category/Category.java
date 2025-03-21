package org.example.category;

import java.util.ArrayList;
import java.util.List;

import org.example.board.Board;

public class Category {
	private final int id;
	private String name;
	private final List<Category> subCategories;
	private final List<Board> boards;

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
		this.subCategories = new ArrayList<>();
		this.boards = new ArrayList<>();
	}

	public void addSubCategory(Category category) {
		this.subCategories.add(category);
	}

	public void addBoard(Board board) {
		this.boards.add(board);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void changeName(String name) {
		this.name = name;
	}
}
