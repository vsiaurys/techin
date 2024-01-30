package lt.techin.demo;

import lt.techin.demo.models.Actor;
import lt.techin.demo.services.ActorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ActorControllerTest.class)
public class ActorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ActorService actorService;

    @Test
    void getActors_whenFindAll_returnAll() throws Exception {
        given(this.actorService.findAllActors()).willReturn(List.of(
                new Actor("Name 1", 'M', LocalDate.of(1950, 1, 1),
                        (short) 180, (float) 8.2, 100000, "Link to picture 1"),
                new Actor("Name 2", 'W', LocalDate.of(1965, 5, 3),
                        (short) 170, (float) 7.9, 50000, "Link to picture 2")));


        mockMvc.perform(get("/actors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Name 1"))
                .andExpect(jsonPath("$[0].sex").value('M'))
                .andExpect(jsonPath("$[0].dateOfBirth").value("1950 - 01 - 01"))
                .andExpect(jsonPath("$[0].height").value(180))
                .andExpect(jsonPath("$[0].rating").value(8.2))
                .andExpect(jsonPath("$[0].salaryPerDay").value(100000))
                .andExpect(jsonPath("$[0].linkToPicture").value("Link to picture 1"))

                .andExpect(jsonPath("$[1].name").value("Name 2"))
                .andExpect(jsonPath("$[1].sex").value('W'))
                .andExpect(jsonPath("$[1].dateOfBirth").value("1965 - 05 - 03"))
                .andExpect(jsonPath("$[1].height").value(170))
                .andExpect(jsonPath("$[1].rating").value(7.9))
                .andExpect(jsonPath("$[1].salaryPerDay").value(50000))
                .andExpect(jsonPath("$[1].linkToPicture").value("Link to picture 2"));

        verify(this.actorService).findAllActors();

    }

//    @Test
//    void insertMovie_whenSaveMovie_thenReturnIt() throws Exception {
////      given
//        Movie movie = new Movie("Delivery Man", "Ken Scott",
//                (short) 2013, (short) 105);
//        given(this.movieService.saveMovie(any(Movie.class))).willReturn(movie);
//
////      when
//        mockMvc.perform(post("/movies")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(movie)))
////      then
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Delivery Man"))
//                .andExpect(jsonPath("$.director").value("Ken Scott"))
//                .andExpect(jsonPath("$.yearReleased").value(2013))
//                .andExpect(jsonPath("$.lengthMinutes").value(105));
//
//        verify(this.movieService).saveMovie(any(Movie.class));
//    }
//
//    @Test
//    void updateMovie_whenUpdateFields_thenReturn() throws Exception {
//
//        // given
//        Movie existingMovie = new Movie("Existing Movie", "Director 1",
//                (short) 2013, (short) 105);
//        Movie updatedMovie = new Movie("Updated Movie", "Director 2",
//                (short) 2023, (short) 90);
//
//        given(this.movieService.existsMovieById(anyLong())).willReturn(true);
//        given(this.movieService.findMovieById(anyLong()))
//                .willReturn(existingMovie);
//        given(this.movieService.saveMovie(any(Movie.class)))
//                .willReturn(updatedMovie);
//
//
//        //when
//        mockMvc.perform(put("/movies/{id}", 1)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(updatedMovie))
//                        .accept(MediaType.APPLICATION_JSON))
//
//                //then
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Updated Movie"))
//                .andExpect(jsonPath("$.director").value("Director 2"))
//                .andExpect(jsonPath("$.yearReleased").value(2023))
//                .andExpect(jsonPath("$.lengthMinutes").value(90));
//
//        verify(this.movieService).existsMovieById(1L);
//        verify(this.movieService).findMovieById(1L);
//        verify(this.movieService).saveMovie(argThat(m -> {
//                    assertThat(m.getTitle()).isEqualTo("Updated Movie");
//                    assertThat(m.getDirector()).isEqualTo("Director 2");
//                    assertThat(m.getYearReleased()).isEqualTo((short) 2023);
//                    assertThat(m.getLengthMinutes()).isEqualTo((short) 90);
//
//                    return true;
//                }
//        ));
//    }
//
//    @Test
//    void updateMovie_whenNoMovieFound_addNewOne() throws Exception {
//        // given
//        Movie newMovie = new Movie("New Movie", "Director 3",
//                (short) 2023, (short) 123);
//
//        given(this.movieService.existsMovieById(anyLong())).willReturn(false);
//        given(this.movieService.saveMovie(any(Movie.class)))
//                .willReturn(newMovie);
//        //when
//        mockMvc.perform(put("/movies/{id}", 11)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(newMovie))
//                        .accept(MediaType.APPLICATION_JSON))
//
//                //then
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("New Movie"))
//                .andExpect(jsonPath("$.director").value("Director 3"))
//                .andExpect(jsonPath("$.yearReleased").value(2023))
//                .andExpect(jsonPath("$.lengthMinutes").value(123));
//
//        verify(this.movieService).existsMovieById(11L);
//        verify(this.movieService, never()).findMovieById(anyLong());
//
//        verify(this.movieService).saveMovie(
//                argThat(persistedMovie -> persistedMovie.getTitle()
//                        .equals("New Movie")));
//    }
//
//    @Test
//    void deleteMovie_deleteMovieById_returnNothing() throws Exception {
//
//        mockMvc.perform(delete("/movies/{id}", 11L))
//                .andExpect(status().isOk());
//
//        verify(this.movieService).deleteMovieById(11L);
//    }
//
//    @Test
//    void getMovieById_GetMovie_returnMovie() throws Exception {
//
//        Movie movie = new Movie("Delivery Man", "Ken Scott",
//                (short) 2013, (short) 105);
//
//        given(this.movieService.findMovieById(anyLong())).willReturn(movie);
//
//        mockMvc.perform(get("/movies/{id}", 2L))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Delivery Man"))
//                .andExpect(jsonPath("$.director").value("Ken Scott"))
//                .andExpect(jsonPath("$.yearReleased").value(2013))
//                .andExpect(jsonPath("$.lengthMinutes").value(105));
//
//        verify(this.movieService).findMovieById(2L);
//    }
}