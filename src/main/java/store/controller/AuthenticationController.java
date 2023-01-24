package store.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import store.dto.mapper.ResponseDtoMapper;
import store.dto.request.UserRequestDto;
import store.dto.response.UserResponseDto;
import store.model.User;
import store.service.AuthenticationService;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    ResponseDtoMapper<UserResponseDto, User>
                                            userResponseDtoMapper) {
        this.authenticationService = authenticationService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @PostMapping("/registration")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User user = authenticationService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userResponseDtoMapper.mapToDto(user);
    }
}
