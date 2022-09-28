window.addEventListener('load', async () =>{
    await loadUsersForSelectInput();
    addEventListenerToModifyButton();
});

async function loadUsersForSelectInput() {
    const response = await fetch(`http://localhost:8080/students/get-all-students`, {method: 'GET'});
    if (response.ok) {
        const data = await response.json();
        const studentsSelect = document.querySelector("#students");
        let content = "";
        for (const student of data) {
            content += `<option value='${student.uuid}'>${student.name}</option>`;
        }
        studentsSelect.insertAdjacentHTML('beforeend', content);
    }
}

function addEventListenerToModifyButton() {
    const uuidNew = document.querySelector("#uuid-new");
    const nameNew = document.querySelector("#name-new");
    const houseTypeNew = document.querySelector("#house-type-new");
    const modifyButton = document.querySelector("#modify-button");

    modifyButton.addEventListener("click", async () => {
        const payload = {"uuid": `${uuidNew.value}`, "name": `${nameNew.value}`, "houseType": `${houseTypeNew.value}`};
        const message = {
            method: 'PUT',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(payload)
        };
        const response = await fetch(`http://localhost:8080/rooms/${modifyButton.dataset.id}`, message);
        if (response.ok == true) {
            const data = await response.json();

            const uuidOld = document.querySelector("#uuid-old");
            const nameOld = document.querySelector("#name-old");
            const houseTypeOld = document.querySelector("#house-type-old");

            uuidOld.textContent = data.uuid;
            nameOld.textContent = data.name;
            houseTypeOld.textContent = data.houseType;
        }
    });
}
