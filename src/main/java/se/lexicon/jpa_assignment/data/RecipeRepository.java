package se.lexicon.jpa_assignment.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.jpa_assignment.entity.Recipe;
import java.util.Set;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findAll();

    List<Recipe> findAllByNameContainingIgnoreCase(String string);//worked
    //todo coming three methods do not work
    List<Recipe> findAllByRecipeIngredients_Ingredient_NameIgnoreCase(String ingredientName);
    List<Recipe> findAllByRecipeCategories_NameIgnoreCase(String categoryName);
//    @Query("SELECT r FROM Recipe r JOIN RecipeCategory rc WHERE r. = :name ")
//    List<Recipe> findAllByRecipeCategories_NameContainingIgnoreCase(@Param("name") String name, String ... names);

    //List<Recipe> findAllByRecipeIngredientsContainingIgnoreCase();

}
