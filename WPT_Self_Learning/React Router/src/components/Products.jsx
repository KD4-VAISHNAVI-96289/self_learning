import { Link } from "react-router-dom";

function Products() {

  const products = [

    {
      id: 1,
      name: "Laptop"
    },

    {
      id: 2,
      name: "Mobile"
    },

    {
      id: 3,
      name: "Headphones"
    }

  ];

  return (

    <div>

      <h2>Products</h2>

      {

        products.map(product => (

          <div key={product.id}>

            <Link
              to={`/products/${product.id}`}
            >

              {product.name}

            </Link>

          </div>
        ))
      }

    </div>
  );
}

export default Products;
