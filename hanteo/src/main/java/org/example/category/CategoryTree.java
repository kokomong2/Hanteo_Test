package org.example.category;

import java.util.*;

import org.example.board.Board;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CategoryTree {
	private final Map<Integer, Category> categories = new HashMap<>();
	private final ObjectMapper objectMapper = new ObjectMapper();

	public void addCategory(int id, String name) {
		if (!categories.containsKey(id)) {
			categories.put(id, new Category(id, name));
		}
	}

	public void addCategoryRelation(int parentId, int childId) {
		Category parent = categories.get(parentId);
		Category child = categories.get(childId);

		if (parent != null && child != null) {
			parent.addSubCategory(child);
		}
	}

	public void addBoardToCategory(int categoryId, Board board) {
		Category category = categories.get(categoryId);
		if (category != null) {
			category.addBoard(board);
		}
	}

	public Optional<Category> searchById(int id) {
		return Optional.ofNullable(categories.get(id));
	}

	public Optional<Category> searchByName(String name) {
		return categories.values()
			.stream()
			.filter(category -> category.getName().equals(name))
			.findFirst();
	}

	public String toJson(Category category) {
		try {
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(category);
		} catch (Exception e) {
			return "{}";
		}
	}
}
