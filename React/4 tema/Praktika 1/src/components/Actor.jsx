import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

export default function Actor() {
  const url = "http://localhost:8080/actors/";
  const [data, setData] = useState(null);
  const { actorId } = useParams();

  const getData = async () => {
    const response = await fetch(`${url}${actorId}`, {
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
            <th scope="col">Name</th>
            <th scope="col">Sex</th>
            <th scope="col">Date of birth</th>
            <th scope="col">Height (cm)</th>
            <th scope="col">Salary per day</th>
            <th scope="col">Link to actor's picture</th>
          </tr>
        </thead>

        {data && (
          <tbody>
            <tr key={data.id}>
              <th>{data.id}</th>
              <td>{data.name}</td>
              <td>{data.sex}</td>
              <td>{data.dateOfBirth}</td>
              <td>{data.height}</td>
              <td>{data.salaryPerDay}</td>
              <td>{data.linkToPicture}</td>
            </tr>
          </tbody>
        )}
      </table>
    </div>
  );
}
