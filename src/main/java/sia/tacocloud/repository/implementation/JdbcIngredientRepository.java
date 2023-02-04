package sia.tacocloud.repository.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sia.tacocloud.domain.constants.Type;
import sia.tacocloud.domain.entities.Ingredient;
import sia.tacocloud.repository.IngredientRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> results = jdbcTemplate.query("select id, name, type from Ingredient where id = ?", this::mapRowToIngredient, id);
        return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(row.getString("id"), row.getString("name"), Type.valueOf(row.getString("type")));
    }
}
