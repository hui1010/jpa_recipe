package se.lexicon.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findAllByRecipeNameContainingIgnoreCase(String recipeName);
    List<Recipe> findAllByRecipeIngredientsContaining(String ingredientName);
    List<Recipe> findAllByRecipeCategoriesContainingIgnoreCase(String categoryName);
    List<Recipe> findAllByRecipeCategoriesContainingIgnoreCase(List<String> categoryNames);



}
