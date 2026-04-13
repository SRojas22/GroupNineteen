package com.group19.BookstoreAPI.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group19.BookstoreAPI.backend.entity.UserProfile;
import com.group19.BookstoreAPI.backend.service.UserProfileService;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    // POST /profiles - Create a new user profile
    @PostMapping
    public ResponseEntity<Void> createProfile(@RequestBody UserProfile profile) {
        userProfileService.createProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // GET /profiles/{username} - Get profile by username
    @GetMapping("/{username}")
    public ResponseEntity<UserProfile> getProfile(@PathVariable String username) {
        return userProfileService.getProfileByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PATCH /profiles/{username} - Update profile fields except email
    @PatchMapping("/{username}")
    public ResponseEntity<Void> updateProfile(@PathVariable String username, @RequestBody UserProfile updated) {
        boolean found = userProfileService.updateProfile(username, updated).isPresent();
        return found ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}