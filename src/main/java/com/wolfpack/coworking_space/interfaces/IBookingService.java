package com.wolfpack.coworking_space.interfaces;

import com.wolfpack.coworking_space.model.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking save(Booking booking);

    Booking update(Long id, Booking booking);

    List<Booking> findAll();

    Optional<Booking> findById(Long id);

    void delete(Long id);
}

