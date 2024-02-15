import PostContent from "./PostContent";
import { v4 as uuidv4 } from "uuid";

export default function PostList() {
  const posts = [
    {
      title: "First post title",
      content: "Lorem, ipsum dolor sit amet consectetur adipisicing elit.",
      source: "src/assets/lion.jpg",
    },
    {
      title: "Second post title",
      content:
        "Quam nisivelit id dolorem, quisquam perspiciatis provident enim reprehenderit.",
      source: "src/assets/cat.jpg",
    },
    {
      title: "Third post title",
      content:
        "Aliquam quod cum minima at dignissimos aut facilis eius ducimus laboreasperiores.",
      source: "src/assets/tiger.jpg",
    },
  ];

  const list = posts.map((post) => {
    return (
      <PostContent
        key={uuidv4()}
        title={post.title}
        content={post.content}
        source={post.source}
      />
    );
  });

  return <div className="row">{list}</div>;
}
