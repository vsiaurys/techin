const image = document.querySelector("#image");

const buttonLeft = document.querySelector("#left");
buttonLeft.addEventListener("click", function () {
  image.style.float = "left";
});

const buttonRight = document.querySelector("#right");
buttonRight.addEventListener("click", function () {
  image.style.float = "right";
});

const buttonUnderneaf = document.querySelector("#underneaf");
buttonRed.addEventListener("click", function () {});

const buttonHide = document.querySelector("#hide");
buttonHide.addEventListener("click", function () {});

const buttonRestore = document.querySelector("#restore");
buttonRestore.addEventListener("click", function () {
  image.style.float = "none";
  image.style.display = "absolute";
});
////////////////////
// const buttonInsertTitle = document.querySelector("#insert-title");

// buttonInsertTitle.addEventListener("click", function () {
//   const newH1 = document.createElement("h1");

//   newH1.textContent = "Pavadinimas";

//   const parent = document.querySelector("#parent-div");
//   const p = document.querySelector("#lorem-text");

//   parent.insertBefore(newH1, p);
// });
