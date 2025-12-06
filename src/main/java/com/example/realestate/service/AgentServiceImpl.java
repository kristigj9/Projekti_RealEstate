package com.example.realestate.service;

import com.example.realestate.dto.AgentDto;
import com.example.realestate.mapper.AgentMapper;
import com.example.realestate.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AgentServiceImpl implements AgentService {

    private final AgentRepository repo;

    @Override
    public AgentDto createAgent(AgentDto dto) {
        var agent = AgentMapper.toEntity(dto);
        return AgentMapper.fromEntity(repo.save(agent));
    }

    @Override
    public AgentDto getAgent(Long id) {
        return repo.findById(id)
                .map(AgentMapper::fromEntity)
                .orElseThrow(() -> new RuntimeException("Agent not found"));
    }

    @Override
    public List<AgentDto> getAllAgents() {
        return repo.findAll().stream()
                .map(AgentMapper::fromEntity)
                .toList();
    }

    @Override
    public AgentDto updateAgent(Long id, AgentDto dto) {
        var agent = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        AgentMapper.updateEntity(agent, dto);

        return AgentMapper.fromEntity(repo.save(agent));
    }

    @Override
    public void deleteAgent(Long id) {
        repo.deleteById(id);
    }
}
