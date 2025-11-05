package org.docencia.hotel.domain.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue
    String id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @Column(name = "room")
    Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    @Column(name = "guest")
    Guest guest;


    public Booking() {
    }

    public Booking(String id){
        this.id = id;
    }

    public Booking(String id, Room room, Guest guest) {
        this.id = id;
        this.room = room;
        this.guest = guest;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return this.guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }


    public Booking room(Room room) {
        setRoom(room);
        return this;
    }

    public Booking guest(Guest guest) {
        setGuest(guest);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", room='" + getRoom() + "'" +
            ", guest='" + getGuest() + "'" +
            "}";
    }
}