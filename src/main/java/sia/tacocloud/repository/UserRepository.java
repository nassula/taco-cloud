package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.entities.UserTaco;

public interface UserRepository extends CrudRepository<UserTaco, Long> {

    UserTaco findByUsername(String username);
}
