package se.lexicon.jpa_assignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpa_assignment.entity.Recipe;
import se.lexicon.jpa_assignment.entity.RecipeCategory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeCategoryRepositoryTest {

    @Autowired
    RecipeCategoryRepository recipeCategoryRepository;
    RecipeCategory testObject;

    @BeforeEach
    void setUp() {
        testObject = new RecipeCategory("vegan", null);
        recipeCategoryRepository.save(testObject);
    }

    @Test
    void successfully_created() {
        assertNotNull(testObject);
        assertEquals(1,recipeCategoryRepository.findAll().size());
    }
}