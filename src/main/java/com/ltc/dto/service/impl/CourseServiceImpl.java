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


}