package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.TodoDatabase filterTodosByStatus
 */
public class FilterTodosByStatusFromDB {
  @Test
  public void filterTodosByStatus() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodo = db.listTodos(new HashMap<>());
    Todo[] statusTrue = db.filterTodosByStatus(allTodo, "complete");
    assertEquals("Incorrect # of entries", 143, statusTrue.length);
    Todo[] statusFalse = db.filterTodosByStatus(allTodo, "incomplete");
    assertEquals("Incorrect # of entries", 157, statusFalse.length);
  }
}
