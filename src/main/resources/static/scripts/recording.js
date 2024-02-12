let mediaRecorder;
let audioChunks = [];
let isRecording = false;

const recordButton = document.getElementById('voice-circle');
const chatBoxBody = document.getElementById('main-chat-box');

recordButton.addEventListener('click', () => {
    if (!isRecording) {
        startRecording();
        recordButton.innerHTML = '<img id="voice-icon" src="../images/record-on-icon-white.gif">';
    } else {
        stopRecordingAndSend();
        recordButton.innerHTML = '<img id="voice-icon" src="../images/record-off-icon-white.png">';
    }
});

async function startRecording() {
    const stream = await navigator.mediaDevices.getUserMedia({audio: true});
    mediaRecorder = new MediaRecorder(stream);

    mediaRecorder.ondataavailable = event => {
        if (event.data.size > 0) {
            audioChunks.push(event.data);
        }
    };

    mediaRecorder.onstop = () => {
        const audioBlob = new Blob(audioChunks, {type: 'audio/mp3'});

        sendRecording(audioBlob);
    };

    mediaRecorder.start();
    isRecording = true;
}

function stopRecordingAndSend() {
    mediaRecorder.stop();
    isRecording = false;
}

function sendRecording(audioBlob) {
    const formData = new FormData();
    formData.append('audio', audioBlob);

    fetch('/recognize-audio', {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            chatBoxBody.innerHTML =
                '<div class="chat-box-command command">'
                + '<div class="chat-box-command-text">' + data['text'] + '</div>'
                + '</div>'
                + chatBoxBody.innerHTML
        })
        .catch(error => {
            console.error('Error sending audio:', error);
        });

    // Reset audioChunks array for the next recording
    audioChunks = [];
}