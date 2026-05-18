const express = require("express");
const app = express();
app.use(express.json());

let products = [

    {
        id: 1,
        name: "Laptop",
        price: 50000
    },

    {
        id: 2,
        name: "Mobile",
        price: 20000
    },

    {
        id: 3,
        name: "Headphones",
        price: 3000
    }

];

app.get("/products", (req, res) => {

    res.json(products);

});

app.get("/products/:id", (req, res) => {

    const id = Number(req.params.id);

    const product =
        products.find(p => p.id === id);

    if (!product) {

        return res.status(404).json({
            message: "Product not found"
        });
    }

    res.json(product);

});

app.post("/products", (req, res) => {

    const newProduct = {

        id: products.length + 1,

        name: req.body.name,

        price: req.body.price
    };

    products.push(newProduct);

    res.status(201).json({
        message: "Product Added",
        product: newProduct
    });

});
app.put("/products/:id", (req, res) => {

    const id = Number(req.params.id);

    const product =
        products.find(p => p.id === id);

    if (!product) {

        return res.status(404).json({
            message: "Product not found"
        });
    }

    product.name = req.body.name;
    product.price = req.body.price;

    res.json({
        message: "Product Updated",
        product
    });

});

app.delete("/products/:id", (req, res) => {

    const id = Number(req.params.id);

    products =
        products.filter(p => p.id !== id);

    res.json({
        message: "Product Deleted"
    });

});
app.listen(5000, () => {

    console.log("Server running on port 5000");

});