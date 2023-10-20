package com.booking.booking.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.hotelbooking.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ReviewsService {

    @Autowired
    private Firestore firestore;

    public ReviewsService(){
        this.firestore = FirestoreClient.getFirestore();
    }

    private Reviews documentSnapshotToReviews(DocumentSnapshot document) {
        if (document.exists()) {
            return document.toObject(Reviews.class);
        }
        return null;
    }

    public ArrayList<Reviews> getAllReviews() throws ExecutionException, InterruptedException {
        CollectionReference reviewsCollection = firestore.collection("Reviews");
        ApiFuture<QuerySnapshot> future = reviewsCollection.get();
        ArrayList<Reviews> reviewsList = new ArrayList<>();
        for (DocumentSnapshot document : future.get().getDocuments()) {
            Reviews reviews = documentSnapshotToReviews(document);
            if (reviews != null) {
                reviewsList.add(reviews);
            }
        }
        return reviewsList;
    }

    public Reviews getReviewsById(String reviewID) throws ExecutionException, InterruptedException {
        CollectionReference reviewsCollection = firestore.collection("Users");
        ApiFuture<DocumentSnapshot> future = reviewsCollection.document(reviewID).get();
        DocumentSnapshot document = future.get();
        return documentSnapshotToReviews(document);
    }
}
