package com.edutech.classroom.controller;

import com.edutech.classroom.dto.CourseCategoryDTO;
import com.edutech.classroom.service.CourseCategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CourseCategoryController.class)
class CourseCategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CourseCategoryService courseCategoryService;

    @Test
    void testFindAllReturnsOk() throws Exception {
        when(courseCategoryService.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/course-categories"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindByIdReturnsOk() throws Exception {
        CourseCategoryDTO dto = new CourseCategoryDTO();
        dto.setId(1);
        dto.setName("Programming");
        dto.setDescription("Programming courses");
        when(courseCategoryService.findById(1)).thenReturn(dto);
        mockMvc.perform(get("/api/course-categories/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Programming"));
    }
}
