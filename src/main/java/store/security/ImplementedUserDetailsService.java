package store.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import store.model.User;
import store.service.UserService;

@Service
public class ImplementedUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public ImplementedUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findByEmail(email);
        User user = optionalUser.orElseThrow(
                () -> new UsernameNotFoundException("Can't find user by email: " + email));
        UserBuilder builder = withUsername(email);
        builder.password(optionalUser.get().getPassword());
        builder.roles(optionalUser.get().getRoles()
                .stream()
                .map(u -> u.getRoleName().name())
                .toArray(String[]::new));
        return builder.build();
    }
}
