package edu.famu.hotel_booking.model;

import com.google.cloud.firestore.annotation.DocumentId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @DocumentId
    private String userID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private ;

}
