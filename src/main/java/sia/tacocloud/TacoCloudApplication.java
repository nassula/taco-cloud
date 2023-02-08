package sia.tacocloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sia.tacocloud.domain.constants.Type;
import sia.tacocloud.domain.entities.Ingredient;
import sia.tacocloud.repository.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    //This is a piece of code to populate the database with inicial ingredients
    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repository){
        return args -> {
            repository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            repository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            repository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            repository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            repository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            repository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            repository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            repository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            repository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            repository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        };
    }
}
