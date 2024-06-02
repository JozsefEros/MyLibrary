const currentDate = new Date();
const currentDay = currentDate.toISOString().split('T')[0];

async function fetchReadersTable() {
    const response = await fetch('/readers');
    const readers = await response.json();
    const readersBody = document.getElementById('readers-body');
    readersBody.innerHTML = '';
    readers.forEach(reader => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
                    <td>${reader.id}</td>
                    <td>${reader.firstName}</td>
                    <td>${reader.middleName}</td>
                    <td>${reader.lastName}</td>
                    <td>${reader.yearOfBirth}</td>
                    <td>${reader.registrationDate.split('T')[0]}</td>
                    <td>${reader.createdAt}</td>
                    <td>${reader.modifiedAt}</td>
                `;
        readersBody.appendChild(tr);
    });
    showMessageModal('Az olvasók listája sikeresen betöltve!', true);
}

async function addReader() {
    const firstName = document.getElementById('firstNameNew').value;
    const middleName = document.getElementById('middleNameNew').value;
    const lastName = document.getElementById('lastNameNew').value;
    const yearOfBirth = document.getElementById('yearOfBirthNew').value;

    try {
        const response = await fetch('/readers', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName,
                middleName,
                lastName,
                yearOfBirth,
                registrationDate: currentDay,
                createdAt: currentDay,
                modifiedAt: currentDay
            })
        });

        if (response.ok) {
            fetchReadersTable();
            showMessageModal('Az új olvasó sikeresen felvéve az adatbázisba!', true);
        } else {
            const errorData = await response.json();
            console.error('Hiba az új olvasó hozzáadásakor!', response.statusText, errorData);
            showMessageModal('Hiba az új olvasó hozzáadásakor!', false);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
        showMessageModal('Hiba az új olvasó hozzáadásakor!', false);
    }
    document.getElementById('firstNameNew').value = '';
    document.getElementById('middleNameNew').value = '';
    document.getElementById('lastNameNew').value = '';
    document.getElementById('yearOfBirthNew').value = 1982;
    document.getElementById('registrationDateNew').value = currentDay;

}

async function getReaderById() {
    const id = document.getElementById('readerId').value;

    try {
        const response = await fetch(`/readers/${id}`);
        if (response.ok) {
            const reader = await response.json();
            document.getElementById('firstName').value = reader.firstName;
            document.getElementById('middleName').value = reader.middleName || '';
            document.getElementById('lastName').value = reader.lastName;
            document.getElementById('yearOfBirth').value = reader.yearOfBirth;
            document.getElementById('registrationDate').value = reader.registrationDate.split('T')[0];
            showMessageModal('Az olvasó adatai sikeresen lekérve az adatbázisból!', true);
        } else {
            console.error('Az olvasó nem található!');
            showMessageModal('Az olvasó nem található!', false);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
        showMessageModal('Hiab az olvasó adatainak betöltésekor!', false);
    }
}

async function updateReader() {
    const id = document.getElementById('readerId').value;
    const firstName = document.getElementById('firstName').value;
    const middleName = document.getElementById('middleName').value;
    const lastName = document.getElementById('lastName').value;
    const yearOfBirth = document.getElementById('yearOfBirth').value;
    const registrationDate = document.getElementById('registrationDate').value;


    try {
        const response = await fetch(`/readers/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName,
                middleName,
                lastName,
                yearOfBirth,
                registrationDate,
                modifiedAt: currentDay
            })
        });

        if (response.ok) {
            fetchReadersTable();
            showMessageModal('Az olvasó adatai sikeresen frissítve!', true);
        } else {
            const errorData = await response.json();
            console.error('Hiba az adatok frissítése során:', response.statusText, errorData);
            showMessageModal('Hiba az olvasó adatainak frissítésekor!', false);
        }
    } catch (error) {
        console.error('Hiba az adatok betöltésekor!:', error);
        showMessageModal('Hiba az olvasó adatainak frissítésekor!', false);
    }
    document.getElementById('readerId').value = null;
    document.getElementById('firstName').value = '';
    document.getElementById('middleName').value = '';
    document.getElementById('lastName').value = '';

}

async function deleteReader() {
    const id = document.getElementById('readerIdDelete').value;

    try {
        const response = await fetch(`/readers/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            fetchReadersTable();
            showMessageModal('Az olvasót sikeresen töröltük!', true);
        } else {
            console.error('Failed to delete reader');
            showMessageModal('Hiba az olvasó törlése során!', false);
        }
    } catch (error) {
        console.error('Error during fetch:', error);
        showMessageModal('Hiba az olvasó törlése során!', false);
    }
    document.getElementById('readerIdDelete').value = null;

}

async function resetForms() {
    document.getElementById('firstNameNew').value = '';
    document.getElementById('middleNameNew').value = '';
    document.getElementById('lastNameNew').value = '';
    document.getElementById('yearOfBirthNew').value = 1982;
    document.getElementById('registrationDateNew').value = currentDay;
    document.getElementById('readerId').value = null;
    document.getElementById('firstName').value = '';
    document.getElementById('middleName').value = '';
    document.getElementById('lastName').value = '';
    document.getElementById('readerIdDelete').value = null;
}

window.onload = function () {
    fetchReadersTable();

    document.getElementById('firstNameNew').value = '';
    document.getElementById('middleNameNew').value = '';
    document.getElementById('lastNameNew').value = '';
    document.getElementById('yearOfBirthNew').value = 1982;
    document.getElementById('registrationDateNew').value = currentDay;
    document.getElementById('readerId').value = null;
    document.getElementById('firstName').value = '';
    document.getElementById('middleName').value = '';
    document.getElementById('lastName').value = '';
    document.getElementById('readerIdDelete').value = null;
};