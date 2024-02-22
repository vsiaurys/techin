import { useState, useEffect } from "react";

export default function Actors() {
  const url = "http://localhost:8080/";
  const [actors, setActors] = useState([]);
  const [deleteId, setDeleteId] = useState(0);

  const getActors = async () => {
    const response = await fetch(`${url}actors`, {
      method: "GET",
      headers: { Authorization: "Basic " + btoa("aaaaaaaa:bbbbbbbb") },
    });
    const resp = await response.json();
    setActors(resp);
  };

  const deleteActor = async (id) => {
    try {
      const response = await fetch(`${url}actors/${id}`, {
        method: "DELETE",
        headers: { Authorization: "Basic " + btoa("aaaaaaaa:bbbbbbbb") },
      });
    } catch (error) {
      console.error("Error deleting actor:", error);
    }

    setDeleteId(id);
  };

  useEffect(() => {
    getActors();
  }, [deleteId]);

  return (
    <div>
      <div
        className="alert alert-success"
        role="alert"
      >
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Name</th>
              <th scope="col">Sex</th>
              <th scope="col">Date of birth</th>
              <th scope="col">Height (cm)</th>
              <th scope="col">Salary per day</th>
              <th scope="col">Link to actor's picture</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            {actors.map((actor) => {
              return (
                <tr key={actor.id}>
                  <th>{actor.id}</th>
                  <td>{actor.name}</td>
                  <td>{actor.sex}</td>
                  <td>{actor.dateOfBirth}</td>
                  <td>{actor.height}</td>
                  <td>{actor.salaryPerDay}</td>
                  <td>{actor.linkToPicture}</td>
                  <td>
                    <button
                      className="btn btn-primary"
                      onClick={() => deleteActor(actor.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}
