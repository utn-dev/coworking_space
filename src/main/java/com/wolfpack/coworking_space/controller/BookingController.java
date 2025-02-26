package com.wolfpack.coworking_space.controller;

import com.wolfpack.coworking_space.model.Booking;
import com.wolfpack.coworking_space.model.Room;
import com.wolfpack.coworking_space.service.BookingService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<Booking>> findAll() {
        List<Booking> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Void> registerBooking(@RequestBody Booking booking) {
        Booking bookingSaved = service.save(booking);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookingSaved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") Long id, @Valid @RequestBody Booking booking) {
        return ResponseEntity.ok(service.update(id, booking));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
