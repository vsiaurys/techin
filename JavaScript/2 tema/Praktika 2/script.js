const tagP = document.querySelector("p");

const buttonYellow = document.querySelector(".button-yellow");
buttonYellow.addEventListener("click", function () {
  tagP.className = "";
  tagP.classList.add("text-warning");
});

const buttonGreen = document.querySelector(".button-green");
buttonGreen.addEventListener("click", function () {
  tagP.className = "";
  tagP.classList.add("text-success");
});

const buttonRed = document.querySelector(".button-red");
buttonRed.addEventListener("click", function () {
  tagP.className = "";
  tagP.classList.add("text-danger");
});
