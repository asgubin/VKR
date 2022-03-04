package ru.asgubin.diploma.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.asgubin.diploma.entity.Category;
import ru.asgubin.diploma.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @MockBean
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @Test
    public void testFindById() {

        given(this.categoryRepository.findById(any()))
                .willReturn(Optional.of(new Category(1L, "OST_Test")));

        Optional<Category> category = categoryService.findById(1L);

        if (category.isPresent()) {
            assertThat(category.get().getId()).isEqualTo(1L);
            assertThat(category.get().getName()).isEqualTo("OST_Test");
        }
    }

    @Test
    public void testFindAll() {

        List<Category> categoriesTest = new ArrayList<>();
        categoriesTest.add(new Category(1L, "OST_Test1"));
        categoriesTest.add(new Category(2L, "OST_Test2"));

        given(this.categoryRepository.findAll())
                .willReturn(categoriesTest);

        List<Category> categories = categoryService.findAll();

        assertEquals(categories, categoriesTest);
    }
}