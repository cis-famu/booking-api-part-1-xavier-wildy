package edu.famu.hotel_booking.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    @DocumentId
    private String reviewID;
    private String hotelID;
    private String UserID;
    private Float rating;
    private String comment;
    private Date date;
}
