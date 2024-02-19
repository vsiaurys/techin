import { useState } from "react";

export default function LessText({ text, maxLength }) {
  const [readMore, setReadMore] = useState(true);
  const less = text.substring(0, maxLength);

  const showMore = () => {
    setReadMore(!readMore);
  };

  return (
    <div className="border border-success m-3">
      <p>
        {readMore ? less : text}
        <a
          onClick={showMore}
          href="#"
        >
          {readMore ? " ...Read more" : " ...Read less"}
        </a>
      </p>
    </div>
  );
}
