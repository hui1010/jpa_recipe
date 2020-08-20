package se.lexicon.jpa_assignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpa_assignment.entity.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeRepositoryTest {

    @Autowired
    RecipeRepository recipeRepository;
    Recipe testOne;
    Recipe testTwo;

    List<RecipeIngredient> testOneIngredients;
    List<RecipeIngredient> testTwoIngredients;

    List<RecipeCategory> testOneCategory;
    List<RecipeCategory> testTwoCategory;

    RecipeIngredient recipeIngredient1;
    RecipeIngredient recipeIngredient2;
    RecipeIngredient recipeIngredient3;

    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;
    RecipeCategory category1;
    RecipeCategory category2;
    RecipeCategory category3;

    @BeforeEach
    void setUp() {

        testOne = new Recipe("hot spicy chicken", null, null, null);
        testTwo = new Recipe("spicy noodles", null, null, null);

        ingredient1 = new Ingredient("tomato");
        ingredient2 = new Ingredient("egg");
        ingredient3 = new Ingredient("mushroom");

        testOneIngredients = new ArrayList<>();
        testTwoIngredients = new ArrayList<>();

        recipeIngredient1 = new RecipeIngredient();
        recipeIngredient2 = new RecipeIngredient();
        recipeIngredient3 = new RecipeIngredient();

//        recipeIngredient1.setIngredient(ingredient1);
//        recipeIngredient2.setIngredient(ingredient2);
//        recipeIngredient3.setIngredient(ingredient3);
//
//        testOneIngredients.add(recipeIngredient1);
//        testOneIngredients.add(recipeIngredient2);
//
//        testTwoIngredients.add(recipeIngredient2);
//        testTwoIngredients.add(recipeIngredient3);

        category1 = new RecipeCategory("spicy", null);
        category2 = new RecipeCategory("hot", null);
        category3 = new RecipeCategory("chicken", null);

//        category1.setName("spicy");
//        category2.setName("hot");
//        category3.setName("chicken");
//todo check this nullPointerException
//        category1.addRecipe(testOne);
//        category1.addRecipe(testTwo);
//        category2.addRecipe(testOne);
//        category3.addRecipe(testOne);

//        testOneCategory = new ArrayList<>();
//        testTwoCategory = new ArrayList<>();
//
//        testOneCategory.add(category1);
//        testOneCategory.add(category2);
//        testOneCategory.add(category3);
//        testTwoCategory.add(category1);


        testOne.addRecipeIngredient(recipeIngredient1);
        testOne.addRecipeIngredient(recipeIngredient2);

        testTwo.addRecipeIngredient(recipeIngredient2);
        testTwo.addRecipeIngredient(recipeIngredient3);

        testOne.addToRecipeCategory(category1);
        testOne.addToRecipeCategory(category2);
        testOne.addToRecipeCategory(category3);

        testTwo.addToRecipeCategory(category1);

//        testOne.setRecipeCategories(testOneCategory);
//        testTwo.setRecipeCategories(testTwoCategory);

        recipeRepository.save(testOne);
        recipeRepository.save(testTwo);
    }

    @Test
    void successfully_created() {
        assertNotNull(testOne);
        assertNotNull(testTwo);

        assertEquals(2, recipeRepository.findAll().size());
    }

    @Test
    void findAllByNameContainingIgnoreCase() {
        //Arrange
        String string1 = "Chicken";
        String string2 = "spicy";

        //Act
        List<Recipe> found1 = recipeRepository.findAllByNameContainingIgnoreCase(string1);
        List<Recipe> found2 = recipeRepository.findAllByNameContainingIgnoreCase(string2);

        //Assert
        assertNotNull(found1);
        assertNotNull(found2);
        assertEquals(1, found1.size());
        assertEquals(2, found2.size());
        assertTrue(found1.contains(testOne));
        assertFalse(found1.contains(testTwo));
        assertTrue(found2.contains(testOne));
        assertTrue(found2.contains(testTwo));
    }

    @Test
    void findAllByRecipeIngredients_Ingredient_NameIgnoreCase() {
        //Arrange
        String name1 = "TomatO";
        String name2 = "Egg";

        //Act
        List<Recipe> found1 = recipeRepository.findAllByRecipeIngredients_Ingredient_NameIgnoreCase(name1);
        List<Recipe> found2 = recipeRepository.findAllByRecipeIngredients_Ingredient_NameIgnoreCase(name2);

        System.out.println(found1.size());
        System.out.println(found2.size());

        //Assert
//        assertNotNull(found1);
//        assertNotNull(found2);
//        System.out.println(found1.toString());
//        assertEquals(1, found1.size());
//        assertEquals(2, found2.size());
//        assertTrue(found1.contains(testOne));
//        assertFalse(found1.contains(testTwo));
//        assertTrue(found2.contains(testOne));
//        assertTrue(found2.contains(testTwo));
    }

    @Test
    void findAllByRecipeCategories_NameIgnoreCase() {
        //Arrange
        String name1 = "spicy";
        String name2 = "chickeN";

        //Act
        List<Recipe> found2 = recipeRepository.findAllByRecipeCategories_NameIgnoreCase(name2);
        //Assert

        System.out.println(found2.size());
        assertTrue(found2.contains(testOne));
        assertFalse(found2.contains(testTwo));
    }

    @Test
    void findAllByRecipeCategories_NameContainingIgnoreCase() {
        //Arrange

        //Act

        //Assert
    }
}