package sia.tacocloud.repository;

import sia.tacocloud.domain.entities.Ingredient;

import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);

}
