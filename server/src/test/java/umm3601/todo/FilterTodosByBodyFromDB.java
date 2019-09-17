package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.TodoDatabase filterTodosByBody
 */
public class FilterTodosByBodyFromDB {
  @Test
  public void filterTodosByBody() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] bodyString = db.filterTodosByBody(allTodos, "Excepteur nulla fugiat sit aliquip sunt.");
    assertEquals("Incorrect one filter by body", "Blanche", bodyString[0].owner);
  }
}
