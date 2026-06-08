import GrandChild from "./GrandChild";

function Child({ name }) {

  return (
    <div style={{border:'2px solid green', padding:'20px', margin:'20px'}}>
      <h2>Child Component</h2>

      <GrandChild name={name} />
    </div>
  );
}

export default Child;
