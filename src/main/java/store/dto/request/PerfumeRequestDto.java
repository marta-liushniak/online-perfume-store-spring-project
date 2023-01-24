package store.dto.request;

import javax.validation.constraints.NotBlank;

public class PerfumeRequestDto {
    @NotBlank
    private String brandName;
    @NotBlank
    private String fragrance;
    @NotBlank
    private String country;

    public String getBrandName() {
        return brandName;
    }

    public String getFragrance() {
        return fragrance;
    }

    public String getCountry() {
        return country;
    }
}
