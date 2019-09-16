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

function getAllTodosByFilter() {
  console.log("Getting all the todos.");

  var ownerValue;
  var statusValue;
  var bodyValue;
  var categoryValue;

  if (document.getElementById("owner").value == ""){
    ownerValue = "null";
  } else {
    ownerValue = document.getElementById("owner").value;
  }
/*
  if (document.getElementById("status").value == ""){
    statusValue = "null";
  } else {
    statusValue = document.getElementById("status").value;
  }

  if (document.getElementById("body").value == ""){
    bodyValue = "null";
  } else {
    bodyValue = document.getElementById("body").value;
  }
*/
  if (document.getElementById("category").value == ""){
    categoryValue = "null";
  } else {
    categoryValue = document.getElementById("category").value;
  }

  console.log("123");
  console.log(ownerValue);
  console.log(document.getElementById("category").value == "");
  console.log(categoryValue);

  get("/api/todos?owner=" + ownerValue +
/*    "&status=" + statusValue +
    "&body=" + bodyValue +*/
    "&category=" + categoryValue, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });

}


