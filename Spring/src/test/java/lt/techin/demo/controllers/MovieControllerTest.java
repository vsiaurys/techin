package lt.techin.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.models.Movie;
import lt.techin.demo.security.SecurityConfig;
import lt.techin.demo.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MovieService movieService;

    @Test
    void getMovies_saveMovies_returnAll() throws Exception {
//  given
        given(this.movieService.findAllMovies()).willReturn(List.of(
                new Movie("Madagascar", LocalDate.of(1976, 5, 13), (short) 60),
                new Movie("Home Alone", LocalDate.of(2000, 11, 19), (short) 120)));
//  when
        mockMvc.perform(get("/movies"))

//  then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Madagascar"))
                .andExpect(jsonPath("$[0].dateReleased").value("1976-05-13"))
                .andExpect(jsonPath("$[0].lengthMinutes").value(60))

                .andExpect(jsonPath("$[1].title").value("Home Alone"))
                .andExpect(jsonPath("$[1].dateReleased").value("2000-11-19"))
                .andExpect(jsonPath("$[1].lengthMinutes").value(120));

        verify(this.movieService).findAllMovies();

    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void insertMovie_whenSaveMovie_thenReturnIt() throws Exception {
//  given
        Movie movie = new Movie("Delivery Man", LocalDate.of(2000, 11, 19), (short) 105);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(movie);

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();

//  when
        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(movie)))
//  then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Delivery Man"))
                .andExpect(jsonPath("$.dateReleased").value("2000-11-19"))
                .andExpect(jsonPath("$.lengthMinutes").value(105));

        verify(this.movieService).saveMovie(any(Movie.class));
    }

    @Test
    @WithMockUser
    void insertMovie_whenNotAllowed_return403() throws Exception {
//  given
        Movie movie = new Movie("Delivery Man", LocalDate.of(2000, 11, 19), (short) 105);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(movie);

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();

//  when
        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(movie)))

//  then
                .andExpect(status().isForbidden());

        verify(this.movieService, times(0)).saveMovie(any(Movie.class));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void updateMovie_whenUpdateFields_thenReturn() throws Exception {
//  given
        Movie existingMovie = new Movie("Existing Movie", LocalDate.of(1976, 5, 13), (short) 105);
        Movie updatedMovie = new Movie("Updated Movie", LocalDate.of(2000, 11, 19), (short) 90);

        given(this.movieService.existsMovieById(anyLong())).willReturn(true);
        given(this.movieService.findMovieById(anyLong()))
                .willReturn(existingMovie);
        given(this.movieService.saveMovie(any(Movie.class)))
                .willReturn(updatedMovie);

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();

//  when
        mockMvc.perform(put("/movies/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(updatedMovie))
                        .accept(MediaType.APPLICATION_JSON))

//  then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Movie"))
                .andExpect(jsonPath("$.dateReleased").value("2000-11-19"))
                .andExpect(jsonPath("$.lengthMinutes").value(90));

        verify(this.movieService).existsMovieById(1L);
        verify(this.movieService).findMovieById(1L);
        verify(this.movieService).saveMovie(argThat(m -> {
                    assertThat(m.getTitle()).isEqualTo("Updated Movie");
                    assertThat(m.getDateReleased()).isEqualTo("2000-11-19");
                    assertThat(m.getLengthMinutes()).isEqualTo((short) 90);

                    return true;
                }
        ));
    }

    @Test
    @WithMockUser
    void updateMovie_whenNotAllowed_return403() throws Exception {
//  given
        Movie movie = new Movie("Delivery Man", LocalDate.of(2000, 11, 19), (short) 105);

        given(this.movieService.existsMovieById(anyLong())).willReturn(true);

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();

//  when
        mockMvc.perform(put("/movies/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(movie)))
//  then
                .andExpect(status().isForbidden());

        verify(this.movieService, times(0)).existsMovieById(anyLong());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void updateMovie_whenNoMovieFound_addNewOne() throws Exception {
//  given
        Movie newMovie = new Movie("New Movie", LocalDate.of(2000, 11, 19), (short) 123);

        given(this.movieService.existsMovieById(anyLong())).willReturn(false);
        given(this.movieService.saveMovie(any(Movie.class)))
                .willReturn(newMovie);

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();
//  when
        mockMvc.perform(put("/movies/{id}", 11)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(newMovie))
                        .accept(MediaType.APPLICATION_JSON))

//  then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Movie"))
                .andExpect(jsonPath("$.dateReleased").value("2000-11-19"))
                .andExpect(jsonPath("$.lengthMinutes").value(123));

        verify(this.movieService).existsMovieById(11L);
        verify(this.movieService, never()).findMovieById(anyLong());

        verify(this.movieService).saveMovie(
                argThat(persistedMovie -> persistedMovie.getTitle()
                        .equals("New Movie")));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void deleteMovie_whenMovieExists_return204() throws Exception {
//  given
        given(this.movieService.existsMovieById(anyLong())).willReturn(true);

//  when
        mockMvc.perform(delete("/movies/{id}", 11L))

// then
                .andExpect(status().isNoContent());

        verify(this.movieService).deleteMovieById(11L);
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void deleteMovie_whenNoMovieFound_return404() throws Exception {
//  given
        given(this.movieService.existsMovieById(anyLong())).willReturn(false);

//  when
        mockMvc.perform(delete("/movies/{id}", 11L))

//  then
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    void deleteMovie_whenNotAllowed_return403() throws Exception {
//  given
        given(this.movieService.existsMovieById(anyLong())).willReturn(true);

//  when
        mockMvc.perform(delete("/movies/{id}", 11L))

//  then
                .andExpect(status().isForbidden());

        verify(this.movieService, times(0)).existsMovieById(11L);
    }

    @Test
    void getMovieById_GetMovie_returnMovie() throws Exception {
//  given
        Movie movie = new Movie("Delivery Man", LocalDate.of(2000, 11, 19), (short) 105);

        given(this.movieService.findMovieById(anyLong())).willReturn(movie);

//  when
        mockMvc.perform(get("/movies/{id}", 2L))

//  then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Delivery Man"))
                .andExpect(jsonPath("$.dateReleased").value("2000-11-19"))
                .andExpect(jsonPath("$.lengthMinutes").value(105));

        verify(this.movieService).findMovieById(2L);
    }
}
