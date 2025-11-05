package org.docencia.hotel.domain.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.transaction.Transactional;

class HotelModelTest {

    private Hotel hotel;
    private Room room1;
    private Room room2;


    @BeforeEach
    @Transactional
    void beforeEach() {
        hotel = new Hotel();
    }

    @Test
    void EqualsTest() {
        hotel.setId("H1");
        hotel.setName("Hotel");
        hotel.setAddress("Calle Las Fresas");
        Hotel hotel2 = new Hotel("H1", "Hotel", "Calle Las Fresas", null);
        Assertions.assertTrue(hotel.equals(hotel2));
    }

        @Test
    void EqualsObjectTest() {
        hotel.setId("H1");
        hotel.setName("Hotel");
        hotel.setAddress("Calle Las Fresas");
        Hotel hotel2 = new Hotel("H1", "Hotel", "Calle Las Fresas", null);
        Assertions.assertTrue(hotel2.equals(hotel2));
    }

    @Test
    void EqualsIsNotObjectTest() {
        Assertions.assertFalse(hotel.equals("hotel"));
    }

    @Test
    void GetAdressTest() {
        String address = hotel.getAddress();
        Assertions.assertEquals(address, hotel.getAddress());
    }

    @Test
    void GetIdTest() {
        String id = hotel.getId();
        Assertions.assertEquals(id, hotel.getId());
    }

    @Test
    void GetNameTest() {
        String name = hotel.getName();
        Assertions.assertEquals(name, hotel.getName());
    }

    @Test
    void SetRoomsTest() {
        
    }

}
