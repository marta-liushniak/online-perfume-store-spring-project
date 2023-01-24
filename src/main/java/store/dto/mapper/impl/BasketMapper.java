package store.dto.mapper.impl;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import store.dto.mapper.ResponseDtoMapper;
import store.dto.response.BasketResponseDto;
import store.model.Basket;
import store.model.Chosen;

@Component
public class BasketMapper implements ResponseDtoMapper<BasketResponseDto, Basket> {

    @Override
    public BasketResponseDto mapToDto(Basket basket) {
        BasketResponseDto basketResponseDto = new BasketResponseDto();
        basketResponseDto.setUserId(basket.getUser().getId());
        basketResponseDto.setChosenIds(basket.getChosen()
                .stream()
                .map(Chosen::getId)
                .collect(Collectors.toList()));
        return basketResponseDto;
    }
}
