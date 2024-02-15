export default function PostContent(props) {
  const { title, content, source } = props;
  return (
    <div className="col-4">
      <h3>{title}</h3>
      <img
        src={source}
        alt={title}
        className="rounded-circle img-fluid"
      />
      <p>{content}</p>
    </div>
  );
}
