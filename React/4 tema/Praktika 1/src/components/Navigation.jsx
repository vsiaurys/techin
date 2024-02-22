import { Route, Routes, NavLink } from "react-router-dom";
import Home from "./Home";
import Actor from "./Actor";
import Movie from "./Movie";
import ErrorPage from "./ErrorPage";

export default function Navigation() {
  return (
    <>
      <header>
        <nav>
          <ul>
            <li>
              <NavLink to="/">Home</NavLink>
            </li>
            <li>
              <NavLink to="/movies">Movies</NavLink>
            </li>
            <li>
              <NavLink to="/actors">Actors</NavLink>
            </li>
          </ul>
        </nav>
      </header>
      <main>
        <Routes>
          <Route
            path="/"
            element={<Home />}
          />
          <Route
            path="/movies"
            element={<Movie />}
          />
          <Route
            path="/actors"
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
