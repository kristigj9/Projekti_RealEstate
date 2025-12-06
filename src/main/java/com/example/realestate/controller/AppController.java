package com.example.realestate.controller;

import com.example.realestate.dto.AppDto;
import com.example.realestate.model.App;
import com.example.realestate.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/auth")
    public class AppController {
        private final AppService userService;
        public AppController(AppService userService) { this.userService = userService; }

        @PostMapping("/register-admin")
        public ResponseEntity<App> registerAdmin(@RequestBody AppDto req) {
            return ResponseEntity.ok(userService.registerAdmin(req.getUsername(), req.getPassword()));
        }
        @PreAuthorize("hasAnyRole('ADMIN','AGENT')")
        @PostMapping("/register-agent")
        public ResponseEntity<App> registerTeacher(@RequestBody AppDto req) {
            return ResponseEntity.ok(userService.registerAgent(req.getUsername(), req.getPassword()));
        }
        @PreAuthorize("hasAnyRole('ADMIN','OWNER')")
        @PostMapping("/register-OWNER")
        public ResponseEntity<App> registerStudent(@RequestBody AppDto req) {
            return ResponseEntity.ok(userService.registerOwner(req.getUsername(), req.getPassword()));
        }
    }


