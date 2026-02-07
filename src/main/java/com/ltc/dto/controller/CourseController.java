package com.ltc.dto.controller;

import com.ltc.dto.dto.CourseRequestDTO;
import com.ltc.dto.dto.CourseResponseDTO;
import com.ltc.dto.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/api/courses")
@Tag(name = "Course Management System", description = "System manages course users.")
public class CourseController{

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @Operation(summary = "Create a new course")
    @ApiResponse(responseCode = "201", description = "Course created successfully")
    public ResponseEntity<CourseResponseDTO> create(
            @Valid @RequestBody CourseRequestDTO courseRequestDTO){

        CourseResponseDTO course = courseService.create(courseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }



}