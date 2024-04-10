
function loadHistory() {
    const userId = 2; // TODO: Замените на актуальный ID пользователя
    fetch('/history?user_id=' + userId)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Failed to fetch history data');
            }
        })
        .then(historyData => {
            displayHistory(historyData);
        })
        .catch(error => {
            console.error('Error fetching history:', error);
        });
}

function displayHistory(historyData) {
    const historyContainer = document.getElementById("history-container");
    historyContainer.innerHTML = "";
    historyData.forEach(function (user_query) {

        const innerDiv = document.createElement("div");
        innerDiv.className = 'chat-box-command-text';
        innerDiv.id = user_query.userQueryId;

        const link = document.createElement("a");
        link.className = "page-link";
        link.href = "/" + user_query.query;
        link.textContent = user_query.query;
        link.onclick = function () {
            updateQuery(user_query.userQueryId);
        };

        innerDiv.appendChild(link);

        const deleteButton = document.createElement("button");
        deleteButton.className = "delete_button";
        deleteButton.onclick = function () {
            deleteQuery(user_query.userQueryId);
        };

        const img = document.createElement("img");
        img.id = "delete-icon";
        img.src = "../images/cross-icon-blue.png";

        deleteButton.appendChild(img);

        const outerDiv = document.createElement("div");
        outerDiv.className = 'chat-box-command command';

        outerDiv.appendChild(innerDiv);
        outerDiv.appendChild(deleteButton);
        historyContainer.appendChild(outerDiv);
    });

    function deleteQuery(userQueryId) {
        const formData = new FormData();
        formData.append('userQueryId', userQueryId);

        fetch('http://127.0.0.1:5000/delete_query', {
            method: 'POST',
            body: formData
        }).then(() => loadHistory());
    }

    function updateQuery(userQueryId) {
        const formData = new FormData();
        formData.append('userQueryId', userQueryId);

        fetch('http://127.0.0.1:5000/update_query', {
            method: 'POST',
            body: formData
        }).then(() => loadHistory());
    }
}
