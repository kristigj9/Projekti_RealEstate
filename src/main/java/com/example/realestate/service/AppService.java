package com.example.realestate.service;

import com.example.realestate.model.App;

public interface AppService {
    App registerOwner(String username, String rawPassword);
    App registerAgent(String username, String rawPassword);
    App registerAdmin(String username, String rawPassword);
}