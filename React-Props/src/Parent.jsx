import Child from "./Child";

function Parent({ name }) {

  return (
    <div style={{border:'2px solid blue', padding:'20px', margin:'20px'}}>
      <h2>Parent Component</h2>

      <Child name={name} />
    </div>
  );
}

export default Parent;
