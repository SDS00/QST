document.querySelector("#add-currency").addEventListener("submit", function(e) {
    e.preventDefault();

    const data = {
        name: this.name.value
    };

    fetch(window.CURRENCY_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
        .catch(e => alert("Не удалось добавить валюту:\n" + e));
});

document.querySelector("#add-exchange-rate").addEventListener("submit", function(e) {
    e.preventDefault();

    const data = {
        from_id: this.idFrom.value,
        to_id: this.idTo.value,
        value: this.value.value,
        date: Date.now()
    };

    const checkNumberValue = (value) => {
        const test = Number(value);

        return !isNaN(test);
    }

    if(!checkNumberValue(data.value)) {
        return alert("Не верное значение.");
    }

    fetch(window.EXCHANGE_RATE_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
        .catch(e => alert("Не удалось добавить курс валют:\n" + e));
});

document.querySelector("#get-exchange-rate").addEventListener("submit", function(e) {
    e.preventDefault();

    const data = {
        idFrom: this.idFrom.value,
        idTo: this.idTo.value
    };

    const setExchangeRates = (exchangeRates) => {
        const container = document.querySelector("#exchange-rates");
        container.innerHTML = "";

        exchangeRates.forEach(rate => {
            const row = document.createElement("tr");

            const from = document.createElement("td");
            from.innerHTML = rate.from.name;
            const to = document.createElement("td");
            to.innerHTML = rate.to.name;
            const value = document.createElement("td");
            value.innerHTML = rate.value;
            const date = document.createElement("td");
            date.innerHTML = rate.date;

            row.appendChild(from);
            row.appendChild(to);
            row.appendChild(value);
            row.appendChild(date);

            container.appendChild(row);
        });
    };

    fetch(window.EXCHANGE_RATE_URL + "/" + data.idFrom + "/" + data.idTo, { method: "GET" })
        .then(response => response.json())
        .then(data => setExchangeRates(data))
        .catch(e => alert("Не удалось получить курс валют:\n" + e));
});