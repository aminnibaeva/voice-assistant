let mediaRecorder;
let audioChunks = [];
let isRecording = false;

const recordButton = document.getElementById('voice-circle');

document.addEventListener("dropdown", function () {
    loadHistory();
});


recordButton.addEventListener('click', () => {
    const dropdown = document.getElementById("dropdown");

    const applicationId = dropdown.value;
    if (applicationId) {
        if (!isRecording) {
            startRecording(applicationId);
            recordButton.innerHTML = '<img id="voice-icon" src="../images/record-on-icon-white.gif">';
        }
        else {
            stopRecordingAndSend();
            recordButton.innerHTML = '<img id="voice-icon" src="../images/record-off-icon-white.png">';
        }
    }
});

async function startRecording(applicationId) {
    const stream = await navigator.mediaDevices.getUserMedia({audio: true});
    mediaRecorder = new MediaRecorder(stream);

    mediaRecorder.ondataavailable = event => {
        if (event.data.size > 0) {
            audioChunks.push(event.data);
        }
    };

    mediaRecorder.onstop = () => {
        const audioBlob = new Blob(audioChunks, {type: 'audio/mp3'});

        sendRecording(audioBlob, applicationId);
    };

    mediaRecorder.start();
    isRecording = true;
}

function stopRecordingAndSend() {
    mediaRecorder.stop();
    isRecording = false;
}

function sendRecording(audioBlob, applicationId) {
    const formData = new FormData();
    formData.append('audio', audioBlob);
    formData.append('applicationId', applicationId);
    formData.append('username', "123");

    fetch('http://127.0.0.1:5000/recognize', {
        method: 'POST',
        body: formData
    })
        .then(response => {
            if (response.status === 200) {
                return response.json();
            }
            else {
                throw new Error('Failed to recognize audio');
            }
        })
        .then(() => loadHistory())
        .catch(error => {
            console.error('Error sending audio:', error);
        });

    audioChunks = [];
}