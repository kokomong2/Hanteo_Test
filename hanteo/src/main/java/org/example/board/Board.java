package org.example.board;

public class Board {
	private final int id;
	private String name;

	public Board(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void changeName(String name) {
		this.name = name;
	}
}
