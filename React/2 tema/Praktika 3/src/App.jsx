import LessText from "./components/LessText";

function App() {
  return (
    <>
      <div className="container">
        <LessText
          text={
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Culpa, repudiandae voluptatem. Earum adipisci inventore ratione illum placeat officiis libero, culpa dolor ipsum asperiores, voluptas laborum quo neque atque quae laboriosam?"
          }
          maxLength={35}
        />

        <LessText
          text={
            "Earum adipisci inventore ratione illum placeat officiis libero, culpa dolor ipsum asperiores, voluptas laborum quo neque atque quae laboriosam?"
          }
          maxLength={23}
        />
      </div>
    </>
  );
}

export default App;
