package com.booking.booking.controller;

import edu.famu.hotelbooking.service.RoomsService;
import edu.famu.hotelbooking.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllRooms() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", roomsService.getAllRooms(), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred", null, e.getMessage()));
        }
    }

    @GetMapping("/{roomsId}")
    public ResponseEntity<ApiResponse> getRoomsById(@PathVariable String roomsId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", roomsService.getRoomsById(roomsId), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred", null, e.getMessage()));
        }
    }
}