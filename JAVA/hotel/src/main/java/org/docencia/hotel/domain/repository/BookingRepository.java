package org.docencia.hotel.domain.repository;

import org.docencia.hotel.domain.model.Booking;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    boolean existsById(String id);

    Optional<Booking> findById(String id);

    List<Booking> findAll();

    Booking save(Booking booking);

    void deleteById(String id);

    // Método específico de dominio
    List<Booking> findByRoomIdAndDateRange(String roomId, LocalDate startDate, LocalDate endDate);
}
