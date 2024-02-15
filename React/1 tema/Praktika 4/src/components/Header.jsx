import "./Header.css";

export default function Header({ title, source }) {
  return (
    <div className="header">
      <h1 className="header__title">{title}</h1>
      <img
        src={source}
        alt="A tiger's portrait"
        className="header__img w-100 object-fit-cover"
      />
    </div>
  );
}
