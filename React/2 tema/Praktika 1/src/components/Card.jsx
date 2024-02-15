import { useState } from "react";

export default function Card() {
  const [buttonColor, setButtonColor] = useState(false);
  function changeColor() {
    setButtonColor(!buttonColor);
  }

  return (
    <div
      className="card"
      style={{ width: "18rem" }}
    >
      <div className="card-body">
        <h5 className="card-title">
          {buttonColor ? "Task is done!" : "Task is not done"}
        </h5>
        <p className="card-text">
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </p>
        <button
          onClick={changeColor}
          type="button"
          className={buttonColor ? "btn btn-success" : "btn btn-danger"}
        >
          {buttonColor ? "Done" : "Mark as done"}
        </button>
      </div>
    </div>
  );
}
