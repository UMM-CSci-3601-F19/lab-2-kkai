package umm3601.todo;

import org.junit.Test;
import umm3601.todo.Todo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.TodoDatabase filterTodosByLimit
 */
public class FilterTodosByLimitFromDB {
  @Test
  public void FilterTodosByLimit() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] limitThree = db.filterTodosByLimit(allTodos, "3");
    assertEquals("incorrect # of entries", 3, limitThree.length);
    Todo[] limitFifteen = db.filterTodosByLimit(allTodos, "15");
    assertEquals("incorrect # of entries", 15, limitFifteen.length);
  }
}
