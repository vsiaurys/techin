// 1.  Tiesinis algoritmas. Parašykite programą nurodytam parų skaičiui išreikšti valandomis ir minutėmis.
console.log("Part 1:\n");

const daysGiven = 10;

daysToHoursAndMinutes(daysGiven);

function daysToHoursAndMinutes(days) {
  const hours = days * 24;
  const minutes = hours * 60;

  console.log(
    `There are ${hours} hours or ${minutes} minutes in ${days} days.`
  );
}

// 2. Tiesinis algoritmas. Duotas realusis skaičius x. Parašykite programą, kuri apskaičiuotų y reikšmę pagal formulę y = 16x4+ 2x. Naudoti Math object.
console.log("\nPart 2:\n");

const x = 3;

console.log(y(x));

function y(x) {
  return 16 * Math.pow(x, 4) + 2 * x;
}

// 3. Sąlyginis sakinys. Patikrinkite ar skaičius lyginis ar nelyginis.
console.log("\nPart 3:\n");

const number = 12;

isEvenOrOdd(number);

function isEvenOrOdd(number) {
  if (number % 2 === 0) {
    console.log(`The number ${number} is even.`);
  } else {
    console.log(`The number ${number} is odd.`);
  }
}

// 4. Sąlyginis sakinys. Raskite didžiausią skaičių iš dviejų duotų. Išbandykite kelis būdus:
// Sąlyginis sakinys
// Ternary operator
// Math object
console.log("\nPart 4:\n");

const number1 = 11;
const number2 = 12;

greaterNumber(number1, number2);

function greaterNumber() {
  if (number1 > number2) {
    console.log(`The number ${number1} is greater than number ${number2}`);
  } else {
    console.log(`The number ${number2} is greater than number ${number1}`);
  }

  number1 > number2
    ? console.log(`The number ${number1} is greater than number ${number2}`)
    : console.log(`The number ${number2} is greater than number ${number1}`);

  if (Math.max(number1, number2) === number1) {
    console.log(`The number ${number1} is greater than number ${number2}`);
  } else {
    console.log(`The number ${number2} is greater than number ${number1}`);
  }
}

// 5. Sąlyginis sakinys. Pagal duotą taškų vertinimo lentelę, pateikti įvertinimą.
console.log("\nPart 5:\n");

const ts = 29;
printGrade(ts);

function printGrade(ts) {
  switch (true) {
    case ts < 30:
      console.log("You failed the exam");
      break;
    case ts < 35:
      console.log("Your grade is 1");
      break;
    case ts < 40:
      console.log("Your grade is 2");
      break;
    case ts < 45:
      console.log("Your grade is 3");
      break;
    case ts < 50:
      console.log("Your grade is 4");
      break;
    default:
      console.log("Your grade is 5");
  }
}

// 6. Sąlyginis sakinys. Apskaičiuokite kūno masės indeksą ir nurodykite reikšmę. Pavyzdys: http://sveikas.lt/lt/kmi-skaiciuokle/#
console.log("\nPart 6:\n");

// Variantų sakinys. Duomenys koduojami skaičiais. Saulėta – 1, lietinga – 2, vėjuota – 3, sniegas – 4. Parenkite programą, kuri įvedus kodą, atspausdintų jo reikšmę.

// Variantų sakinys. Parenkite programą, kuri įvedus mėnesio numerį metuose, nustatytų koks tai metų laikas: vasara, ruduo,  žiema,  pavasaris.

// Cikliniai algoritmai. Atspausdinkite visus triženklius skaičius, kurie dalūs iš penkių.

// Cikliniai algoritmai. Atspausdinkite visus skaičius iš intervalo [0, 100], bet jeigu skaičius dalosi iš 3, spausdinkite žodį Fizz, jeigu iš 5 – Buzz, jeigu ir iš 3 ir iš 5 – FizzBuzz.

// Cikliniai algoritmai. Apskaičiuokite funkcijos  reikšmę intervale [-5; 5]. Dalyba iš nulio negalima, ją “apeikite”.

// Cikliniai algoritmai. Raskite visų skaičių sumą iš nurodyto intervalo. Pvz.: intervalas [1; 5], tai skaičių suma intervale yra lygi 15.
