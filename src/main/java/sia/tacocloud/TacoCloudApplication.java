package sia.tacocloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import sia.tacocloud.domain.constants.Type;
import sia.tacocloud.domain.entities.Ingredient;
import sia.tacocloud.domain.entities.Taco;
import sia.tacocloud.repository.IngredientRepository;
import sia.tacocloud.repository.TacoRepository;

import java.util.Arrays;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    //This is a piece of code to populate the database with inicial ingredients
    @Bean
    @Profile("dev")
    public CommandLineRunner dataLoader(IngredientRepository repository, TacoRepository tacoRepository){
        return args -> {
            Ingredient flour = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
            Ingredient corn = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
            Ingredient ground = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
            Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
            Ingredient diced = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
            Ingredient lett = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
            Ingredient chedd = new Ingredient("CHED", "Cheddar", Type.CHEESE);
            Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
            Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
            Ingredient sour = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);

            repository.save(flour);
            repository.save(corn);
            repository.save(ground);
            repository.save(carnitas);
            repository.save(diced);
            repository.save(lett);
            repository.save(chedd);
            repository.save(jack);
            repository.save(salsa);
            repository.save(sour);

            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(Arrays.asList(flour,ground,carnitas,sour,salsa,chedd));
            tacoRepository.save(taco1);

            taco1.setName("Teste");
            taco1.setIngredients(Arrays.asList(flour,ground,carnitas,sour,salsa,chedd));
            tacoRepository.save(taco1);

            taco1.setName("Teste 03");
            taco1.setIngredients(Arrays.asList(flour,ground,carnitas,sour,salsa,chedd));
            tacoRepository.save(taco1);

        };
    }

}
