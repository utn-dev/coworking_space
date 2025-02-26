package com.wolfpack.coworking_space.controller;

import com.wolfpack.coworking_space.model.Booking;
import com.wolfpack.coworking_space.model.Room;
import com.wolfpack.coworking_space.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService service;

    @GetMapping
    public ResponseEntity<List<Room>> findAll()  {
        List<Room> list = service.findAll();

        return  ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Void> registerRoom (@RequestBody Room room)  {
        Room roomSaved = service.save(room);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(roomSaved.getId()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable("id") Long id, @Valid @RequestBody Room room) {
        return ResponseEntity.ok(service.update(id, room));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable("id") Long id){
        service.delete(id);

        return  ResponseEntity.noContent().build();
    }
}
