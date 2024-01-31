package lt.techin.demo;

//@WebMvcTest(controllers = BoxOfficeController.class)
//public class BoxOfficeControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private BoxOfficeService boxOfficeService;
//
//    @Test
//    void getBoxOffices_saveBoxOffices_returnAll() throws Exception {
//        given(this.boxOfficeService.findAllBoxOffices()).willReturn(List.of(
//                new BoxOffice(121L, 122L,(float) 9.0, 10000001,
//                        20000001),
//                new BoxOffice(312L, (float) 7.8"Stephen Spielberg",
//                        (short) 1999, (short) 120)));
//
//        mockMvc.perform(get("/movies"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].title").value("Madagascar"))
//                .andExpect(jsonPath("$[0].director").value("Stephen Spielberg"))
//                .andExpect(jsonPath("$[0].yearReleased").value(2005))
//                .andExpect(jsonPath("$[0].lengthMinutes").value(60))
//
//                .andExpect(jsonPath("$[1].title").value("Home Alone"))
//                .andExpect(jsonPath("$[1].director").value("Stephen Spielberg"))
//                .andExpect(jsonPath("$[1].yearReleased").value(1999))
//                .andExpect(jsonPath("$[1].lengthMinutes").value(120));
//
//        verify(this.movieService).findAllMovies();
//
//    }
//}
