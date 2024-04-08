let gridApi;

const gridOptions = {
    rowData: [],
    columnDefs: [
        {headerName: "Домен", field: "domain", width: 500},
        {headerName: "Токен", field: "token", width: 500},
    ],
    defaultColDef: {
        filter: 'agTextColumnFilter',
        floatingFilter: true,
    },
    enableCellTextSelection: true,
    rowSelection: 'multiple',
    suppressRowClickSelection: true,
    pagination: true,
    paginationPageSize: 15,
    paginationPageSizeSelector: [15, 30, 45],
};

const gridDiv = document.querySelector('#myGrid');
gridApi = agGrid.createGrid(gridDiv, gridOptions);

fetch('/get-tokens', {
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
    }
).then(body => {
        gridApi.setGridOption('rowData', body);
    }
);