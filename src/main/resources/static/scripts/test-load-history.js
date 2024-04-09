function loadTestHistory() {
    fetch('/test-history?applicationId=' + dropdown.value)
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            else {
                throw new Error('Failed to fetch history test data');
            }
        })
        .then(historyData => {
            displayHistory(historyData);
        })
        .catch(error => {
            console.error('Error fetching history test:', error);
        });
}