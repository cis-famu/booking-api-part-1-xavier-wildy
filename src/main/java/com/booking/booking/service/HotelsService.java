package com.booking.booking.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.hotelbooking.model.Hotels;
import edu.famu.hotelbooking.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
@Service
public class HotelsService {

    @Autowired
    private Firestore firestore;

    public HotelsService(){
        this.firestore = FirestoreClient.getFirestore();
    }

    private Hotels documentSnapshotToHotels(DocumentSnapshot document) {
        if (document.exists()) {
            return document.toObject(Hotels.class);
        }
        return null;
    }

    public ArrayList<Hotels> getAllHotels() throws ExecutionException, InterruptedException {
        CollectionReference hotelsCollection = firestore.collection("Hotels");
        ApiFuture<QuerySnapshot> future = hotelsCollection.get();
        ArrayList<Hotels> hotelsList = new ArrayList<>();
        for (DocumentSnapshot document : future.get().getDocuments()) {
            Hotels hotels = documentSnapshotToHotels(document);
            if (hotels != null) {
                hotelsList.add(hotels);
            }
        }
        return hotelsList;
    }

    public Hotels getHotelsById(String hotelID) throws ExecutionException, InterruptedException
    {
        CollectionReference hotelsCollection = firestore.collection("Bookings");
        ApiFuture<DocumentSnapshot> future = hotelsCollection.document(hotelID).get();
        DocumentSnapshot document = future.get();
        return documentSnapshotToHotels(document);
    }
}

