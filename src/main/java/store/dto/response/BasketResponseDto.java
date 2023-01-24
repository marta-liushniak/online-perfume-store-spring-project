package store.dto.response;

import java.util.List;

public class BasketResponseDto {
    private Long userId;
    private List<Long> chosenIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getChosenIds() {
        return chosenIds;
    }

    public void setChosenIds(List<Long> chosenIds) {
        this.chosenIds = chosenIds;
    }
}
