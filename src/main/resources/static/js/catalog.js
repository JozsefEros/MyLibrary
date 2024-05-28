async function fetchCatalogTable() {
    try {
        const response = await fetch('/catalog');
        if (!response.ok) {
            console.error('Hiba történt:', response.status, response.statusText);
            return;
        }
        const books = await response.json();
        if (!Array.isArray(books)) {
            console.error('A válasz nem egy tömb:', books);
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
                    <td>${book.isAvailable}</td>
                `;
        booksBody.appendChild(tr);
    });
} catch (error) {
        console.error('Hiba történt:', error);
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
    const isAvailable = document.getElementById('isAvailableNew').checked;

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
                isAvailable
            })
        });

        if (response.ok) {
            fetchCatalogTable();
        } else {
            const errorData = await response.json();
            console.error('Hiba az új könyv hozzáadásakor!:', response.statusText, errorData);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
    }
    document.getElementById('titleNew').value = '';
    document.getElementById('authorNew').value = '';
    document.getElementById('genreNew').value = '';
    document.getElementById('publisherNew').value = '';
    document.getElementById('publishedNew').value = '';
    document.getElementById('languageNew').value = '';
    document.getElementById('isbnNew').value = '';
    document.getElementById('isAvailableNew').checked = false;

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
            document.getElementById('isAvailable').checked = book.isAvailable;

        } else {
            console.error('A könyv nem található!');
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
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
    const isAvailable = document.getElementById('isAvailable').checked;

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
                isAvailable
            })
        });

        if (response.ok) {
            fetchCatalogTable();
        } else {
            const errorData = await response.json();
            console.error('Hiba az adatok frissítése során:', response.statusText, errorData);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
    }
    document.getElementById('title').value = null;
    document.getElementById('author').value = '';
    document.getElementById('genre').value = '';
    document.getElementById('publisher').value = '';
    document.getElementById('published').value = '';
    document.getElementById('language').value = '';
    document.getElementById('isbn').value = ''
    document.getElementById('isAvailable').value = false;

}

async function deleteBook() {
    const id = document.getElementById('bookIdDelete').value;

    try {
        const response = await fetch(`/catalog/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            fetchCatalogTable();
        } else {
            console.error('Hiba a könyv törlésekor!');
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!', error);
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
    document.getElementById('isAvailable').value = false;
    document.getElementById('bookIdDelete').value = null;
}