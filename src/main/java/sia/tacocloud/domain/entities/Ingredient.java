package sia.tacocloud.domain.entities;

import lombok.Data;
import sia.tacocloud.domain.constants.Type;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;



}
