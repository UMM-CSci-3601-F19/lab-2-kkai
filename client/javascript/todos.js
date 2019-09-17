function getAllTodos() {
  console.log("Getting all the todos.");

  get("/api/todos", function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosById() {
  console.log("Getting the Todo by ID.");

  get("/api/todos/" + document.getElementById("id").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByFilter() {
  console.log("Getting all the todos.");

  var returnString;

  returnString = "/api/todos?";

  if (document.getElementById("owner").value !== "") {
    returnString = returnString + "owner=" + document.getElementById("owner").value + "&";
  }

  if (document.getElementById("status").value !== "") {
    returnString = returnString + "status=" + document.getElementById("status").value + "&";
  }

  if (document.getElementById("contains").value !== "") {
    returnString = returnString + "contains=" + document.getElementById("contains").value + "&";
  }

  if (document.getElementById("category").value !== "") {
    returnString = returnString + "category=" + document.getElementById("category").value + "&";
  }

  if (document.getElementById("limit").value !== "") {
    returnString = returnString + "limit=" + document.getElementById("limit").value + "&";
  }
  console.log(returnString);
  if (document.getElementById("orderBy").value !== "") {
    returnString = returnString + "orderBy=" + document.getElementById("orderBy").value + "&";
  }
  
  get(returnString, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });

}


