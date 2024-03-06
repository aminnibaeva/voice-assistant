function toggleDiv() {
    const myDiv = document.getElementById("chat-box");
    if (myDiv.style.display === "none") {
        myDiv.style.display = "block";
    }
    else {
        myDiv.style.display = "none";
    }
}

function search() {
    let input = document.getElementById("searchbar").value;
    input = input.toLowerCase();
    let x = document.getElementsByClassName("command");
    for (let i = 0; i < x.length; i++) {
        if (!x[i].innerHTML.toLowerCase().includes(input)) {
            x[i].style.display = "none";
        }
        else {
            x[i].style.display = "list-item";
        }
    }
}