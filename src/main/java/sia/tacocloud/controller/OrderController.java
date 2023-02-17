package sia.tacocloud.controller;

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
import sia.tacocloud.repository.OrderRepository;
import sia.tacocloud.repository.UserRepository;

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

    @PatchMapping(path = "/{orderId}")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder patch){

        TacoOrder order = orderRepository.findById(orderId).get();

        if(patch.getDeliveryName() != null){
            order.setDeliveryName(patch.getDeliveryName());
        }
        if(patch.getDeliveryStreet() != null){
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if(patch.getDeliveryCity() != null){
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if(patch.getDeliveryState() != null){
            order.setDeliveryState(patch.getDeliveryState());
        }
        if(patch.getDeliveryZip() != null){
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if(patch.getCcNumber() != null){
            order.setCcNumber(patch.getCcNumber());
        }
        if(patch.getCcExpiration() != null){
            order.setCcExpiration(patch.getCcExpiration());
        }
        if(patch.getCcCVV() != null){
            order.setCcCVV(patch.getCcCVV());
        }

        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderID") Long orderId){
        try{
            orderRepository.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {}
    }

}
