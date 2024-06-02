document.addEventListener('DOMContentLoaded', function () {
    // A modális ablak bezárásának kezelése a bezáró gombra kattintással
    document.getElementById('closeModal').addEventListener('click', function (event) {
        event.stopPropagation(); // Megállítjuk az esemény továbbterjedését
        closeModal();
    });

    // A modális ablak bezárásának kezelése a kattintásra
    window.addEventListener('click', function (event) {
        const modal = document.getElementById('messageModal');
        if (event.target === modal) {
            closeModal();
        }
    });
});

// A modális ablak bezárása
function closeModal() {
    const modal = document.getElementById('messageModal');
    modal.style.display = 'none';
}

// A sikeres vagy hibás üzenetek megjelenítése a modális ablakban
function showMessageModal(message, isSuccess) {
    const modal = document.getElementById('messageModal');
    const modalMessage = document.getElementById('modalMessage');
    modalMessage.textContent = message;
    modal.style.display = 'block';
    const modalContent = document.querySelector('.modal-content');
    if (isSuccess) {
        modalContent.style.backgroundColor = 'lightgreen';
    } else {
        modalContent.style.backgroundColor = 'lightcoral';
    }
    setTimeout(closeModal, 1000);
}