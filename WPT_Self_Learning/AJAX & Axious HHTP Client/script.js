const output = document.getElementById("output");

function displayBooks(data) {

    output.innerHTML = "";

    data.forEach(book => {

        output.innerHTML += `
        
        <div class="card p-3 shadow"
            style="width: 18rem;">

            <h3>${book.name}</h3>

            <p>
                Author: ${book.author}
            </p>

        </div>
        `;
    });
}


function getBooksXHR() {

    const xhr = new XMLHttpRequest();

    xhr.open("GET",
        "http://localhost:5000/books");

    xhr.onload = function () {

        const data = JSON.parse(xhr.responseText);

        displayBooks(data);
    };

    xhr.send();
}


function getBooksFetchThen() {

    fetch("http://localhost:5000/books")

        .then(response => response.json())

        .then(data => {

            displayBooks(data);
        })

        .catch(error => {

            console.log(error);
        });
}

async function getBooksAsync() {

    try {

        const response =
            await fetch("http://localhost:5000/books");

        const data =
            await response.json();

        displayBooks(data);

    } catch (error) {

        console.log(error);
    }
}

function getBooksAxios() {

    axios.get("http://localhost:5000/books")

        .then(response => {

            displayBooks(response.data);
        })

        .catch(error => {

            console.log(error);
        });
}