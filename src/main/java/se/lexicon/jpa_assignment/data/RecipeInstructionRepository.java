package se.lexicon.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entity.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
    List<RecipeInstruction> findAll();
}
