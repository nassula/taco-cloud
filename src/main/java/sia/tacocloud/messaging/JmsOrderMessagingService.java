package sia.tacocloud.messaging;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import sia.tacocloud.domain.entities.TacoOrder;

@Service
public class JmsOrderMessagingService implements OrderMessagingService{

    private JmsTemplate jms;
    private Destination orderQueue;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms, Destination orderQueue){

        this.jms = jms;
        this.orderQueue = orderQueue;
    }


    @Override
    public void sendOrder(TacoOrder order) {
        jms.convertAndSend(orderQueue,order, this::addOrderSource);
    }

    private Message addOrderSource(Message message) throws JMSException {
        message.setStringProperty("X_ORDER_SOURCE","WEB");
        return message;
    }
 }
