import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

export default function Movie() {
  const url = "http://localhost:8080/movies/";
  const [data, setData] = useState(null);
  const { movieId } = useParams();

  const getData = async () => {
    const response = await fetch(`${url}${movieId}`, {
      method: "GET",
      headers: { Authorization: "Basic " + btoa("aaaaaaaa:bbbbbbbb") },
    });
    const resp = await response.json();
    setData(resp);
  };

  useEffect(() => {
    getData();
  }, []);

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
          </tr>
        </thead>

        {data && (
          <tbody>
            <tr key={data.id}>
              <th scope="row">{data.id}</th>
              <td>{data.title}</td>
              <td>{data.dateReleased}</td>
              <td>{data.lengthMinutes}</td>
            </tr>
          </tbody>
        )}
      </table>
    </div>
  );
}
