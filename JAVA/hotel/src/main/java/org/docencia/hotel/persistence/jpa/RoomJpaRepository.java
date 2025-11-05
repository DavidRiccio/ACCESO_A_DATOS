package org.docencia.hotel.persistence.jpa;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.repository.RoomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomJpaRepository extends JpaRepository<Room, String>, RoomRepository {

    @Override
    List<Room> findByHotelId(String hotelId);
}
