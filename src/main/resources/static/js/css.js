document.addEventListener("DOMContentLoaded", function() {
    const currentYear = new Date().getFullYear();
    const yearSelectElements = document.querySelectorAll('select[id^="yearOfBirth"]');

    yearSelectElements.forEach(select => {
        for (let year = currentYear; year >= 1900; year--) {
            const option = document.createElement('option');
            option.value = year;
            option.textContent = year;
            select.appendChild(option);
        }
    });
});