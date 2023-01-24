package store.dto.mapper.impl;

import org.springframework.stereotype.Component;
import store.dto.mapper.ResponseDtoMapper;
import store.dto.response.UserResponseDto;
import store.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {

    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
