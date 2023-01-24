package store.dto.mapper.impl;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import store.dto.mapper.ResponseDtoMapper;
import store.dto.response.OrderResponseDto;
import store.model.Chosen;
import store.model.Order;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setChosenIds(order.getChosen()
                .stream()
                .map(Chosen::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setUserId(order.getUser().getId());
        orderResponseDto.setOrderTime(order.getOrderTime());
        return orderResponseDto;
    }
}
