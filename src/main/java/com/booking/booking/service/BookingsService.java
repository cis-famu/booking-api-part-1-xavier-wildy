package com.booking.booking.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.hotelbooking.model.Bookings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
@Service
public class BookingsService {

        @Autowired
        private Firestore firestore;

        public BookingsService(){
            this.firestore = FirestoreClient.getFirestore();
        }

        private Bookings documentSnapshotToBookings(DocumentSnapshot document)
        {
            if (document.exists())
            {
                return document.toObject(Bookings.class);
            }
            return null;
        }

        public ArrayList<Bookings> getAllBookings() throws ExecutionException, InterruptedException {
            CollectionReference bookingsCollection = firestore.collection("Bookings");
            ApiFuture<QuerySnapshot> future = bookingsCollection.get();
            ArrayList<Bookings> bookingsList = new ArrayList<>();
            for (DocumentSnapshot document : future.get().getDocuments()) {
                Bookings bookings = documentSnapshotToBookings(document);
                if (bookings != null) {
                    bookingsList.add(bookings);
                }
            }
            return bookingsList;
        }

        public Bookings getBookingsById(String bookingID) throws ExecutionException, InterruptedException
        {
            CollectionReference bookingsCollection = firestore.collection("Bookings");
            ApiFuture<DocumentSnapshot> future = bookingsCollection.document(bookingID).get();
            DocumentSnapshot document = future.get();
            return documentSnapshotToBookings(document);
        }
}
