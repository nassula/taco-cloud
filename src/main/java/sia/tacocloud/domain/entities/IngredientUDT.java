package sia.tacocloud.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import sia.tacocloud.domain.constants.Type;

@Data
@RequiredArgsConstructor
@UserDefinedType("ingredient")
public class IngredientUDT {
    private String name;
    private Type type;
}
