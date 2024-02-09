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

// Sąlyginis sakinys. Patikrinkite ar skaičius lyginis ar nelyginis.
// Sąlyginis sakinys. Raskite didžiausią skaičių iš dviejų duotų. Išbandykite kelis būdus:

// Sąlyginis sakinys
// Ternary operator
// Math object

// Sąlyginis sakinys. Pagal duotą taškų vertinimo lentelę, pateikti įvertinimą.

// Sąlyginis sakinys. Apskaičiuokite kūno masės indeksą ir nurodykite reikšmę.
// Pavyzdys: http://sveikas.lt/lt/kmi-skaiciuokle/#

// Variantų sakinys. Duomenys koduojami skaičiais. Saulėta – 1, lietinga – 2, vėjuota – 3, sniegas – 4. Parenkite programą, kuri įvedus kodą, atspausdintų jo reikšmę.

// Variantų sakinys. Parenkite programą, kuri įvedus mėnesio numerį metuose, nustatytų koks tai metų laikas: vasara, ruduo,  žiema,  pavasaris.

// Cikliniai algoritmai. Atspausdinkite visus triženklius skaičius, kurie dalūs iš penkių.

// Cikliniai algoritmai. Atspausdinkite visus skaičius iš intervalo [0, 100], bet jeigu skaičius dalosi iš 3, spausdinkite žodį Fizz, jeigu iš 5 – Buzz, jeigu ir iš 3 ir iš 5 – FizzBuzz.

// Cikliniai algoritmai. Apskaičiuokite funkcijos  reikšmę intervale [-5; 5]. Dalyba iš nulio negalima, ją “apeikite”.

// Cikliniai algoritmai. Raskite visų skaičių sumą iš nurodyto intervalo. Pvz.: intervalas [1; 5], tai skaičių suma intervale yra lygi 15.
