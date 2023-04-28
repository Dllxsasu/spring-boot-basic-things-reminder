package com.example.paging.controller;

import com.example.paging.MovieCharacterRepository;
import com.example.paging.PagedController;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.paging.PageableAssert.*;
import static com.example.paging.SortAssert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(
        controllers = PagedController.class
)
public class PagedControllerTest {
    @MockBean
    private MovieCharacterRepository characterRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void evaluatesPageableParameter() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/characters/page")
                        .param("page", "5")
                        .param("size", "10")
                        .param("sort", "id,desc") // <-- no space after comma!!!
                        .param("sort", "name,asc")) // <-- no space after comma!!!
                .andExpect( status().isOk());

        ArgumentCaptor<Pageable> pageableCaptor = ArgumentCaptor.forClass(Pageable.class);
        verify(characterRepository).findAllPage(pageableCaptor.capture());
        PageRequest pageable = (PageRequest) pageableCaptor.getValue();

        assertThat(pageable).hasPageNumber(5);
        assertThat(pageable).hasPageSize(10);
        assertThat(pageable).hasSort("name", Sort.Direction.ASC);
        assertThat(pageable).hasSort("id", Sort.Direction.DESC);
    }



}
