import { useState, useEffect } from "react";

export default function PostsList() {
  const url = "https://jsonplaceholder.typicode.com/";
  const [data, setData] = useState([]);
  const [choice, setChoice] = useState("posts");

  const changeChoice = (choice) => {
    setChoice(choice);
  };

  const getData = async () => {
    const response = await fetch(url + choice);
    const resp = await response.json();
    setData(resp);
  };

  useEffect(() => {
    getData();
  });

  return (
    <div>
      <div className="my-2">
        <button
          onClick={() => changeChoice("posts")}
          className="btn btn-light me-2"
        >
          /Posts
        </button>
        <button
          onClick={() => changeChoice("comments")}
          className="btn btn-light me-2"
        >
          /Comments
        </button>
      </div>

      <div
        className="alert alert-success"
        role="alert"
      >
        <p>{choice.toUpperCase()}</p>

        {choice === "posts" &&
          data.map((d) => {
            return (
              <div key={d.id}>
                <p>{d.id}</p>
                <p>{d.title}</p>
                <p>{d.body}</p>
              </div>
            );
          })}

        {choice === "comments" &&
          data.map((d) => {
            return (
              <div key={d.id}>
                <p>{d.id}</p>
                <p>{d.name}</p>
                <p>{d.email}</p>
                <p>{d.body}</p>
              </div>
            );
          })}
      </div>
    </div>
  );
}
