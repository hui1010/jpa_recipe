package se.lexicon.jpa_assignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpa_assignment.entity.Ingredient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IngredientRepositoryTest {
    @Autowired
    IngredientRepository ingredientRepository;
    Ingredient testOne;
    Ingredient testTwo;
    Ingredient testThree;

    @BeforeEach
    void setUp() {
        testOne = new Ingredient("Swedish tomato");
        testTwo = new Ingredient("Danish tomato");
        testThree = new Ingredient("Tomato");
        ingredientRepository.save(testOne);
        ingredientRepository.save(testTwo);
        ingredientRepository.save(testThree);
    }

    @Test
    void successfully_created() {
        assertNotNull(ingredientRepository.findAll());
        assertEquals(3, ingredientRepository.findAll().size());
    }

    @Test
    void findByNameIgnoreCase() {
        //Arrange
        String name = "TOmato";
        //Act
        Ingredient found = ingredientRepository.findByNameIgnoreCase(name);
        //Assert
        assertNotNull(found);
        assertEquals(testThree, found);
        assertTrue(testThree.getName().equalsIgnoreCase(found.getName()));

    }

    @Test
    void findAllByNameContainingIgnoreCase() {
        //Arrange
        String search = "tomaTO";
        //Act
        List<Ingredient> found = ingredientRepository.findAllByNameContainingIgnoreCase(search);
        //Assert
        assertNotNull(found);
        assertEquals(3,found.size());
        assertTrue(found.contains(testOne));
        assertTrue(found.contains(testTwo));
        assertTrue(found.contains(testThree));
    }

}