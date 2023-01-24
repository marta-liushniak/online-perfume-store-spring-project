package store.service.impl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import store.model.Role;
import store.model.User;
import store.service.AuthenticationService;
import store.service.BasketService;
import store.service.RoleService;
import store.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;
    private final BasketService basketService;

    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService,
                                     BasketService basketService) {
        this.userService = userService;
        this.roleService = roleService;
        this.basketService = basketService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getByName(Role.RoleName.CONSUMER.name()));
        user.setRoles(roleSet);
        userService.add(user);
        basketService.registerNewBasket(user);
        return user;
    }
}
