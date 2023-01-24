package store.service;

import store.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
