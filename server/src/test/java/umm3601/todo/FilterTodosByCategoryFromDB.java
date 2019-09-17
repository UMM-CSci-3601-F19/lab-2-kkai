package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.TodoDatabase filterTodosByCategory
 */

public class FilterTodosByCategoryFromDB {
  @Test
  public void filterTodosByCategory() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] cateHomework = db.filterTodosByCategory(allTodos, "homework");
    assertEquals("Incorrect number of entries with category homework", 79, cateHomework.length);
  }
}
