package org.docencia.hotel.persistence.jpa;

import org.docencia.hotel.domain.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelJpaRepository extends JpaRepository<Hotel, String> {
}
