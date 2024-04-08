let gridApi;

const gridOptions = {
    rowData: [],
    columnDefs: [
        {headerName: "Страница", field: "pageName", editable: true, width: 300},
        {headerName: "Ассоциация", field: "associations", editable: true, width: 500},
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


document.getElementById('dropdown').addEventListener('change', function () {
    const dropdown = document.getElementById("dropdown");

    fetch('/get-pages/' + dropdown.value, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
            if (response.status === 200) {
                return response.json();
            }
            else {
                throw new Error('Failed to load page list');
            }
        }
    ).then(body => {
            gridApi.setGridOption('rowData', body);
        }
    );
});


document.addEventListener('DOMContentLoaded', function () {
    const addRowBtn = document.getElementById('addRowBtn');
    addRowBtn.addEventListener('click', function () {
        const newRowData = {domain: ""};
        gridApi.applyTransaction({add: [newRowData]});
        if (!gridApi.rowData) {
            gridApi.rowData = [];
        }
        gridApi.rowData.push(newRowData);
    });
});


function sendData() {
    let pages = [];

    gridApi.forEachNode(node => {
        pages.push({pageName: node.data['pageName'], associations: node.data['associations']});
    });
    const dropdown = document.getElementById("dropdown");

    fetch('/save-pages/' + dropdown.value, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(pages)
    });

    fetch('http://127.0.0.1:5000/train-model', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dropdown.value)
    });
}

function deleteRow(rowIndex) {
    gridApi.applyTransaction({remove: [gridApi.getRowNode(rowIndex).data]});
}
