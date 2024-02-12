const buttonInsertTitle = document.querySelector("#insert-title");

buttonInsertTitle.addEventListener("click", function () {
  const newH1 = document.createElement("h1");

  newH1.textContent = "Pavadinimas";

  const parent = document.querySelector("#parent-div");
  const p = document.querySelector("#lorem-text");

  parent.insertBefore(newH1, p);
});
