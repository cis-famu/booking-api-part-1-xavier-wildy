package edu.famu.hotel_booking.model;

import com.google.cloud.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Booking
{
    private String bookingID;
    private String userID;
    private Date checkInDate;
    private Date checkOutDate;
    private Float totalPrice;
    private String status;

}
