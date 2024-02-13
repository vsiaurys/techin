const form = document.forms["form"];
form.addEventListener("submit", function (ev) {
  ev.preventDefault();
  const number =
    Number(form["firstNumber"].value) + Number(form["secondNumber"].value);
  const sum = document.getElementById("sum");
  sum.textContent = number;
});
