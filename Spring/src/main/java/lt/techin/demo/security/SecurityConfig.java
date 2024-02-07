package lt.techin.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//
//        UserDetails user = User.withUsername("vvv")
//                .password("11111")
//                .authorities("ADMIN")
//                .build();
//
//        userDetailsManager.createUser(user);
//
//        return userDetailsManager;
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/movies").permitAll()
                        .requestMatchers(HttpMethod.GET, "/movies/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/movies").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/movies").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/movies/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/movies/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/actors").permitAll()
                        .requestMatchers(HttpMethod.GET, "/actors/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/actors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/actors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/actors/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/actors/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/directors").permitAll()
                        .requestMatchers(HttpMethod.GET, "/directors/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/directors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/directors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/directors/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/directors/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/actorsmovies").permitAll()
                        .requestMatchers(HttpMethod.GET, "/actors/{directorId}/movies/{movieId}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/actorsmovies").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/directorsmovies").permitAll()
                        .requestMatchers(HttpMethod.GET, "/directors/{directorId}/movies/{movieId}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/directorsmovies").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/directors/{directorId}/movies/{movieId}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/reviews").permitAll()
                        .requestMatchers(HttpMethod.GET, "/reviews/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/reviews").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/review/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/reviews/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}