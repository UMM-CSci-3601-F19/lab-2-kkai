package umm3601.todo;

import org.junit.Test;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import static junit.framework.TestCase.assertEquals;

/**
 * Tests  filterByCombination
 */
public class FilterTodoByCombination {
  @Test
  public void filterTodosByCombination() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] todos = db.filterTodosByOwner(allTodos, "Blanche");
    todos = db.filterTodosByStatus(todos, "incomplete");
    todos = db.filterTodosByCategory(todos, "homework");
    todos = db.filterTodosByBody(todos, "exercitation");
    todos = db.filterTodosByLimit(todos, "5");
    for (int i = 0; i < todos.length; i++) {
      assertEquals("Incorrect length for the combination filter", 4, todos.length);
    }
  }

  @Test
  public void listTodosWithByCombination() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();
    queryParams.put("owner", new String[]{"Blanche"});
    queryParams.put("status", new String[]{"complete"});
    queryParams.put("limit", new String[]{"12"});
    queryParams.put("orderBy", new String[]{"category"});
    Todo[] todos1 = db.listTodos(queryParams);
    for (int i = 0; i < todos1.length; i++) {
      assertEquals("Wrong string", "Blanche", todos1[i].owner);
      assertEquals("Wrong status", true, todos1[i].status == (true));
    }
    assertEquals("Wrong size returned", 12, todos1.length);
    assertEquals("Wrong order", "homework", todos1[3].category);
  }

  @Test
  public void listTodosWithByCombinationAllField() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();
    queryParams.put("owner", new String[]{"Blanche"});
    queryParams.put("status", new String[]{"complete"});
    queryParams.put("contains", new String[]{"Cupidatat"});
    queryParams.put("category", new String[]{"groceries"});
    queryParams.put("limit", new String[]{"12"});
    queryParams.put("orderBy", new String[]{"owner"});
    Todo[] todos1 = db.listTodos(queryParams);
    assertEquals("Wrong ID for the combination filter", "5889598586bbabf63acfbc76", todos1[0]._id);
  }
}
