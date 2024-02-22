import { useState, useEffect } from "react";

export default function Movies() {
  const url = "http://localhost:8080/";
  const [movies, setMovies] = useState([]);
  const [deleteId, setDeleteId] = useState(0);

  const getData = async () => {
    const response = await fetch(`${url}movies`, {
      method: "GET",
      headers: { Authorization: "Basic " + btoa("aaaaaaaa:bbbbbbbb") },
    });
    const resp = await response.json();
    setMovies(resp);
  };

  const deleteMovie = async (id) => {
    try {
      const response = await fetch(`${url}movies/${id}`, {
        method: "DELETE",
        headers: { Authorization: "Basic " + btoa("aaaaaaaa:bbbbbbbb") },
      });
    } catch (error) {
      console.error("Error deleting movie:", error);
    }

    setDeleteId(id);
  };

  useEffect(() => {
    getData();
  }, [deleteId]);

  return (
    <div
      className="alert alert-success"
      role="alert"
    >
      <table className="table">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Title</th>
            <th scope="col">Date released</th>
            <th scope="col">Length (minutes)</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {movies.map((movie) => {
            return (
              <tr key={movie.id}>
                <th scope="row">{movie.id}</th>
                <td>{movie.title}</td>
                <td>{movie.dateReleased}</td>
                <td>{movie.lengthMinutes}</td>
                <td>
                  <button
                    className="btn btn-primary"
                    onClick={() => deleteMovie(movie.id)}
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
  );
}
