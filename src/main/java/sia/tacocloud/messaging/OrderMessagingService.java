package sia.tacocloud.messaging;

import sia.tacocloud.domain.entities.TacoOrder;

public interface OrderMessagingService {

    void sendOrder(TacoOrder order);

}
