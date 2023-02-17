package sia.tacocloud.messaging;

import jakarta.jms.Destination;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import sia.tacocloud.domain.entities.TacoOrder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MessagingConfig {

    //This is a bean to configure the destination of the messages
    @Bean
    public Destination orderQueue(){
        return new ActiveMQQueue("tacocloud.order.queue");
    }

    @Bean
    public MappingJackson2MessageConverter messageConverter(){
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTypeIdPropertyName("_typeId");

        Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
        typeIdMappings.put("order", TacoOrder.class);
        messageConverter.setTypeIdMappings(typeIdMappings);

        return messageConverter;
    }
}
