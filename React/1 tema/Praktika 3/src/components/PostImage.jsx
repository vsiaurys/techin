export default function PostImage(props) {
  return (
    <img
      src={props.source}
      alt="A tiger's portrait"
      className="rounded-circle img-fluid"
    />
  );
}
