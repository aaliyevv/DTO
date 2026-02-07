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


    @GetMapping("/{id}")
    @Operation(summary = "Get course by id")
    @ApiResponse(responseCode = "200", description = "Course found")
    @ApiResponse(responseCode = "404", description = "Course not found")
    public ResponseEntity<CourseResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all courses")
    @ApiResponse(responseCode = "200", description = "Courses retrieved successfully")
    public ResponseEntity<List<CourseResponseDTO>> getAll(){
        return ResponseEntity.ok(courseService.getAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update course by id")
    @ApiResponse(responseCode = "200", description = "Course updated successfully")
    @ApiResponse(responseCode = "404", description = "Course not found")
    public ResponseEntity<CourseResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequestDTO courseRequestDTO){

        return ResponseEntity.ok(courseService.update(id, courseRequestDTO));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete course by id")
    @ApiResponse(responseCode = "200", description = "Course deleted successfully")
    @ApiResponse(responseCode = "404", description = "Course not found")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        courseService.delete(id);
        return ResponseEntity.ok().build();
    }



}