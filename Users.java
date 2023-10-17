package edu.famu.hotel_booking.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;

import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @DocumentId
    private String passengerID;
    private String firstName;
    private String lastName;
    private Timestamp dateOfBirth; //use google cloud timestamp
    private String email;
    private String phone;
    private String address;
    private String rewardsNumber;

    public void setDateOfBirth(String dateOfBirth) throws ParseException {
        this.dateOfBirth = Timestamp.fromProto(Timestamps.parse(dateOfBirth));
    }
}
