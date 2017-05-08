package ca.ubc.cpsc210.todo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Manages the to-do item list. Handles searches, additions and edits
 */
public class TodoList {

	private ArrayList<TodoItem> todoItems;

	// Constructs TodoList by initializing fields. Creates a new list if todoItems.
	public TodoList() {
		todoItems = new ArrayList<TodoItem>();
	}

	// MODIFIES: this
	// EFFECTS: a new todoItem is created and added to the to-do list
	public void addTodoItem(String title, String description, Date dueDate) {
		TodoItem TI1 = new TodoItem(title, description, dueDate);
		this.todoItems.add(TI1);
	}

	// EFFECTS: returns the to-do list
	public List<TodoItem> getAllTodoItems() {
		return this.todoItems;
	}

	// REQUIRES: index is a non-negative integer that is less than the number of
	// to-do items
	// EFFECTS: returns the to-do item at the specified position
	public TodoItem getTodoItemByIndex(int index) {
		TodoItem TI1 = todoItems.get(index);
		return TI1;
	}

	// EFFECTS: returns the to-do item with the specified id or null
	// if no item with that id exists
	public TodoItem getTodoItemById(String idOfItemToFind) {
		for (TodoItem i: this.todoItems){
			if (i.getId().equals(idOfItemToFind)) {
				return i;
			}
		}
		return null;
	}

	// REQUIRES: idToFind is an id for an item in the to-do list
	// MODIFIES: this
	// EFFECTS: updates the to-do item with the specified id in the to-do list
	public void updateTodoItem(String idToFind, String title,
			String description, Date dueDate) {
		TodoItem I = this.getTodoItemById(idToFind);
		I.setTitle(title);
		I.setDescription(description);
		I.setDueDate(dueDate);


	}

	// EFFECTS: returns a list of incomplete to-do items
	public List<TodoItem> filterTodoItemsByIncompletion() {
		List<TodoItem> IncompleteList = new ArrayList<TodoItem>();
		for (TodoItem i: this.todoItems){
			if (!i.isCompleted()){
				IncompleteList.add(i);
			}
		}
		return IncompleteList;
	}

	// EFFECTS: returns a list of to-do items whose title and/or description
	// contains the search parameter
	// Note: String comparisons are case sensitive
	public List<TodoItem> filterTodoItemsBySearchTerm(String searchString) {
		String search = searchString.toLowerCase();
		List<TodoItem> searchResult = new ArrayList<TodoItem>();
		for (TodoItem i: this.todoItems) {
			if(i.getTitle().toLowerCase().contains(search) || i.getDescription().toLowerCase().contains(search)) {
				searchResult.add(i);
			}

		}
		return searchResult;
	}
}
