package edu.famu.hotel_booking.model;

import com.google.cloud.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Booking
{
    private Passenger passengerID;
    private Flight flightNumber;
    private Payment paymentNumber;

    public Booking(String bookingID, Timestamp bookingDateTime, String seatNumber, String flightClass, double price, Passenger passengerID, Flight flightNumber, Payment paymentNumber) {
        super(bookingID, bookingDateTime, seatNumber, flightClass, price);
        this.passengerID = passengerID;
        this.flightNumber = flightNumber;
        this.paymentNumber = paymentNumber;
    }
}
