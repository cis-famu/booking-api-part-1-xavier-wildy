package com.booking.booking.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.hotelbooking.model.Rooms;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class RoomsService {

    @Autowired
    private Firestore firestore;

    public RoomsService(){
        this.firestore = FirestoreClient.getFirestore();
    }

    private Rooms documentSnapshotToRooms(DocumentSnapshot document) {
        if (document.exists()) {
            return document.toObject(Rooms.class);
        }
        return null;
    }

    public ArrayList<Rooms> getAllRooms() throws ExecutionException, InterruptedException {
        CollectionReference roomsCollection = firestore.collection("Rooms");
        ApiFuture<QuerySnapshot> future = roomsCollection.get();
        ArrayList<Rooms> hotelsList = new ArrayList<>();
        for (DocumentSnapshot document : future.get().getDocuments()) {
            Rooms rooms = documentSnapshotToRooms(document);
            if (rooms != null) {
                hotelsList.add(rooms);
            }
        }
        return hotelsList;
    }

    public Rooms getRoomsById(String roomsID) throws ExecutionException, InterruptedException {
        CollectionReference roomsCollection = firestore.collection("Rooms");
        ApiFuture<DocumentSnapshot> future = roomsCollection.document(roomsID).get();
        DocumentSnapshot document = future.get();
        return documentSnapshotToRooms(document);
    }
}
