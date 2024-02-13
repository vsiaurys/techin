const parent = document.querySelector("#list");

const form = document.forms["todolist"];
form.addEventListener("submit", function (ev) {
  ev.preventDefault();
  const newLi = document.createElement("li");
  newLi.textContent = form["task"].value;
  parent.appendChild(newLi);
});
