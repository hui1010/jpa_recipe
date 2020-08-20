package se.lexicon.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer> {
    List<RecipeIngredient> findAll();

    RecipeIngredient save(RecipeIngredient recipeIngredient);

}
