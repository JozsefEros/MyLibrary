const currentDate = new Date();
const currentDay = currentDate.toISOString().split('T')[0];
const expirationDate = new Date();
expirationDate.setDate(currentDate.getDate() + 30);
const expirationDay = expirationDate.toISOString().split('T')[0];

async function searchReaders() {
    const name = document.getElementById('searchReader').value;
    const response = await fetch(`/readers/search?name=${encodeURIComponent(name)}`);
    const readers = await response.json();
    const tableBody = document.getElementById('resultsReaders').querySelector('tbody');
    tableBody.innerHTML = '';

    readers.forEach(reader => {
        const fullName = [reader.firstName, reader.middleName, reader.lastName].filter(Boolean).join(' ');
        const row = document.createElement('tr');
        row.innerHTML = `
                    <td>${reader.id}</td>
                    <td>${reader.firstName}</td>
                    <td>${reader.middleName}</td>
                    <td>${reader.lastName}</td>
                `;
        row.addEventListener('click', () => selectReader(row, reader.id, fullName));
        tableBody.appendChild(row);
    });
}

function selectReader(row, id, name) {
    const rows = document.querySelectorAll('#resultsTable tbody tr');
    rows.forEach(r => r.classList.remove('selected'));
    row.classList.add('selected');
    document.getElementById('selectedReaderId').textContent = id;
    document.getElementById('selectedReaderName').textContent = name;
}

async function searchBooks() {
    const title = document.getElementById('searchBook').value;
    const response = await fetch(`/catalog/searchTitles?title=${encodeURIComponent(title)}`);
    const books = await response.json();
    const tableBook = document.getElementById('resultsBooks').querySelector('tbody');
    tableBook.innerHTML = '';

    books.forEach(book => {
        const authorTitle = [book.author, book.title].join(': ');
        const row = document.createElement('tr');
        row.innerHTML = `
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.available}</td>
                    `;
        row.addEventListener('click', () => selectBook(row, book.id, authorTitle));
        tableBook.appendChild(row);
    });
}

async function searchAuthors() {
    const author = document.getElementById('searchAuthor').value;
    const response = await fetch(`/catalog/searchAuthors?author=${encodeURIComponent(author)}`);
    const books = await response.json();
    const tableBook = document.getElementById('resultsBooks').querySelector('tbody');
    tableBook.innerHTML = '';

    books.forEach(book => {
        const authorTitle = [book.author, book.title].join(': ');
        const row = document.createElement('tr');
        row.innerHTML = `
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.available}</td>
                    `;
        row.addEventListener('click', () => selectBook(row, book.id, authorTitle));
        tableBook.appendChild(row);
    });
}

function selectBook(row, id, authortitle) {
    const rows = document.querySelectorAll('#resultsTable tbody tr');
    rows.forEach(r => r.classList.remove('selected'));
    row.classList.add('selected');
    document.getElementById('selectedBookId').textContent = id;
    document.getElementById('selectedBookId').textContent = authortitle;
}

async function createLending() {
    const reader = document.getElementById('reader').value;
    const book = document.getElementById('book').value;
    const lendingDate = document.getElementById('lendingDate').value;
    const expirationDate = document.getElementById('expirationDate').value;

    try {
        const response = await fetch('/lendings', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                reader: reader.id,
                book: book.id,
                lendingDate: currentDay,
                expirationDate: expirationDay
            })
        });
        if (response.ok) {
            fetchLendingTable();
        } else {
            const errorData = await response.json();
            console.error('Hiba az új kölcsönzésnél!:', response.statusText, errorData);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
    }
    document.getElementById('reader').value = '';
    document.getElementById('book').value = '';
    document.getElementById('lendingDate').value = '';
    document.getElementById('expirationDate').value = '';
}

async function fetchLendingTable() {
    try {
        const response = await fetch('/lending/${reader}');
        if (!response.ok) {
            console.error('Hiba történt:', response.status, response.statusText);
            return;
        }
        const lendings = await response.json();
        if (!Array.isArray(lendings)) {
            console.error('A válasz nem egy tömb:', lendings);
            return;
        }
        const lendingsBody = document.getElementById('lending-body');
        lendingsBody.innerHTML = '';
        lendings.forEach(lending => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                    <td>${lending.id}</td>
                    <td>${lending.reader}</td>
                    <td>${lending.book}</td>
                    <td>${lending.lendingDate}</td>
                    <td>${lending.expirationDate}</td>
                    <td>${lending.returnDate}</td>
                    `;
            lendingsBody.appendChild(tr);
        });
    } catch (error) {
        console.error('Hiba történt:', error);
    }
}