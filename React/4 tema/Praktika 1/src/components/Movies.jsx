import { useState, useEffect } from "react";

export default function Movies() {
  const url = "http://localhost:8080/";
  const [data, setData] = useState([]);
  const [del, setDel] = useState(0);

  const getData = async () => {
    const response = await fetch(`${url}movies`, {
      method: "GET",
      headers: { Authorization: "Basic " + btoa("aaaaaaaa:bbbbbbbb") },
    });
    const resp = await response.json();
    setData(resp);
  };

  const deleteData = async (id) => {
    console.log(`${url}movies/${id}`);
    try {
      const response = await fetch(`${url}movies/${id}`, {
        method: "DELETE",
        headers: { Authorization: "Basic " + btoa("aaaaaaaa:bbbbbbbb") },
      });
    } catch (error) {
      console.error("Error deleting movie:", error);
    }

    setDel(id);
  };

  useEffect(() => {
    getData();
  }, [del]);

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
          {data.map((d) => {
            return (
              <tr key={d.id}>
                <th scope="row">{d.id}</th>
                <td>{d.title}</td>
                <td>{d.dateReleased}</td>
                <td>{d.lengthMinutes}</td>
                <td>
                  <button
                    className="btn btn-primary"
                    onClick={() => deleteData(d.id)}
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
