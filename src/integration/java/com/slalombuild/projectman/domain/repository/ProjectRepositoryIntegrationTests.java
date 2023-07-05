package com.slalombuild.projectman.domain.repository;

import com.slalombuild.projectman.domain.entity.Project;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProjectRepositoryIntegrationTests {
    @Autowired private ProjectRepository repository;

    @Test
    public void givenContext_thenRepoShouldBeNonNull() {
        assertThat(repository).isNotNull();
    }

    @Test
    public void givenAProject_whenFindAll_shouldReturnList() {
        // Arrange
        var project = Instancio.of(Project.class)
                .ignore(Select.field("id"))
                .create();
        repository.saveAndFlush(project);

        // Act
        var actualResult = repository.findAll();

        // Assert
        assertThat(actualResult).isNotNull();
        assertThat(actualResult).isNotEmpty();
    }
}
