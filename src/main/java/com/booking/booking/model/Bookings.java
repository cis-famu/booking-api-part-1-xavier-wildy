package com.booking.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.google.cloud.Timestamp;

import java.text.ParseException;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookings {
    private String bookingID;
    private String userID;
    private Timestamp checkInDate;
    private Timestamp checkOutDate;
    private Float totalPrice;
    private String status;


    public void checkInDate(Timestamp checkInDate) throws ParseException {
        this.checkInDate = Timestamp.fromProto(Timestamp.fromProto(Timestamp.parseTimestamp(String.valueOf(checkInDate)).toProto()).toProto());
    }

    public void checkOutDate(Timestamp checkOutDate) throws ParseException {
        this.checkOutDate = Timestamp.fromProto(Timestamp.fromProto(Timestamp.parseTimestamp(String.valueOf(checkOutDate)).toProto()).toProto());
    }

}