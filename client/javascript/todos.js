function getAllTodos() {
  console.log("Getting all the todos.");

  get("/api/todos", function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosById() {
  console.log("Getting the Todo by ID.");

  get("/api/todos/" + document.getElementById("id").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}


