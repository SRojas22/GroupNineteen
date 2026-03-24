package com.group19.BookstoreAPI.backend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group19.BookstoreAPI.backend.entity.UserProfile;
import com.group19.BookstoreAPI.backend.repository.UserProfileRepository;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    // CREATE
    public UserProfile createProfile(UserProfile profile) {
        return userProfileRepository.save(profile);
    }

    // GET BY ID
    public Optional<UserProfile> getProfileById(Long id) {
        return userProfileRepository.findById(id);
    }

    // UPDATE
    public Optional<UserProfile> updateProfile(Long id, UserProfile updated) {
        return userProfileRepository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setEmail(updated.getEmail());
            existing.setUsername(updated.getUsername());
            existing.setBio(updated.getBio());
            return userProfileRepository.save(existing);
        });
    }

    // DELETE
    public boolean deleteProfile(Long id) {
        if (userProfileRepository.existsById(id)) {
            userProfileRepository.deleteById(id);
            return true;
        }
        return false;
    }
}