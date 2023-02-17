package sia.tacocloud.controller.rest;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.domain.entities.TacoOrder;
import sia.tacocloud.domain.entities.UserTaco;
import sia.tacocloud.messaging.OrderMessagingService;
import sia.tacocloud.repository.OrderRepository;
import sia.tacocloud.repository.UserRepository;

@Slf4j
@RestController
@RequestMapping(path = "/api/orders", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderApiController {
    private OrderRepository orderRepository;

    private OrderMessagingService messagingService;

    @Autowired
    public OrderApiController(OrderRepository orderRepository,
                              OrderMessagingService messagingService){
        this.orderRepository = orderRepository;
        this.messagingService = messagingService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TacoOrder postOrder(@RequestBody TacoOrder order){

        messagingService.sendOrder(order);
        log.info("Order submitted: {}", order);

        return orderRepository.save(order);
    }
}
