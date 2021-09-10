const URL = 'http://localhost:8080';
let holidays = [];

const createHoliday = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const holiday = {};
    holiday['startDate'] = formData.get('startDate');
    holiday['endDate'] = formData.get('endDate');

    fetch(`${URL}/holidays`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            "Authorization": "Bearer " +   localStorage.getItem("bearer-token")
        },
        body: JSON.stringify(holiday)
    }).then((result) => {
        if(result.status==401)
        {
           throw new Error(response.status)
        }
        result.json().then((holiday) => {
            holidays.push(holiday);
            renderHolidays();
        });
    }).catch((error) => {
       alert("Bitte Loggen Sie sich ein!")
      });
};

const indexHolidays = () => {
    fetch(`${URL}/holidays`, {
        method: 'GET',
        headers: {
            "Authorization": "Bearer " +   localStorage.getItem("bearer-token")
        }
    }).then((result) => {
        if(result.status==401)
       {
          throw new Error(response.status)
       }
        result.json().then((result) => {
            holidays = result;
            renderHolidays();
        });
    }).catch((error) => {
        if (window.confirm('Bitte Loggen Sie sich ein mit dem Button "Ok"')) 
        {
        window.location.href='http://localhost:8080';
        };
       });
    renderHolidays();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderHolidays = () => {
    const display = document.querySelector('#holidayDisplay');
    display.innerHTML = '';
    holidays.forEach((holiday) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(holiday.id));
        row.appendChild(createCell(new Date(holiday.startDate).toLocaleString()));
        row.appendChild(createCell(new Date(holiday.endDate).toLocaleString()));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createHolidayForm = document.querySelector('#createHolidayForm');
    createHolidayForm.addEventListener('submit', createHoliday);
    indexHolidays();
});