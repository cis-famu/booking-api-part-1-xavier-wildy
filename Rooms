package edu.famu.airline.model;

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
public class Flight {
    @DocumentId
    private  String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private Timestamp departureDateTime;
    private Timestamp arrivalDateTime;
    private String aircraftType;
    private String flightStatus;
    private int mileage;
