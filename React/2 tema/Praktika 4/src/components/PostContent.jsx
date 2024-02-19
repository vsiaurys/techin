import "./PostContent.css";

export default function PostContent({
  title,
  content,
  img,
  setLearnt,
  id,
  status,
}) {
  return (
    <div className="card mx-5">
      <h5 className="card-title">{title}</h5>
      <img
        src={img}
        className="card-img-top"
        alt={title}
      />
      <div className="card-body">
        <p className="card-text">{content}</p>
        <p className="card-text">{status ? "Išmokau" : "Mokausi"}</p>
        <button
          onClick={() => setLearnt(id)}
          type="button"
          className="bs-secondary-bg"
        >
          OK
        </button>
      </div>
    </div>
  );
}
