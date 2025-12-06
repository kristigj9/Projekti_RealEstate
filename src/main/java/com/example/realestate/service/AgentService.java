package com.example.realestate.service;

import com.example.realestate.dto.AgentDto;
import java.util.List;

public interface AgentService {
    AgentDto createAgent(AgentDto dto);
    AgentDto getAgent(Long id);
    List<AgentDto> getAllAgents();
    AgentDto updateAgent(Long id, AgentDto dto);
    void deleteAgent(Long id);
}

