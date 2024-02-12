// 1.
const imgCollection = document.getElementsByTagName("img");
console.log(imgCollection.item(1));

// 2.
console.log(
  document.querySelector(
    "div.flex-lg-row:nth-child(1) > li:nth-child(2) > a:nth-child(1)"
  )
);

// 3.
console.log(document.querySelector(".lnr-magnifier"));

// 4.
console.log(document.querySelector(".display-4"));

// 5.
console.log(document.querySelector("a.btn:nth-child(1)"));

// 6.
console.log(document.querySelector(".hero-info > li:nth-child(3)"));
