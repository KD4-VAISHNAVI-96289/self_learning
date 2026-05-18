function GrandChild({ name }) {

  return (
    <div style={{border:'2px solid red', padding:'20px', margin:'20px'}}>
      <h2>GrandChild Component</h2>

      <h1>Hello {name}</h1>
    </div>
  );
}

export default GrandChild;
