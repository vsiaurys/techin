import "./Header.css";

export default function Header() {
  return (
    <div className="header">
      <h1 className="header__title">Page title</h1>
      <img
        src="../img/tiger.jpg"
        alt="A tiger's portrait"
        className="header__img w-100 object-fit-cover"
      />
    </div>
  );
}
