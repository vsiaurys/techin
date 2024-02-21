import { useState, useEffect } from "react";

export default function List() {
  const url = "http://localhost:8080/";
  const [data, setData] = useState([]);
  const [choice, setChoice] = useState("movies");

  const changeChoice = (c) => {
    choice === c ? setChoice("") : setChoice(c);
  };

  const getData = async () => {
    const response = await fetch(`${url}${choice}`, {
      method: "GET",
      headers: { Authorization: "Basic " + btoa("aaaaaaaa:bbbbbbbb") },
    });
    const resp = await response.json();
    setData(resp);
  };

  useEffect(() => {
    getData();
  }, [choice]);

  return (
    <div>
      <div className="my-2">
        <button
          onClick={() => changeChoice("movies")}
          className="btn btn-light me-2"
        >
          /Movies
        </button>
        <button
          onClick={() => changeChoice("actors")}
          className="btn btn-light me-2"
        >
          /Actors
        </button>
      </div>

      <div
        className="alert alert-success"
        role="alert"
      >
        <p>{choice.toUpperCase()}</p>

        <table className="table">
          <thead>
            <tr>
              {choice === "movies" && (
                <>
                  <th scope="col">Id</th>
                  <th scope="col">Title</th>
                  <th scope="col">Date released</th>
                  <th scope="col">Length (minutes)</th>
                </>
              )}

              {choice === "actors" && (
                <>
                  <th scope="col">Id</th>
                  <th scope="col">Name</th>
                  <th scope="col">Sex</th>
                  <th scope="col">Date of birth</th>
                  <th scope="col">Height (cm)</th>
                  <th scope="col">Salary per day</th>
                  <th scope="col">Link to actor's picture</th>
                </>
              )}
            </tr>
          </thead>
          <tbody>
            {choice === "movies" &&
              data.map((d) => {
                return (
                  <tr key={d.id}>
                    <th scope="row">{d.id}</th>
                    <td>{d.title}</td>
                    <td>{d.dateReleased}</td>
                    <td>{d.lengthMinutes}</td>
                  </tr>
                );
              })}

            {choice === "actors" &&
              data.map((d) => {
                return (
                  <tr key={d.id}>
                    <th>{d.id}</th>
                    <td>{d.name}</td>
                    <td>{d.sex}</td>
                    <td>{d.dateOfBirth}</td>
                    <td>{d.height}</td>
                    <td>{d.salaryPerDay}</td>
                    <td>{d.linkToPicture}</td>
                  </tr>
                );
              })}
          </tbody>
        </table>
      </div>
    </div>
  );
}
