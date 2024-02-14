import "./Box.css";

export default function Box({ boxColor }) {
  return <div className={`${boxColor} box`}></div>;
}
