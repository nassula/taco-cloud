package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.entities.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
