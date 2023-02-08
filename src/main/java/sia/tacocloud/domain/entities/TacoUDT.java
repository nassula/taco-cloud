package sia.tacocloud.domain.entities;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Data
@UserDefinedType("taco")
public class TacoUDT {

    private String name;
    private List<IngredientUDT> ingredients;
}
