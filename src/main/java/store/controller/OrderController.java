package store.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.dto.mapper.ResponseDtoMapper;
import store.dto.response.OrderResponseDto;
import store.model.Basket;
import store.model.Order;
import store.model.User;
import store.service.BasketService;
import store.service.OrderService;
import store.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final BasketService basketService;
    private final OrderService orderService;
    private final ResponseDtoMapper<OrderResponseDto, Order> orderResponseDtoMapper;

    public OrderController(UserService userService,
                           BasketService basketService,
                           OrderService orderService,
                           ResponseDtoMapper<OrderResponseDto, Order> orderResponseDtoMapper) {
        this.userService = userService;
        this.basketService = basketService;
        this.orderService = orderService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Sorry, but user with email "
                        + email + " isn't found."));
        Basket basket = basketService.getByUser(user);
        return orderResponseDtoMapper.mapToDto(orderService.completeOrder(basket));
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Sorry, but user with email "
                        + email + " isn't found."));
        return orderService.getOrderHistory(user)
                .stream()
                .map(orderResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
