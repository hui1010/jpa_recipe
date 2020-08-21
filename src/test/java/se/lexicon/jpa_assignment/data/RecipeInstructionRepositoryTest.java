package se.lexicon.jpa_assignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpa_assignment.entity.RecipeCategory;
import se.lexicon.jpa_assignment.entity.RecipeInstruction;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeInstructionRepositoryTest {

    @Autowired
    RecipeInstructionRepository recipeInstructionRepository;
    RecipeInstruction testObject;

    @BeforeEach
    void setUp() {
        testObject = new RecipeInstruction("introduction of how deep fry chicken");
        recipeInstructionRepository.save(testObject);
    }

    @Test
    void successfully_created() {
        assertNotNull(testObject);
        assertEquals(1, recipeInstructionRepository.findAll().size());
    }
}