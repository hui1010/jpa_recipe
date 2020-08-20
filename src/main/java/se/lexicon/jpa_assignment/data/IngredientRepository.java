package se.lexicon.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findAll();

    //search for a specific ingredient name by specified String
    Ingredient findByNameIgnoreCase(String name);

    //search for ingredient that name particularly corresponded with search String
    List<Ingredient> findAllByNameContainingIgnoreCase(String string);

}
