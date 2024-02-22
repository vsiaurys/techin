import { Route, Routes } from "react-router-dom";
import Home from "./Home";
import Actors from "./Actors";
import Actor from "./Actor";
import Movies from "./Movies";
import Movie from "./Movie";
import ErrorPage from "./ErrorPage";

export default function Main() {
  return (
    <>
      <main>
        <Routes>
          <Route
            path="/"
            element={<Home />}
          />
          <Route
            path="/movies"
            element={<Movies />}
          />
          <Route
            path="/movies/:movieId"
            element={<Movie />}
          />
          <Route
            path="/actors"
            element={<Actors />}
          />
          <Route
            path="/actors/:actorId"
            element={<Actor />}
          />
          <Route
            path="*"
            element={<ErrorPage />}
          />
        </Routes>
      </main>
    </>
  );
}
