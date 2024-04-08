let gridApi;

const gridOptions = {
    rowData: [],
    columnDefs: [
        {headerName: "Домен", field: "domain", editable: true, width: 500},
        {
            headerName: "Язык",
            field: "language",
            editable: true,
            cellEditor: 'agSelectCellEditor',
            cellEditorParams: {
                values: [
                    "Выберите язык",
                    "Afrikaans, South Africa",
                    "Albanian, Albania",
                    "Amharic, Ethiopia",
                    "Arabic, Tunisia",
                    "Arabic, Syria",
                    "Arabic, Algeria",
                    "Arabic, Bahrain",
                    "Arabic, Egypt",
                    "Arabic, Iraq",
                    "Arabic, Israel",
                    "Arabic, Jordan",
                    "Arabic, Kuwait",
                    "Arabic, Lebanon",
                    "Arabic, Mauritania",
                    "Arabic, Morocco",
                    "Arabic, Oman",
                    "Arabic, Qatar",
                    "Arabic, State of Palestine",
                    "Arabic, Saudi Arabia",
                    "Arabic, Yemen",
                    "Arabic, United Arab Emirates",
                    "Armenian, Armenia",
                    "Azerbaijani, Azerbaijan",
                    "Basque, Spain",
                    "Bengali, Bangladesh",
                    "Bengali, India",
                    "Bosnian, Bosnia and Herzegovina",
                    "Bulgarian, Bulgaria",
                    "Burmese, Myanmar",
                    "Catalan, Spain",
                    "Chinese, Cantonese, Traditional Hong Kong",
                    "Chinese, Mandarin, Traditional, Taiwan",
                    "Chinese, Mandarin, Simplified, China",
                    "Croatian, Croatia",
                    "Czech, Czech Republic",
                    "Danish, Denmark",
                    "Dutch, Belgium",
                    "Dutch, Netherlands",
                    "English, Ghana",
                    "English, Hong Kong",
                    "English, India",
                    "English, Ireland",
                    "English, Kenya",
                    "English, New Zealand",
                    "English, Nigeria",
                    "English, Pakistan",
                    "English, Philippines",
                    "English, Singapore",
                    "English, South Africa",
                    "English, United Kingdom",
                    "English, Tanzania",
                    "English, United States",
                    "English, Australia",
                    "English, Canada",
                    "Estonian, Estonia",
                    "Filipino, Philippines",
                    "Finnish, Finland",
                    "French, Switzerland",
                    "French, Canada",
                    "French, France",
                    "French, Belgium",
                    "Galician, Spain",
                    "Georgian, Georgia",
                    "German, Switzerland",
                    "German, Austria",
                    "German, Germany",
                    "Greek, Greece",
                    "Gujarati, India",
                    "Hebrew, Israel",
                    "Hindi, India",
                    "Hungarian, Hungary",
                    "Icelandic, Iceland",
                    "Indonesian, Indonesia",
                    "Italian, Italy",
                    "Italian, Switzerland",
                    "Japanese, Japan",
                    "Javanese, Indonesia",
                    "Kannada, India",
                    "Kazakh, Kazakhstan",
                    "Khmer, Cambodia",
                    "Kinyarwanda, Rwanda",
                    "Korean, South Korea",
                    "Lao, Laos",
                    "Latvian, Latvia",
                    "Lithuanian, Lithuania",
                    "Macedonian, North Macedonia",
                    "Malay, Malaysia",
                    "Malayalam, India",
                    "Marathi, India",
                    "Mongolian, Mongolia",
                    "Nepali, Nepal",
                    "Norwegian Bokmål, Norway",
                    "Persian, Iran",
                    "Polish, Poland",
                    "Portuguese, Portugal",
                    "Portuguese, Brazil",
                    "Punjabi, Gurmukhi, India",
                    "Romanian, Romania",
                    "Russian, Russia",
                    "Serbian, Serbia",
                    "Sinhala, Sri Lanka",
                    "Slovak, Slovakia",
                    "Slovenian, Slovenia",
                    "Southern Sotho, South Africa",
                    "Spanish, Panama",
                    "Spanish, Argentina",
                    "Spanish, Bolivia",
                    "Spanish, Chile",
                    "Spanish, Colombia",
                    "Spanish, Costa Rica",
                    "Spanish, Dominican Republic",
                    "Spanish, Ecuador",
                    "Spanish, El Salvador",
                    "Spanish, Guatemala",
                    "Spanish, Honduras",
                    "Spanish, Mexico",
                    "Spanish, Nicaragua",
                    "Spanish, Paraguay",
                    "Spanish, Peru",
                    "Spanish, Puerto Rico",
                    "Spanish, Spain",
                    "Spanish, United States",
                    "Spanish, Uruguay",
                    "Spanish, Venezuela",
                    "Sundanese, Indonesia",
                    "Swahili, Tanzania",
                    "Swahili, Kenya",
                    "Swati, Latin, South Africa",
                    "Swedish, Sweden",
                    "Tamil, Singapore",
                    "Tamil, Sri Lanka",
                    "Tamil, India",
                    "Tamil, Malaysia",
                    "Telugu, India",
                    "Thai, Thailand",
                    "Tsonga, South Africa",
                    "Tswana, Latin, South Africa",
                    "Turkish, Turkey",
                    "Ukrainian, Ukraine",
                    "Urdu, Pakistan",
                    "Urdu, India",
                    "Uzbek, Uzbekistan",
                    "Venda, South Africa",
                    "Vietnamese, Vietnam",
                    "Xhosa, South Africa",
                    "Zulu, South Africa"
                ]
            }
        },
        {
            headerName: '',
            field: 'delete',
            width: 110,
            cellRenderer: function (params) {
                return '<button class="btn btn-outline-danger btn-sm" onclick="deleteRow(' + params.node.rowIndex + ')">Удалить</button>';
            }
        },
    ],
    defaultColDef: {
        filter: 'agTextColumnFilter',
        floatingFilter: true,
    },
    rowSelection: 'multiple',
    suppressRowClickSelection: true,
    pagination: true,
    paginationPageSize: 15,
    paginationPageSizeSelector: [15, 30, 45],
};

const gridDiv = document.querySelector('#myGrid');
gridApi = agGrid.createGrid(gridDiv, gridOptions);

fetch('/get-domains', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
}).then(response => {
    if (response.status === 200) {
        return response.json();
    }
    else {
        throw new Error('Failed to load domains list');
    }
}).then(body => {
    gridApi.setGridOption('rowData', body);
});


document.addEventListener('DOMContentLoaded', function () {
    const addRowBtn = document.getElementById('addRowBtn');
    const newRowData = {domain: ""};
    addRowBtn.addEventListener('click', function () {
        gridApi.applyTransaction({add: [newRowData]});
        if (!gridApi.rowData) {
            gridApi.rowData = [];
        }
        gridApi.rowData.push(newRowData);
    });
});

function sendData() {
    let domains = [];

    gridApi.forEachNode(node => {
        domains.push(node.data);
    });

    // Отправляем данные на сервер
    fetch('/save-domain', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(domains)
    });

    window.location.href = "/save-page";
}

function deleteRow(rowIndex) {
    gridApi.applyTransaction({remove: [gridApi.getRowNode(rowIndex).data]});
}
