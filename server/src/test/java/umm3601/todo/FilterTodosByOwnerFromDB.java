package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.TodoDatabase filterTodosByOwner
 */
public class FilterTodosByOwnerFromDB {
  @Test
  public void filterTodosByOwner() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] ownerBlanche = db.filterTodosByOwner(allTodos, "Blanche");
    assertEquals("Incorrect number of entries with owner Blanche", 43, ownerBlanche.length);
  }
}
