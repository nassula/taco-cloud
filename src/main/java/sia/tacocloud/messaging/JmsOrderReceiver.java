package sia.tacocloud.messaging;

import jakarta.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import sia.tacocloud.domain.entities.TacoOrder;

@Component
public class JmsOrderReceiver{

    private JmsTemplate jmsTemplate;
    @Autowired
    public JmsOrderReceiver(JmsTemplate jmsTemplate, MessageConverter messageConverter) {
        this.jmsTemplate = jmsTemplate;
    }

    public TacoOrder receiveOrder() throws JMSException {
        return (TacoOrder) jmsTemplate.receiveAndConvert("tacocloud.order.queue");
    }
}
