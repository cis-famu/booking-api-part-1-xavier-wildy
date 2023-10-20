package com.booking.booking.model;


import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotels {
    @DocumentId
    private String hotelID;
    private String name;
    private String description;
    private double rating;
    private String address;
    private String contactInformation;
    private ArrayList<String> amenities;
}
