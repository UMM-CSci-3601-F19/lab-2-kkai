package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.TodoDatabase filterTodosByOwner
 */
public class FilterTodosByOrder {
  @Test
  public void filterTodosOrderByOwner() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] orderByOwner = db.filterTodosByOBOwner(allTodos);
    assertEquals("Incorrect order by owner", "Barry", orderByOwner[0].owner);
  }

  @Test
  public void filterTodosOrderByStatus() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] orderByStatus = db.filterTodosByOBStatus(allTodos);
    assertEquals("Incorrect order by status", false, orderByStatus[0].status);
  }

  @Test
  public void filterTodosOrderByBody() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] orderByBody = db.filterTodosByOBBody(allTodos);
    assertEquals("Incorrect order by body", "58895985ffd38481b57cac97", orderByBody[0]._id);
  }

  @Test
  public void filterTodosOrderByCategory() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] orderByCategory = db.filterTodosByOBCategory(allTodos);
    assertEquals("Incorrect order by category", "groceries", orderByCategory[0].category);
  }
}
