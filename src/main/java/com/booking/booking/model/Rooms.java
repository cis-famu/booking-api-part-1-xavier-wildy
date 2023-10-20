package com.booking.booking.model;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {
    @DocumentId
    private String roomID;
    private String hotelID;
    private String roomType;
    private float price;
    private int capacity;
    private String description;
    private String availability;
    private ArrayList<String> images;
}
