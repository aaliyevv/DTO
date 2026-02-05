package com.ltc.dto.service;


import com.ltc.dto.dto.CourseRequestDTO;
import com.ltc.dto.dto.CourseResponseDTO;

import java.util.List;

public interface CourseService {

    CourseResponseDTO create (CourseRequestDTO courseRequestDTO);
    CourseResponseDTO getById (Long id);
    List<CourseResponseDTO> getAll ();
    CourseResponseDTO update (Long id, CourseRequestDTO courseRequestDTO);
    void delete (Long id);

}
