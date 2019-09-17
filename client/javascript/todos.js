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

  var returnString;

  returnString = "/api/todos?"

  if (document.getElementById("owner").value !== ""){
    returnString = returnString + "owner=" + document.getElementById("owner").value + "&";
  }
  console.log(returnString);
  console.log(document.getElementById("status").value);
  if (document.getElementById("status").value !== ""){
    if (document.getElementById("status").value == "complete") {
      returnString = returnString + "status=complete&";
    } else {
      returnString = returnString + "status=incomplete&";
    }
  }
  console.log(returnString);
  if (document.getElementById("body").value !== ""){
    returnString = returnString + "body=" + document.getElementById("body").value + "&";
  }
  console.log(returnString);
  if (document.getElementById("category").value !== ""){
    returnString = returnString + "category=" + document.getElementById("category").value + "&";
  }
  console.log(returnString);
  if (document.getElementById("limit").value !== ""){
    returnString = returnString + "limit=" + document.getElementById("limit").value + "&";
  }
  console.log(returnString);
  get(returnString, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });

}


