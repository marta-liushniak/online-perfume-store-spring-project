package store.dto.request;

import java.util.List;

public class UserRequestDto {
    private String email;
    private String password;
    private List<Long> roleId;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Long> getRoleId() {
        return roleId;
    }
}
