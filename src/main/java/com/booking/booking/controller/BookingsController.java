package com.booking.booking.controller;

import edu.famu.hotelbooking.service.BookingsService;
import edu.famu.hotelbooking.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    public BookingsController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllBookings() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", bookingsService.getAllBookings(), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred", null, e.getMessage()));
        }
    }

    @GetMapping("/{bookingID}")
    public ResponseEntity<ApiResponse> getBookingsById(@PathVariable String bookingID) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", bookingsService.getBookingsById(bookingID), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred", null, e.getMessage()));
        }
    }
}
