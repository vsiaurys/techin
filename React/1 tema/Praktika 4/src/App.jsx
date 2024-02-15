import Header from "./components/Header";
import PostList from "./components/PostList";
import Box from "./components/Box";

function App() {
  return (
    <>
      <div className="container">
        <div className="row mb-5">
          <div className="col">
            <Header
              title="Page title"
              source="src/assets/cat.jpg"
            />
          </div>
        </div>

        <PostList />

        <div className="row">
          <div className="col-3">
            <Box boxColor="bg-warning" />
          </div>
          <div className="col-3">
            <Box boxColor="bg-dark" />
          </div>
          <div className="col-3">
            <Box boxColor="bg-info" />
          </div>
          <div className="col-3">
            <Box boxColor="bg-success" />
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
