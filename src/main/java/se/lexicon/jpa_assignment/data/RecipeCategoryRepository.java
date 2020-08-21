package se.lexicon.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entity.RecipeCategory;
import se.lexicon.jpa_assignment.entity.RecipeInstruction;

import java.util.List;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
    List<RecipeCategory> findAll();
}
