package com.example.realestate.config;

import com.example.realestate.model.*;
import com.example.realestate.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final OwnerRepository ownerRepository;
    private final AgentRepository agentRepository;
    private final BuyerRepository buyerRepository;
    private final PropertyRepository propertyRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if(adminRepository.count() == 0) {

            // -----------------------
            // 1 Admin
            // -----------------------
            Admin admin = new Admin();
            admin.setName("Admin User");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            adminRepository.save(admin);

            // -----------------------
            // 2 Owner
            // -----------------------
            Owner owner = new Owner();
            owner.setName("Owner User");
            owner.setEmail("owner@example.com");
            owner.setPassword(passwordEncoder.encode("owner123"));
            ownerRepository.save(owner);

            // -----------------------
            // 3️ Agent
            // -----------------------
            Agent agent = new Agent();
            agent.setName("Agent User");
            agent.setEmail("agent@example.com");
            agent.setPassword(passwordEncoder.encode("agent123"));
            agentRepository.save(agent);

            // -----------------------
            // 4️ Buyer
            // -----------------------
            Buyer buyer = new Buyer();
            buyer.setName("Buyer User");
            buyer.setEmail("buyer@example.com");
            buyer.setPassword(passwordEncoder.encode("buyer123"));
            buyerRepository.save(buyer);

            // -----------------------
            // 5️ Sample Property
            // -----------------------
            Property property = new Property();
            property.setTitle("Beautiful Apartment");
            property.setDescription("Spacious 3-bedroom apartment in city center.");
            property.setCity("Tirana");
            property.setAddress("Rruga e Dajti, Tirana");
            property.setPrice(120000.0);
            property.setOwner(owner); // Owner entity
            propertyRepository.save(property);

            System.out.println("Demo data loaded with Admin, Owner, Agent, Buyer, Property!");
        }
    }
}
