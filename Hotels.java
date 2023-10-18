package edu.famu.hotel_booking.model;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotels {
    @DocumentId
    private String hotelID; 
    private String name;
    private String description;
    private Float rating;
    private String address;
    private String contactInformation;
    private 
}
