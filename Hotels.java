package edu.famu.hotel_booking.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.firebase.database.annotations.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft {
    @DocumentId
    private @Nullable String aircraftID;
    private String aircraftType;
    private int firstClassSeats;
    private int businessClassSeats;
    private int mainClassSeats;
}
