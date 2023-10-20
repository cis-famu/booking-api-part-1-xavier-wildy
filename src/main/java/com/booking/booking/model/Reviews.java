package com.booking.booking.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
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
    private Timestamp date;

    public void date(Timestamp date) throws ParseException {
        this.date = Timestamp.fromProto(Timestamp.fromProto(Timestamp.parseTimestamp(String.valueOf(date)).toProto()).toProto());
    }
}