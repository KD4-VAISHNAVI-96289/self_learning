const express = require("express");
const cors = require("cors");

const app = express();

app.use(cors());

const books = [
    {
        id: 1,
        name: "WPT",
        author: " Rohan Paramane"
    },
    {
        id: 2,
        name: "DBT",
        author: "Nilesh Ghule"
    },
    {
        id: 3,
        name: "CPP",
        author: "Ketan"
    }
];

app.get("/books", (req, res) => {
    res.json(books);
});

app.listen(5000, () => {
    console.log("Server running on port 5000");
});