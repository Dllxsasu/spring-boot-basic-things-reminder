package com.example.paging.repository;

import com.example.paging.MovieCharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Sql(scripts = { "/data.sql" })
public class MovieCharacterRepositoryTest {
    @Autowired
    private MovieCharacterRepository characterRepository;

    @Test
    @DisplayName("text return page")
    void returnsPage() {

        assertThat(
                characterRepository
                        .findAllPage(PageRequest.of(0, 10))
                        .getContent()
                        .size())
                .isEqualTo(10);

    }

    @Test
    void returnsSlice() {
        // database is initialized with script "data.sql"
        assertThat(
                characterRepository
                        .findAllSlice(PageRequest.of(0, 10))
                        .getContent()
                        .size())
                .isEqualTo(10);

    }

}
