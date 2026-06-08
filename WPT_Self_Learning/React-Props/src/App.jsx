import Parent from "./Parent";

function App() {

  const name = "Vishvesh";

  return (
    <div>
      <h1>Props Drilling Example</h1>

      <Parent name={name} />
    </div>
  );
}

export default App;
