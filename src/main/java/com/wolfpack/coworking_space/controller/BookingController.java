package com.wolfpack.coworking_space.controller;

import com.wolfpack.coworking_space.model.Booking;
import com.wolfpack.coworking_space.model.Room;
import com.wolfpack.coworking_space.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;

    @GetMapping
    public ResponseEntity<List<Booking>> findAll()  {
        List<Booking> list = service.findAll();

        return  ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable Long id)  {
        Booking booking = service.findById(id).orElse(new Booking()); // Mejorar la parte del opcional para no trabajarlo en el controller

        return  ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<Void> registerBooking (@RequestBody Booking booking)  {
        Booking bookingSaved = service.save(booking);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookingSaved.getId()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable("id") Long id)  {
        booking.setId(id);

        Booking bookingUpdated =service.update(id, booking);

        return  ResponseEntity.ok(bookingUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Long id){
        service.delete(id);

        return  ResponseEntity.noContent().build();
    }
}
