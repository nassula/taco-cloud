package sia.tacocloud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.domain.entities.TacoOrder;
import sia.tacocloud.domain.entities.UserTaco;
import sia.tacocloud.repository.OrderRepository;
import sia.tacocloud.repository.UserRepository;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private final UserRepository userRepository;

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository,
                           UserRepository userRepository){
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal UserTaco userTaco){

        if (errors.hasErrors()){
            return "orderForm";
        }
        order.setUserTaco(userTaco);

        log.info("Order submitted: {}", order);
        orderRepository.save(order);

        sessionStatus.setComplete();
        return "redirect:/";
    }

}
