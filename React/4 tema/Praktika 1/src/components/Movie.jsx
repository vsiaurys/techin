import { useState, useEffect } from "react";

export default function Movie() {
  const url = "http://localhost:8080/";
  const [data, setData] = useState([]);

  const getData = async () => {
    const response = await fetch(`${url}movies`, {
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
        <tbody>
          {data.map((d) => {
            return (
              <tr key={d.id}>
                <th scope="row">{d.id}</th>
                <td>{d.title}</td>
                <td>{d.dateReleased}</td>
                <td>{d.lengthMinutes}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}
