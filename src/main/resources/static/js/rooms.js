window.addEventListener('load', async () => {
    await loadAvailableRooms();
    await loadCatAndOwlFreeRooms();
    addEventListenerToDeleteButton();
});

async function loadAvailableRooms() {
    const response = await fetch(`http://localhost:8080/rooms/available`, {method: 'GET'});
    if (response.ok) {
        const data = await response.json();
        const availableRooms = document.querySelector("#available-rooms");
        let content = "";
        for (const room of data) {
            content += `<div>- ${room.name}</div>`;
        }
        availableRooms.insertAdjacentHTML('afterbegin', content);
    }
}

async function loadCatAndOwlFreeRooms() {
    const response = await fetch(`http://localhost:8080/rooms/rat-owners`, {method: 'GET'});
    if (response.ok) {
        const data = await response.json();
        const catAndOwlFreeRooms = document.querySelector("#room-for-rat-owners");
        let content = "";
        for (const room of data) {
            content += `<div>- ${room.name}</div>`;
        }
        catAndOwlFreeRooms.insertAdjacentHTML('afterbegin', content);
    }
}

function addEventListenerToDeleteButton() {
    const deleteButtons = document.querySelectorAll(".delete-button");

    for (let deleteButton of deleteButtons) {
        deleteButton.addEventListener("click", () => {
            fetch(`http://localhost:8080/rooms/${deleteButton.dataset.id}`, {method: 'DELETE'}).then(
                response => {
                    if (response.ok) {
                        document.getElementById(deleteButton.dataset.id).remove();
                        document.getElementById("available-rooms").innerHTML = "";
                        document.getElementById("room-for-rat-owners").innerHTML = "";
                        loadAvailableRooms();
                        loadCatAndOwlFreeRooms();
                    }
                }
            );
        });
    }
}
