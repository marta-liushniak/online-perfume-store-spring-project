package store.dto.mapper.impl;

import org.springframework.stereotype.Component;
import store.dto.mapper.RequestDtoMapper;
import store.dto.mapper.ResponseDtoMapper;
import store.dto.request.PerfumeRequestDto;
import store.dto.response.PerfumeResponseDto;
import store.model.Perfume;

@Component
public class PerfumeMapper implements RequestDtoMapper<PerfumeRequestDto, Perfume>,
        ResponseDtoMapper<PerfumeResponseDto, Perfume> {

    @Override
    public Perfume mapToModel(PerfumeRequestDto dto) {
        Perfume perfume = new Perfume();
        perfume.setBrandName(dto.getBrandName());
        perfume.setFragrance(dto.getFragrance());
        perfume.setCountry(dto.getCountry());
        return perfume;
    }

    @Override
    public PerfumeResponseDto mapToDto(Perfume perfume) {
        PerfumeResponseDto perfumeResponseDto = new PerfumeResponseDto();
        perfumeResponseDto.setId(perfume.getId());
        perfumeResponseDto.setBrandName(perfume.getBrandName());
        perfumeResponseDto.setFragrance(perfume.getFragrance());
        perfumeResponseDto.setCountry(perfume.getCountry());
        return perfumeResponseDto;
    }
}
