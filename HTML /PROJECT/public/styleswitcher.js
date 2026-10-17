const styleButton = document.getElementById("switchStyle");
const stylesheet = document.getElementById("style");
styleButton.addEventListener("click", toggleStyle);

function toggleStyle() {
    const currentHref = stylesheet.getAttribute('href');
    if (currentHref === "cssdemo.css") {
        stylesheet.setAttribute('href', "basestyle.css");
        styleButton.innerHTML = "Switch to cssdemo";
    } else {
        stylesheet.setAttribute('href', "cssdemo.css");
        styleButton.innerHTML = "Switch to basestyle";
    }
}