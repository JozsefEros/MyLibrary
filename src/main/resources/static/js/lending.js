const currentDate = new Date();
const currentDay = currentDate.toISOString().split('T')[0];
const expirationDate = new Date();
expirationDate.setDate(currentDate.getDate() + 30);
const expirationDay = expirationDate.toISOString().split('T')[0];
let selectedReader;
let selectedBook;

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
    showMessageModal('Az olvasók listája sikeresen betöltve!', true);
}

function selectReader(row, id, name) {
    const rows = document.querySelectorAll('#resultsTable tbody tr');
    rows.forEach(r => r.classList.remove('selected'));
    row.classList.add('selected');
    document.getElementById('selectedReaderId').textContent = id;
    document.getElementById('selectedReaderName').textContent = name;
    selectedReader = id;
    showMessageModal(`${name} sikeresen kiválasztva!`, true);
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
    showMessageModal(`A könyvek listája sikeresen betöltve!`, true);
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
    showMessageModal(`A könyvek listája sikeresen betöltve!`, true);
}

function selectBook(row, id, authortitle) {
    const rows = document.querySelectorAll('#resultsTable tbody tr');
    rows.forEach(r => r.classList.remove('selected'));
    row.classList.add('selected');
    document.getElementById('selectedBookId').textContent = id;
    document.getElementById('selectedBookId').textContent = authortitle;
    selectedBook = id;
    showMessageModal(`${authortitle} könyv sikeresen kiválasztva!`, true);
}

async function createLending() {
    const reader = selectedReader;
    const book = selectedBook;
    const lendingDate = currentDay;
    const expirationDate = expirationDay;

    try {
        const response = await fetch('/lendings', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                reader,
                book,
                lendingDate,
                expirationDate
            })
        });
        if (response.ok) {
            fetchLendingTable();
            showMessageModal(`A kölcsönzés sikeres!`, true);
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
    const id = selectedReader;
    try {
        const response = await fetch('/lendings/${id}');
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

async function updateBook() {
    const id = selectedBook;
    const available = "Nem";
    try {
        const response = await fetch(`/catalog/${id}/availability`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                available
            })
        });

        if (response.ok) {
            console.log('A könyv elérhetősége sikeresen frissítve.');
            //fetchLendingTable();
        } else {
            const errorData = await response.json();
            console.error('Hiba az adatok frissítése során:', response.statusText, errorData);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
    }
}

async function lendBook() {
    const id = selectedBook;
    console.log(`Lending book with id: ${id}`);

    try {
        const response = await fetch(`/catalog/lend/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                available: "Nem"
            })
        });

        if (response.ok) {
            console.log('Book status updated successfully.');
            //fetchLendingTable();
            showMessageModal('A könyv státuszát sikeresen frissítettük!', true);
        } else {
            const errorData = await response.json();
            console.error('Error updating book status:', response.statusText, errorData); // Debug üzenet
            showMessageModal('Hiba a könyv státuszának módosításakor!', false);
        }
    } catch (error) {
        console.error('Error loading data:', error); // Debug üzenet
        showMessageModal('Hiba a könyv státuszának módosításakor!', false);
    }
}