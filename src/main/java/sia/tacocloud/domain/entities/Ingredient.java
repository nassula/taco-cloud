package sia.tacocloud.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sia.tacocloud.domain.constants.Type;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    private String id;
    private String name;
    private Type type;
}
