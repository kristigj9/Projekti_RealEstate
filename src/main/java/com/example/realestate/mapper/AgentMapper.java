package com.example.realestate.mapper;

import com.example.realestate.dto.AgentDto;
import com.example.realestate.model.Agent;

public class AgentMapper {

    public static Agent toEntity(AgentDto dto) {
        Agent a = new Agent();
        a.setId(dto.getId());
        a.setName(dto.getName());
        a.setEmail(dto.getEmail());
        a.setPhone(dto.getPhone());
        a.setRole("AGENT");
        a.setLicenseNumber(dto.getLicenseNumber());
        return a;
    }

    public static AgentDto fromEntity(Agent agent) {
        return AgentDto.builder()
                .id(agent.getId())
                .name(agent.getName())
                .email(agent.getEmail())
                .phone(agent.getPhone())
                .role("AGENT")
                .licenseNumber(agent.getLicenseNumber())
                .build();
    }

    public static void updateEntity(Agent agent, AgentDto dto) {
        agent.setName(dto.getName());
        agent.setEmail(dto.getEmail());
        agent.setPhone(dto.getPhone());
        agent.setLicenseNumber(dto.getLicenseNumber());
    }
}
