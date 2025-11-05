package org.docencia.hotel.repository;

import org.docencia.hotel.domain.model.Guest;
import java.util.List;
import java.util.Optional;

public interface GuestRepository {
    boolean existsById(String id);

    Optional<Guest> findById(String id);

    List<Guest> findAll();

    Guest save(Guest guest);

    void deleteById(String id);
}
