package org.docencia.hotel.persistence.jpa;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.repository.GuestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestJpaRepository extends JpaRepository<Guest, String>, GuestRepository {
}
