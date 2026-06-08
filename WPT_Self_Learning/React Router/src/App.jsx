import {
  BrowserRouter,
  Routes,
  Route,
  Link
} from "react-router-dom";

import Home from "./components/Home";
import About from "./components/About";
import Contact from "./components/Contact";
import Products from "./components/Products";
import ProductDetails from "./components/ProductDetails";

function App() {

  return (

    <BrowserRouter>

      <div style={{ padding: "20px" }}>

        <h1>React Router Example</h1>

        <nav style={{
          display: "flex",
          gap: "20px",
          marginBottom: "20px"
        }}>

          <Link to="/">Home</Link>

          <Link to="/about">About</Link>

          <Link to="/contact">Contact</Link>

          <Link to="/products">Products</Link>

        </nav>

        <Routes>

          <Route
            path="/"
            element={<Home />}
          />

          <Route
            path="/about"
            element={<About />}
          />

          <Route
            path="/contact"
            element={<Contact />}
          />

          <Route
            path="/products"
            element={<Products />}
          />

          <Route
            path="/products/:id"
            element={<ProductDetails />}
          />

        </Routes>

      </div>

    </BrowserRouter>
  );
}

export default App;
