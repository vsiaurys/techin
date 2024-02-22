import { useState, useEffect } from "react";

export default function Actor() {
  const url = "http://localhost:8080/";
  const [data, setData] = useState([]);

  const getData = async () => {
    const response = await fetch(`${url}actors`, {
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
            </tr>
          </thead>
          <tbody>
            {data.map((d) => {
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
