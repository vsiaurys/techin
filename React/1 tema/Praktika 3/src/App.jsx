import Header from "./components/Header";
import PostImage from "./components/PostImage";
import PostContent from "./components/PostContent";
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

        <div className="row">
          <div className="col-6">
            <PostImage source="src/assets/lion.jpg" />
            <PostContent
              title="First post title"
              content="Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quam nisi
        velit id dolorem, quisquam perspiciatis provident enim reprehenderit.
        Aliquam quod cum minima at dignissimos aut facilis eius ducimus labore
        asperiores."
            />
          </div>

          <div className="col-6">
            <PostImage source="src/assets/tiger.jpg" />
            <PostContent
              title="Second post title"
              content="Odio alias magni officia explicabo ad unde mollitia harum modi optio saepe eligendi, ducimus non temporibus facere obcaecati? Sed atque doloremque eveniet?"
            />
          </div>
        </div>

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
