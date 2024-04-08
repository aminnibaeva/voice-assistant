// Функция для заполнения выпадающего списка элементами из запроса
async function populateDropdown() {
    const dropdown = document.getElementById('dropdown');
    dropdown.innerHTML = '<option value="">Загрузка...</option>'; // Показываем сообщение о загрузке

    try {
        const data = await fetchData(); // Получаем данные из запроса
        dropdown.innerHTML = '<option value="">Выберите элемент</option>'; // Сбрасываем список перед заполнением

        // Заполняем список полученными элементами
        data.forEach(item => {
            const option = document.createElement('option');
            option.value = item['id'];
            option.textContent = item['domain'];
            dropdown.appendChild(option);
        });
    }
    catch (error) {
        console.error('Ошибка загрузки данных:', error);
        dropdown.innerHTML = '<option value="">Ошибка загрузки данных</option>'; // В случае ошибки показываем сообщение об ошибке
    }
}

// заполнение селекта
function fetchData() {
    return new Promise((resolve) => {

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
            }
        ).then(body => {
                resolve(body);
            }
        );
    });
}

// Вызываем функцию для заполнения выпадающего списка при загрузке страницы
populateDropdown();
