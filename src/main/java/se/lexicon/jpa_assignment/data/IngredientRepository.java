package se.lexicon.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    Ingredient findByIngredient(String name);

    List<Ingredient> findAllByIngredientContainingIgnoreCase(String ingredient);

}
