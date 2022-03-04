package ru.asgubin.diploma.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.asgubin.diploma.repository.CategoryRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @MockBean
    private CategoryRepository categoryRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCategory() throws Exception {
/*
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/categories");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(MockMvcResultMatchers.redirectedUrl(null));
*/
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/categories"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content()
                        .contentType("text/html;charset=UTF-8"));
    }
}