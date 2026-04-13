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
        if (profile.getCreditCards() != null) {
            profile.getCreditCards().forEach(card -> card.setUserProfile(profile));
        }
        return userProfileRepository.save(profile);
    }

    // GET BY USERNAME
    public Optional<UserProfile> getProfileByUsername(String username) {
        return userProfileRepository.findByUsername(username);
    }

    // UPDATE BY USERNAME (email cannot be updated)
    public Optional<UserProfile> updateProfile(String username, UserProfile updated) {
        return userProfileRepository.findByUsername(username).map(existing -> {
            if (updated.getName() != null) existing.setName(updated.getName());
            if (updated.getPassword() != null) existing.setPassword(updated.getPassword());
            if (updated.getHomeAddress() != null) existing.setHomeAddress(updated.getHomeAddress());
            return userProfileRepository.save(existing);
        });
    }
}