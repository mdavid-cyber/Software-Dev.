// Uses window prompt to ask for name 
//let name = window.prompt("what's your name ?");


// 1. CACULATING CIRCUMFERENCE OF A CIRCLE
const PI = 3.142;
let radius;
let circumference;

//when we click on the submit button it should act (function)
document.getElementById("ToSubmit").addEventListener("click", function () {
    radius = document.getElementById("MyInput").value;
    radius = Number(radius);
    circumference = 2 * PI * radius;
    document.getElementById("myh3").textContent = `circumference of the circle is ${circumference}cm`;
});

// 2. A DECREASE, RESET, INCREASE COUNTER
//set a nickname for each id 
const decreasebtn = document.getElementById("decreasebtn");
const increasebtn = document.getElementById("increasebtn");
const resetbtn = document.getElementById("resetbtn");
const countnbr = document.getElementById("countnbr");

let count = 0;

increasebtn.addEventListener("click", function () {
    count++;
    countnbr.textContent = count;
})

resetbtn.addEventListener("click", function () {
    count = 0;
    countnbr.textContent = count;
})

decreasebtn.addEventListener("click", function () {
    if (count > 0) {
        count--;
    }
    countnbr.textContent = count;
})