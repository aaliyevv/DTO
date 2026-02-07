package com.ltc.dto.service.impl;

import com.ltc.dto.dto.CourseRequestDTO;
import com.ltc.dto.dto.CourseResponseDTO;
import com.ltc.dto.exception.CourseNotFoundException;
import com.ltc.dto.model.CourseEntity;
import com.ltc.dto.repo.CourseRepo;
import com.ltc.dto.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    public final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public CourseResponseDTO create(CourseRequestDTO courseRequestDTO) {
        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setCourseName(courseRequestDTO.getCourseName());
        courseEntity.setCourseCode(courseRequestDTO.getCourseCode());
        courseEntity.setStudentName(courseRequestDTO.getStudentName());
        courseEntity.setStudentSurname(courseRequestDTO.getStudentSurname());

        CourseEntity dbSaving = courseRepo.save(courseEntity);

        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();

        courseResponseDTO.setId(dbSaving.getId());
        courseResponseDTO.setCourseName(dbSaving.getCourseName());
        courseResponseDTO.setStudentName(dbSaving.getStudentName());
        courseResponseDTO.setStudentSurname(dbSaving.getStudentSurname());

        return courseResponseDTO;


    }

    @Override
    public CourseResponseDTO getById(Long id) {

        CourseEntity courseEntity = courseRepo.findById(id).orElseThrow(() ->
                new CourseNotFoundException("Course Not Found" + id));

        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();

        courseResponseDTO.setId(courseEntity.getId());
        courseResponseDTO.setCourseName(courseEntity.getCourseName());
        courseResponseDTO.setStudentName(courseEntity.getStudentName());
        courseResponseDTO.setStudentSurname(courseEntity.getStudentSurname());

        return courseResponseDTO;
    }

    @Override
    public List<CourseResponseDTO> getAll() {
        return courseRepo.findAll().stream()
                .map( course ->
                        new CourseResponseDTO(
                                course.getId(),
                                course.getCourseName(),
                                course.getStudentName(),
                                course.getStudentSurname())).toList();
    }


}