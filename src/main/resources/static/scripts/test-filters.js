let mediaRecorder;
let audioChunks = [];
let isRecording = false;

const recordButton = document.getElementById('voice-circle-filter');
const dropdown = document.getElementById("dropdown");


recordButton.addEventListener('click', () => {
    const applicationId = dropdown.value;
    if (applicationId) {
        if (!isRecording) {
            startRecording(applicationId);
            recordButton.innerHTML = '<img id="voice-icon-filter" src="../images/record-on-icon-white.gif">';
        } else {
            stopRecordingAndSend();
            recordButton.innerHTML = '<img id="voice-icon-filter" src="../images/record-off-icon-white.png">';
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
    formData.append('username', "bomoked376");//TODO

    fetch('http://127.0.0.1:5000/get_filters', {
        method: 'POST',
        body: formData
    })
        .then(response => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error('Failed to recognize audio');
            }
        })
        .then(filtersData => loadFilters(filtersData.result))
        .catch(error => {
            console.error('Error sending audio:', error);
        });

    audioChunks = [];
}

dropdown.addEventListener("click", function () {
    if (dropdown.value !== undefined && dropdown.value !== "") {
        fetch('/get-filters/' + dropdown.value)
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Failed to fetch filters test data');
                }
            })
            .then(filtersData => {
                loadFilters(filtersData)
            })
            .catch(error => {
                console.error('Error fetching filters test:', error);
            });
    }
});

function loadFilters(filtersData) {
    const filtersDataDiv = document.getElementById("filters-data");
    let innerHtml = '';

    filtersData.forEach(filter => {
        if (filter['filterType'] === 'TOGGLE') {
            innerHtml += '<div class="m-3">' +
                '<p>' + filter['filterName'] + '</p>' +
                '    <div class="custom-control custom-switch">' +
                '        <input readOnly ' + (filter['filter'] ? filter['filter'] === true ? "checked " : "" : "") +
                'type="checkbox" class="custom-control-input" id="customSwitch' + filter['filterName'] + '">' +
                '        <label class="custom-control-label" for="customSwitch' + filter['filterName'] + '"></label>' +
                '  </div>' +
                '</div>';
        }
        if (filter['filterType'] === 'RANGE') {
            let firstValue = filter['filter'] ?
                filter['filter'][0] ? filter['filter'][0] : "0"
                : "0";
            let secondValue = filter['filter'] ?
                filter['filter'][1] ? filter['filter'][1] : "1000"
                : "1000";

            innerHtml += '<div class="m-3">' +
                '<p>' + filter['filterName'] + '</p>' +
                '<div class="row">' +
                '    <div class="form-group mb-2">' +
                '      <label for="range1">От: </label>' +
                '      <input type="text" class="form-control" placeholder="' + firstValue + '" readOnly>' +
                '    </div>' +
                '    <div class="form-group mb-2">' +
                '      <label for="range2">До: </label>' +
                '      <input type="text" class="form-control" placeholder="' + secondValue + '" readOnly>' +
                '    </div>' +
                '  </div>' +
                '</div>';
        }
        if (filter['filterType'] === 'ENUMERATION') {
            let value = ""
            if (filter['filter']) {
                filter['filter'].forEach(filterValue => value += '<li>' + filterValue + '</li>');
            } else {
                value = '<li>Выбор 1</li>' +
                    '<li>Выбор 2</li>';

            }
            innerHtml += '<div class="m-3">' +
                '<p>' + filter['filterName'] + '</p>' +
                '<div>' +
                '<ul>' +
                value +
                '</ul>' +
                '  </div>' +
                '</div>';
        }
    });
    filtersDataDiv.innerHTML = innerHtml;
}

