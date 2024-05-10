let gridApi;

const gridOptions = {
    rowData: [],
    columnDefs: [
        {headerName: "Имя фильтра", field: "filterName", editable: true, width: 500},
        {
            headerName: "Тип фильтра",
            field: "filterType",
            editable: true,
            cellEditor: 'agSelectCellEditor',
            cellEditorParams: {
                values: ['toggle',
                    'range',
                    'enumeration',
                    'single']
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
const dropdown = document.getElementById("dropdown");

document.getElementById('dropdown').addEventListener('change', function () {
    const dropdown = document.getElementById("dropdown");

    fetch('/get-filters/' + dropdown.value, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
            if (response.status === 200) {
                return response.json();
            } else {
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
        const newRowData = {filterName: ""};
        gridApi.applyTransaction({add: [newRowData]});
        if (!gridApi.rowData) {
            gridApi.rowData = [];
        }
        gridApi.rowData.push(newRowData);
    });
});

function sendData() {
    let filterNames = [];

    gridApi.forEachNode(node => {
        filterNames.push(node.data);
    });
    const dropdown = document.getElementById("dropdown");

    fetch('/save-filters/' + dropdown.value, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(filterNames)
    });

    window.location.href = "/save-filters";
}

function deleteRow(rowIndex) {
    gridApi.applyTransaction({remove: [gridApi.getRowNode(rowIndex).data]});
}
