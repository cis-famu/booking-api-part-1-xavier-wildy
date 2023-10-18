package edu.famu.hotel_booking.model;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {
    @DocumentId
    private String roomID;
    private String hotelID;
    private String roomType;
    private Float price;
    private Int capacity;
    private String description;
    private String availability;
    private ;
}
