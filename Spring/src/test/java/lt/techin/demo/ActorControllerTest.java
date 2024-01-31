package lt.techin.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.controllers.ActorController;
import lt.techin.demo.models.Actor;
import lt.techin.demo.services.ActorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ActorController.class)
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
                .andExpect(jsonPath("$[0].sex").value("M"))
                .andExpect(jsonPath("$[0].dateOfBirth").value("1950-01-01"))
                .andExpect(jsonPath("$[0].height").value(180))
                .andExpect(jsonPath("$[0].rating").value(8.2))
                .andExpect(jsonPath("$[0].salaryPerDay").value(100000))
                .andExpect(jsonPath("$[0].linkToPicture").value("Link to picture 1"))

                .andExpect(jsonPath("$[1].name").value("Name 2"))
                .andExpect(jsonPath("$[1].sex").value("W"))
                .andExpect(jsonPath("$[1].dateOfBirth").value("1965-05-03"))
                .andExpect(jsonPath("$[1].height").value(170))
                .andExpect(jsonPath("$[1].rating").value(7.9))
                .andExpect(jsonPath("$[1].salaryPerDay").value(50000))
                .andExpect(jsonPath("$[1].linkToPicture").value("Link to picture 2"));

        verify(this.actorService).findAllActors();

    }

    @Test
    void insertActor_whenSaveActor_thenReturnIt() throws Exception {
//      given
        Actor actor = new Actor("Name 2", 'W', LocalDate.of(1965, 5, 3),
                (short) 170, (float) 7.9, 50000, "Link to picture 2");
        given(this.actorService.saveActor(any(Actor.class))).willReturn(actor);

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();
//      when
        mockMvc.perform(post("/actors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(actor)))
//      then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Name 2"))
                .andExpect(jsonPath("$.sex").value("W"))
                .andExpect(jsonPath("$.dateOfBirth").value("1965-05-03"))
                .andExpect(jsonPath("$.height").value(170))
                .andExpect(jsonPath("$.rating").value(7.9))
                .andExpect(jsonPath("$.salaryPerDay").value(50000))
                .andExpect(jsonPath("$.linkToPicture").value("Link to picture 2"));

        verify(this.actorService).saveActor(any(Actor.class));
    }

    @Test
    void updateActor_whenUpdateFields_thenReturn() throws Exception {

        // given
        Actor existingActor = new Actor("Name 1", 'M', LocalDate.of(1950, 1, 1),
                (short) 180, (float) 8.2, 100000, "Link to picture 1");
        Actor updatedActor = new Actor("Name 2", 'W', LocalDate.of(1965, 5, 3),
                (short) 170, (float) 7.9, 50000, "Link to picture 2");

        given(this.actorService.existsActorById(anyLong())).willReturn(true);
        given(this.actorService.findActorById(anyLong()))
                .willReturn(existingActor);
        given(this.actorService.saveActor(any(Actor.class)))
                .willReturn(updatedActor);

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();
        //when
        mockMvc.perform(put("/actors/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(updatedActor))
                        .accept(MediaType.APPLICATION_JSON))

                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Name 2"))
                .andExpect(jsonPath("$.sex").value("W"))
                .andExpect(jsonPath("$.dateOfBirth").value("1965-05-03"))
                .andExpect(jsonPath("$.height").value(170))
                .andExpect(jsonPath("$.rating").value(7.9))
                .andExpect(jsonPath("$.salaryPerDay").value(50000))
                .andExpect(jsonPath("$.linkToPicture").value("Link to picture 2"));


        verify(this.actorService).existsActorById(1L);
        verify(this.actorService).findActorById(1L);
        verify(this.actorService).saveActor(argThat(m -> {
                    assertThat(m.getName()).isEqualTo("Name 2");
                    assertThat(m.getSex()).isEqualTo('W');
                    assertThat(m.getDateOfBirth()).isEqualTo("1965-05-03");
                    assertThat(m.getHeight()).isEqualTo((short) 170);
                    assertThat(m.getRating()).isEqualTo((float) 7.9);
                    assertThat(m.getSalaryPerDay()).isEqualTo(50000);
                    assertThat(m.getLinkToPicture()).isEqualTo("Link to picture 2");

                    return true;
                }
        ));
    }


    @Test
    void updateActor_whenNoActorFound_addNewOne() throws Exception {
        // given
        Actor newActor = new Actor("New Name", 'W', LocalDate.of(1965, 5, 3),
                (short) 170, (float) 7.9, 50000, "Link to picture 2");

        given(this.actorService.existsActorById(anyLong())).willReturn(false);
        given(this.actorService.saveActor(any(Actor.class)))
                .willReturn(newActor);

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();
        //when
        mockMvc.perform(put("/actors/{id}", 11)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(newActor))
                        .accept(MediaType.APPLICATION_JSON))

                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("New Name"))
                .andExpect(jsonPath("$.sex").value("W"))
                .andExpect(jsonPath("$.dateOfBirth").value("1965-05-03"))
                .andExpect(jsonPath("$.height").value(170))
                .andExpect(jsonPath("$.rating").value(7.9))
                .andExpect(jsonPath("$.salaryPerDay").value(50000))
                .andExpect(jsonPath("$.linkToPicture").value("Link to picture 2"));

        verify(this.actorService).existsActorById(11L);
        verify(this.actorService, never()).findActorById(anyLong());

        verify(this.actorService).saveActor(
                argThat(persistedMovie -> persistedMovie.getName()
                        .equals("New Name")));
    }

    @Test
    void deleteActor_deleteActorById_returnNothing() throws Exception {

        mockMvc.perform(delete("/actors/{id}", 11L))
                .andExpect(status().isOk());

        verify(this.actorService).deleteActorById(11L);
    }

    @Test
    void getActorById_getActor_returnActor() throws Exception {

        Actor actor = new Actor("Name 2", 'W', LocalDate.of(1965, 5, 3),
                (short) 170, (float) 7.9, 50000, "Link to picture 2");

        given(this.actorService.findActorById(anyLong())).willReturn(actor);

        mockMvc.perform(get("/actors/{id}", 2L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Name 2"))
                .andExpect(jsonPath("$.sex").value("W"))
                .andExpect(jsonPath("$.dateOfBirth").value("1965-05-03"))
                .andExpect(jsonPath("$.height").value(170))
                .andExpect(jsonPath("$.rating").value(7.9))
                .andExpect(jsonPath("$.salaryPerDay").value(50000))
                .andExpect(jsonPath("$.linkToPicture").value("Link to picture 2"));

        verify(this.actorService).findActorById(2L);
    }
}