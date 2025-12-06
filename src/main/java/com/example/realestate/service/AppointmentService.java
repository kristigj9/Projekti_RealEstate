package com.example.realestate.service;

import com.example.realestate.dto.AppointmentDto;
import java.util.List;

public interface AppointmentService {

    AppointmentDto create(AppointmentDto dto);

    AppointmentDto get(Long id);

    List<AppointmentDto> getAll();

    AppointmentDto update(Long id, AppointmentDto dto);

    void delete(Long id);
}
