package store.config;

import javax.annotation.PostConstruct;
import java.util.Set;
import org.springframework.stereotype.Component;
import store.model.Role;
import store.model.User;
import store.service.RoleService;
import store.service.UserService;

@Component
public class DataInit {
    private final UserService userService;
    private final RoleService roleService;

    public DataInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void injectData() {
        Role seller = new Role();
        seller.setRoleName(Role.RoleName.SELLER);
        roleService.add(seller);
        Role consumer = new Role();
        consumer.setRoleName(Role.RoleName.CONSUMER);
        roleService.add(consumer);
        User user = new User();
        user.setEmail("jinny@yahoo.com");
        user.setPassword("00700100");
        user.setRoles(Set.of(seller));
        userService.add(user);
    }
}
