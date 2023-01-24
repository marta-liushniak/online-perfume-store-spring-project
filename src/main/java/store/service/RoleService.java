package store.service;

import store.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
