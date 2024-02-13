let guesses = 0;
const guessedNumber = Math.round(Math.random() * 100);

const form = document.forms["form"];
form.addEventListener("submit", function (ev) {
  ev.preventDefault();
  const number = Number(form["input"].value);

  guesses++;
  if (number < guessedNumber) {
    resultText.textContent = "The guessed number is bigger!";
    resultCount.textContent = `${guesses} guesses was done`;
  } else if (number > guessedNumber) {
    resultText.textContent = "The guessed number is smaller!";
    resultCount.textContent = `${guesses} guesses was done`;
  } else {
    resultText.textContent = `The number is ${guessedNumber}`;
    resultCount.textContent = `You guessed in ${guesses} times`;
  }
});
