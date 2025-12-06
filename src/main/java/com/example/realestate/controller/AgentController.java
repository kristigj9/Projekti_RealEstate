package com.example.realestate.controller;

import com.example.realestate.dto.AgentDto;
import com.example.realestate.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @PostMapping
    public ResponseEntity<AgentDto> createAgent(@Validated @RequestBody AgentDto dto) {
        return new ResponseEntity<>(agentService.createAgent(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentDto> getAgent(@PathVariable Long id) {
        return ResponseEntity.ok(agentService.getAgent(id));
    }

    @GetMapping
    public ResponseEntity<List<AgentDto>> getAllAgents() {
        return ResponseEntity.ok(agentService.getAllAgents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentDto> updateAgent(@PathVariable Long id, @Validated @RequestBody AgentDto dto) {
        return ResponseEntity.ok(agentService.updateAgent(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.noContent().build();
    }
}
