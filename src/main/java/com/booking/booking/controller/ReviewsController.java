package com.booking.booking.controller;

import edu.famu.hotelbooking.service.ReviewsService;
import edu.famu.hotelbooking.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    public ReviewsController(ReviewsService reivewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllReviews() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", reviewsService.getAllReviews(), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred", null, e.getMessage()));
        }
    }

    @GetMapping("/{reviewsId}")
    public ResponseEntity<ApiResponse> getReviewsById(@PathVariable String reviewsId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", reviewsService.getReviewsById(reviewsId), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred", null, e.getMessage()));
        }
    }
}