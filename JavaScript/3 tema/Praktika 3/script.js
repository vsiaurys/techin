const form = document.forms["form1"];
form.addEventListener("submit", function (ev) {
  ev.preventDefault();
  const kmiIndex =
    Number(form["weight"].value) /
    Math.pow(Number(form["height"].value) / 100, 2);

  kmi.textContent = `Jūsų KMI yra: ${kmiIndex.toFixed(2)}`;
});
