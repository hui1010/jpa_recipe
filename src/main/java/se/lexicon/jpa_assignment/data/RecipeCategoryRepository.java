package se.lexicon.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entity.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
}
