const tagImg = document.querySelector("img");

const buttonIncrease = document.querySelector(".increase");
buttonIncrease.addEventListener("click", function () {
  tagImg.style.width = "150%";
});

const buttonDecrease = document.querySelector(".decrease");
buttonDecrease.addEventListener("click", function () {
  tagImg.style.width = "50%";
});
