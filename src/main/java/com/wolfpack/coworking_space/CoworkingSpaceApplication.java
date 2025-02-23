package com.wolfpack.coworking_space;

import com.wolfpack.coworking_space.model.Booking;
import com.wolfpack.coworking_space.model.Room;
import com.wolfpack.coworking_space.model.RoomStatus;
import com.wolfpack.coworking_space.repository.BookingRepository;
import com.wolfpack.coworking_space.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class CoworkingSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoworkingSpaceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(RoomRepository roomRepository, BookingRepository bookingRepository) {
        return args -> {
            // Create a room
            Room room = new Room(null, "Meeting Room A", 10, RoomStatus.AVAILABLE);
            room = roomRepository.save(room);

            // Create a booking
            Booking booking = new Booking(null, room, "John Doe", LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(12, 0));
            bookingRepository.save(booking);

            System.out.println("Booking saved: Room=" + booking.getRoom().getName() + ", User=" + booking.getUser());
        };
    }

}
