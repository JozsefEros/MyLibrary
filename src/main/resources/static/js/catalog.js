async function fetchCatalogTable() {
    try {
        const response = await fetch('/catalog');
        if (!response.ok) {
            console.error('Hiba történt:', response.status, response.statusText);
            showMessageModal('Hiba történt a katalógus betöltésekor!', false);
            return;
        }
        const books = await response.json();
        if (!Array.isArray(books)) {
            console.error('Hiba! A válasz nem tömb!', books);
            showMessageModal('Hiba történt a katalógus adatainak feldolgozásakor!', false);
            return;
        }
    const booksBody = document.getElementById('catalog-body');
    booksBody.innerHTML = '';
    books.forEach(book => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.genre}</td>
                    <td>${book.publisher}</td>
                    <td>${book.published}</td>
                    <td>${book.language}</td>
                    <td>${book.isbn}</td>
                    <td>${book.available}</td>
                `;
        booksBody.appendChild(tr);
    });
        showMessageModal('A katalógus sikeresen betöltve!', true);
} catch (error) {
        console.error('Hiba történt a katalógus betöltésekor!', error);
        showMessageModal('Hiba történt a katalógus betöltésekor!', false);
    }
}

async function addBook() {
    const title = document.getElementById('titleNew').value;
    const author = document.getElementById('authorNew').value;
    const genre = document.getElementById('genreNew').value;
    const publisher = document.getElementById('publisherNew').value;
    const published = document.getElementById('publishedNew').value;
    const language = document.getElementById('languageNew').value;
    const isbn = document.getElementById('isbnNew').value;
    const available = document.getElementById('availableNew').value;

    try {
        const response = await fetch('/catalog', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title,
                author,
                genre,
                publisher,
                published,
                language,
                isbn,
                available
            })
        });

        if (response.ok) {
            fetchCatalogTable();
            showMessageModal('Az új könyv sikeresen felvéve az adatbázisba!', true);
        } else {
            const errorData = await response.json();
            console.error('Hiba az új könyv hozzáadásakor!:', response.statusText, errorData);
            showMessageModal('Hiba történt a könyv adatainak mentése során!', false);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
        showMessageModal('Hiba történt a könyv adatainak mentése során!', false);
    }
    document.getElementById('titleNew').value = '';
    document.getElementById('authorNew').value = '';
    document.getElementById('genreNew').value = '';
    document.getElementById('publisherNew').value = '';
    document.getElementById('publishedNew').value = '';
    document.getElementById('languageNew').value = '';
    document.getElementById('isbnNew').value = '';
    document.getElementById('availableNew').value = '';
}

async function getBookById() {
    const id = document.getElementById('bookId').value;

    try {
        const response = await fetch(`/catalog/${id}`);
        if (response.ok) {
            const book = await response.json();
            document.getElementById('title').value = book.title;
            document.getElementById('author').value = book.author;
            document.getElementById('genre').value = book.genre;
            document.getElementById('published').value = book.published;
            document.getElementById('publisher').value = book.publisher;
            document.getElementById('language').value = book.language;
            document.getElementById('isbn').value = book.isbn;
            document.getElementById('available').value = book.available;
            showMessageModal('A könyv sikeresen betöltve!', true);
        } else {
            console.error('A könyv nem található!');
            showMessageModal('A könyv nem található az adatbázisban!', false);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
        showMessageModal('Hiba történt a könyv adatainak betöltésekor!', false);
    }
}

async function updateBook() {
    const id = document.getElementById('bookId').value;
    const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;
    const genre = document.getElementById('genre').value;
    const published = document.getElementById('published').value;
    const publisher = document.getElementById('publisher').value;
    const language = document.getElementById('language').value;
    const isbn = document.getElementById('isbn').value;
    const available = document.getElementById('available').value;

    try {
        const response = await fetch(`/catalog/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title,
                author,
                genre,
                published,
                publisher,
                language,
                isbn,
                available
            })
        });

        if (response.ok) {
            fetchCatalogTable();
            showMessageModal('A könyv adatait sikeresen frissítettük!', true);
        } else {
            const errorData = await response.json();
            console.error('Hiba az adatok frissítése során:', response.statusText, errorData);
            showMessageModal('Hiba a könyv adatainak frissítésekor!', false);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
        showMessageModal('Hiba a könyv adatainak frissítésekor!', false);
    }
    document.getElementById('title').value = null;
    document.getElementById('author').value = '';
    document.getElementById('genre').value = '';
    document.getElementById('publisher').value = '';
    document.getElementById('published').value = '';
    document.getElementById('language').value = '';
    document.getElementById('isbn').value = ''
    document.getElementById('available').value = '';

}

async function deleteBook() {
    const id = document.getElementById('bookIdDelete').value;

    try {
        const response = await fetch(`/catalog/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            fetchCatalogTable();
            showMessageModal('A könyvet sikeresen töröltük az adatbázisból!', true);
        } else {
            console.error('Hiba a könyv törlésekor!');
            showMessageModal('Hiba a könyv törlésekor!', false);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!', error);
        showMessageModal('Hiba a könyv törlésekor!', false);
    }
    document.getElementById('bookIdDelete').value = null;

}

async function resetForms() {
    document.getElementById('title').value = '';
    document.getElementById('author').value = '';
    document.getElementById('genre').value = '';
    document.getElementById('published').value = '';
    document.getElementById('publisher').value = '';
    document.getElementById('bookId').value = null;
    document.getElementById('language').value = '';
    document.getElementById('isbn').value = '';
    document.getElementById('isAvailable').value = false;
    document.getElementById('bookIdDelete').value = null;
}

window.onload = function() {
    fetchCatalogTable();

    document.getElementById('title').value = '';
    document.getElementById('author').value = '';
    document.getElementById('genre').value = '';
    document.getElementById('published').value = '';
    document.getElementById('publisher').value = '';
    document.getElementById('bookId').value = null;
    document.getElementById('language').value = '';
    document.getElementById('isbn').value = '';
    document.getElementById('available').value = '';
    document.getElementById('bookIdDelete').value = null;
}