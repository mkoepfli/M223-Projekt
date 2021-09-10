const URL = 'http://localhost:8080';
let entries = [];

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};

const createEntry = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entry = {};
    entry['checkIn'] = dateAndTimeToDate(formData.get('checkInDate'), formData.get('checkInTime'));
    entry['checkOut'] = dateAndTimeToDate(formData.get('checkOutDate'), formData.get('checkOutTime'));

    fetch(`${URL}/entries`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            "Authorization": "Bearer " +   localStorage.getItem("bearer-token")
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        if(result.status==401)
        {
           throw new Error(response.status)
        }
        result.json().then((entry) => {
            entries.push(entry);
            renderEntries();
        });
    }).catch((error) => {
        if (window.confirm('Bitte Loggen Sie sich ein mit dem Button "Ok"')) 
        {
        window.location.href='http://localhost:8080';
        };
       });
};

const indexEntries = () => {
    fetch(`${URL}/entries`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            "Authorization": "Bearer " +   localStorage.getItem("bearer-token")
        },
    }).then((result) => {
        if(result.status==401)
        {
           throw new Error(response.status)
        }
        result.json().then((result) => {
            entries = result;
            renderEntries();
        });
    }).catch((error) => {
        if (window.confirm('Bitte Loggen Sie sich ein mit dem Button "Ok"')) 
        {
        window.location.href='http://localhost:8080';
        };
       });
    renderEntries();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderEntries = () => {
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    entries.forEach((entry) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(entry.id));
        row.appendChild(createCell(new Date(entry.checkIn).toLocaleString()));
        row.appendChild(createCell(new Date(entry.checkOut).toLocaleString()));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createEntryForm');
    createEntryForm.addEventListener('submit', createEntry);
    indexEntries();
});