// Uses window prompt to ask for name 
//let name = window.prompt("what's your name ?");


// 1. CALCULATING CIRCUMFERENCE OF A CIRCLE
const PI = 3.142;
let radius;
let circumference;

//when we click on the submit button it should act (function)
document.getElementById("ToSubmit").addEventListener("click", function () {
    //let radius = Number(document.getElementById("MyInput").value);
    radius = document.getElementById("MyInput").value;
    radius = Number(radius);
    circumference = 2 * PI * radius;
    //use of math.ceil to round up
    document.getElementById("myh3").textContent = `circumference of the circle is ${circumference}cm, and when rounded would be ${Math.ceil(circumference)}cm`;
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

//3. A RANDOM QUOTE GENERATOR USING EXTERNAL API 
const inquotebtn = document.getElementById("inquotebtn");
const exquotebtn = document.getElementById("exquotebtn");
const quotes = document.getElementById("quotes");
const author = document.getElementById("author");

exquotebtn.addEventListener("click", getquote);
inquotebtn.addEventListener("click", getQuote);


function getquote() {
    fetch("https://api.quotable.io/random")
        //convert to json
        .then(response => response.json())
        // use data
        .then(data => {
            quotes.textContent = data.content;
            author.textContent = "Author:" + data.author;
        })
        .catch(error => {
            quotes.textContent = "Faild to load quote.";
        });
}
// Note request from the API was blocked by CORS (Cross-Origin Resource Sharing) 

//4. A QUOTE GENERATOR FROM INTERNAL JSON FILE 
function getQuote() {
    fetch("quotes.json")
        //convert to json
        .then(response => response.json())
        // use data
        .then(data => {
            let randomindex = Math.floor(Math.random() * data.length);
            quotes.textContent = data[randomindex].quote;
            author.textContent = "- " + data[randomindex].author;
        })
        .catch(error => {
            quotes.textContent = "Faild to load quote.";
        });
}

/*5. CHANGING CIRCLE COLOR 
    cx = Center X position
    cy = Center Y position
*/
const circle = document.getElementById("circle");
const installbtn = document.getElementById("install-button");
const colors = ["red", "pink", "purple", "orange", "black", "green"];

installbtn.addEventListener("click", changecolor);

function changecolor() {
    let randomcolor = colors[Math.floor(Math.random() * colors.length)];
    circle.style.fill = randomcolor;
}

//6. MOVING  AN ITEM LEFT OR RIGHT
const box16 = document.getElementById("box16");
const moveboxleft = document.getElementById("moveboxleft")
const moveboxright = document.getElementById("moveboxright")

let position = 0;

moveboxleft.addEventListener("click", moveleft);

function moveleft() {
    if (position > 0) {
        position -= 50;
        box16.style.left = position + "px";
    }
};

moveboxright.addEventListener("click", moveright);

function moveright() {
    if (position < 300) {
        position += 50;
        box16.style.left = position + "px";
    }
}
