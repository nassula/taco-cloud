package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.entities.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {}
