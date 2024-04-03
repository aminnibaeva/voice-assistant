document.addEventListener("DOMContentLoaded", function () {
    loadHistory();
});

function loadHistory() {
    const userId = 2; // TODO: Замените на актуальный ID пользователя
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "/history?user_id=" + userId, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const historyData = JSON.parse(xhr.responseText);
            displayHistory(historyData);
        }
    };
    xhr.send();
}

function displayHistory(historyData) {
    const historyContainer = document.getElementById("history-container");
    // historyContainer.innerHTML = "";
    historyData.forEach(function (user_query) {

        const innerDiv = document.createElement("div");
        innerDiv.className = 'chat-box-command-text';
        innerDiv.id = user_query.userQueryId;
        innerDiv.textContent = user_query.query;

        const outerDiv = document.createElement("div");
        outerDiv.className = 'chat-box-command command';

        outerDiv.appendChild(innerDiv);
        historyContainer.appendChild(outerDiv);
    });
}
