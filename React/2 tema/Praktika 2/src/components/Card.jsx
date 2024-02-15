import { useState } from "react";

export default function Card() {
  const [likes, setLikes] = useState(0);
  const [hates, setHates] = useState(0);

  function increaseLikes() {
    setLikes((likes) => likes + 1);
  }

  function increaseHates() {
    setHates((hates) => hates + 1);
  }

  function resetLikesAndHates() {
    setLikes((likes) => 0);
    setHates((hates) => 0);
  }

  return (
    <div className="card w-75 mt-5">
      <img
        src="src/assets/tiger.jpg"
        className="card-img-top"
        alt="..."
      />
      <div className="card-body">
        <h5 className="card-title">Post</h5>
        <p className="card-text">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Culpa,
          repudiandae voluptatem. Earum adipisci inventore ratione illum placeat
          officiis libero, culpa dolor ipsum asperiores, voluptas laborum quo
          neque atque quae laboriosam?
        </p>
        <button
          onClick={increaseLikes}
          type="button"
          className="btn btn-success mx-2"
        >
          Like {likes}
        </button>
        <button
          onClick={increaseHates}
          type="button"
          className="btn btn-danger mx-2"
        >
          Hate {hates}
        </button>
        <button
          onClick={resetLikesAndHates}
          type="button"
          className="btn btn-info mx-2"
        >
          Reset
        </button>
      </div>
    </div>
  );
}
