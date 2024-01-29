package lt.techin.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import lt.techin.demo.controllers.MovieController;
import lt.techin.demo.models.Movie;
import lt.techin.demo.services.MovieService;

@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MovieService movieService;

    @Test
    void getMovies_saveMovies_returnAll() throws Exception {
        given(this.movieService.findAllMovies()).willReturn(List.of(
                new Movie("Madagascar", "Stephen Spielberg",
                        (short) 2005, (short) 60),
                new Movie("Home Alone", "Stephen Spielberg",
                        (short) 1999, (short) 120)));

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Madagascar"))
                .andExpect(jsonPath("$[0].director").value("Stephen Spielberg"))
                .andExpect(jsonPath("$[0].yearReleased").value(2005))
                .andExpect(jsonPath("$[0].lengthMinutes").value(60))

                .andExpect(jsonPath("$[1].title").value("Home Alone"))
                .andExpect(jsonPath("$[1].director").value("Stephen Spielberg"))
                .andExpect(jsonPath("$[1].yearReleased").value(1999))
                .andExpect(jsonPath("$[1].lengthMinutes").value(120));

        verify(this.movieService).findAllMovies();

    }

    @Test
    void insertMovie_whenSaveMovie_thenReturnIt() throws Exception {
//      given
        Movie movie = new Movie("Delivery Man", "Ken Scott",
                (short) 2013, (short) 105);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(movie);

//      when
        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(movie)))
//      then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Delivery Man"))
                .andExpect(jsonPath("$.director").value("Ken Scott"))
                .andExpect(jsonPath("$.yearReleased").value(2013))
                .andExpect(jsonPath("$.lengthMinutes").value(105));

        verify(this.movieService).saveMovie(any(Movie.class));
    }
}