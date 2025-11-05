package org.docencia.hotel.persistence;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.persistence.jpa.HotelJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class HotelRepositoryTest {
    
    @Autowired
    private HotelJpaRepository hotelRepository;
    
    @Test
    void testSaveAndFindHotel() {
        Hotel hotel = new Hotel();
        hotel.setId("H001");
        hotel.setName("Hotel Paradise");
        hotel.setAddress("Calle Falsa 123");
        
        Hotel saved = hotelRepository.save(hotel);
        assertNotNull(saved.getId());
    }
}
