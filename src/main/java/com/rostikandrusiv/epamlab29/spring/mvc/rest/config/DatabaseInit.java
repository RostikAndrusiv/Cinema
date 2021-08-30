package com.rostikandrusiv.epamlab29.spring.mvc.rest.config;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.*;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.*;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static jdk.nashorn.internal.objects.NativeMath.round;


@Slf4j
@Configuration
public class DatabaseInit {

    private final PasswordEncoder passwordEncoder;

    public DatabaseInit(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner initDatabase(MovieRepository movieRepository, SessionRepository sessionRepository,
                                   RoomRepository roomRepository, SeanceRepository seanceRepository,
                                   TicketRepository ticketRepository, UserService userService, UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            //init movies
            movieRepository.save(new Movie(0, "Dark Tower", 1.5, "Dark Tower description......"));
            movieRepository.save(new Movie(0, "The Green Mile", 1.2, "The Green Mile description......"));
            movieRepository.save(new Movie(0, "The Shawshank Redemption", 2, "The Shawshank Redemption......"));
            movieRepository.save(new Movie(0, "Despicable Me in", 2, "Despicable Me in......"));

            //init sessions
            sessionRepository.save(new Session(0, LocalTime.of(18, 0)));
            sessionRepository.save(new Session(0, LocalTime.of(12, 0)));
            sessionRepository.save(new Session(0, LocalTime.of(9, 0)));
            sessionRepository.save(new Session(0, LocalTime.of(20, 0)));
            sessionRepository.save(new Session(0, LocalTime.of(22, 0)));
            //init rooms
            roomRepository.save(new Room(0, "Black", 10, null));
            roomRepository.save(new Room(0, "Red", 8, null));

//            init seats for each room
            roomRepository.findAll().forEach(room ->{
                List<Seat> seats= new ArrayList<>();
                for (int i = 0; i < room.getNumberOfSeats(); i++) {
                    Seat seat = new Seat();
                    seat.setNumber(i + 1);
                    seats.add(seat);
                    room.setSeats(seats);
                }
                roomRepository.save(room);
            });

            //init random seances
            List<Movie> movies = movieRepository.findAll();
            List<Session> sessions = sessionRepository.findAll();
            List<Room> rooms = roomRepository.findAll();
            for (int i = 0; i < 20; i++) {
                Movie movie = movies.get(randomEntity(movies.size()));
                Session session = sessions.get(randomEntity(sessions.size()));
                Room room = rooms.get(randomEntity(rooms.size()));
                Seance seance = Seance.builder()
                        .movie(movie)
                        .session(session)
                        .room(room)
                        .dateOfSeance(randomDate())
                        .price(randomPrice())
                        .build();
                seanceRepository.save(seance);
            }

            //init tickets for each seance
            seanceRepository.findAll().forEach(seance -> {
                seance.getRoom().getSeats().forEach(seat -> {
                    Ticket ticket = Ticket.builder()
                            .seance(seance)
                            .seat(seat)
                            .booked(false).build();
                    ticketRepository.save(ticket);
                });
            });

//            init roles
            roleRepository.save(new Role(0, "ROLE_ADMIN"));
            roleRepository.save(new Role(0, "ROLE_USER"));

            //init admin and user
            User admin = new User(0, "admin", "admin@admin.com", "admin", null,roleRepository.findByname("ROLE_ADMIN"));
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            userRepository.save(admin);

            User user = new User(0, "user", "user@user.com", "user", null,roleRepository.findByname("ROLE_USER"));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);

        };
    }

    private int randomEntity(int size){
        return new Random().nextInt(size);
    }

    private double randomPrice(){
        double random = ThreadLocalRandom.current().nextDouble(8.5, 15.5);
        return round(random, 2);
    }

    private LocalDate randomDate() {
        long minDay = LocalDate.of(2021, 8, 20).toEpochDay();
        long maxDay = LocalDate.of(2021, 8, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}
