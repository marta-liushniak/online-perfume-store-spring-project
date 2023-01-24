package store.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import store.dto.mapper.ResponseDtoMapper;
import store.dto.response.BasketResponseDto;
import store.model.Basket;
import store.model.Perfume;
import store.model.User;
import store.service.BasketService;
import store.service.PerfumeService;
import store.service.UserService;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    private final UserService userService;
    private final BasketService basketService;
    private final PerfumeService perfumeService;
    private final ResponseDtoMapper<BasketResponseDto, Basket> basketResponseDtoMapper;

    public BasketController(UserService userService,
                            BasketService basketService,
                            PerfumeService perfumeService,
                            ResponseDtoMapper<BasketResponseDto, Basket>
                                    basketResponseDtoMapper) {
        this.userService = userService;
        this.basketService = basketService;
        this.perfumeService = perfumeService;
        this.basketResponseDtoMapper = basketResponseDtoMapper;
    }

    @PutMapping("/perfumes")
    public void addToBasket(Authentication authentication, @RequestParam Long perfumeId) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Sorry, but user with email "
                        + email + " isn't found."));
        Perfume perfume = perfumeService.get(perfumeId);
        basketService.addPerfume(perfume, user);
    }

    @GetMapping("/by-user")
    public BasketResponseDto getByUser(Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Sorry, but user with email "
                        + email + " isn't found."));
        return basketResponseDtoMapper.mapToDto(basketService.getByUser(user));
    }
}
