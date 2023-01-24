package store.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import store.dto.mapper.RequestDtoMapper;
import store.dto.mapper.ResponseDtoMapper;
import store.dto.request.PerfumeRequestDto;
import store.dto.response.PerfumeResponseDto;
import store.model.Perfume;
import store.service.PerfumeService;

@RestController
@RequestMapping("/perfumes")
public class PerfumeController {
    private final PerfumeService perfumeService;
    private final RequestDtoMapper<PerfumeRequestDto, Perfume> perfumeRequestDtoMapper;
    private final ResponseDtoMapper<PerfumeResponseDto, Perfume> perfumeResponseDtoMapper;

    public PerfumeController(PerfumeService perfumeService,
                             RequestDtoMapper<PerfumeRequestDto, Perfume>
                                     perfumeRequestDtoMapper,
                             ResponseDtoMapper<PerfumeResponseDto, Perfume>
                                     perfumeResponseDtoMapper) {
        this.perfumeService = perfumeService;
        this.perfumeRequestDtoMapper = perfumeRequestDtoMapper;
        this.perfumeResponseDtoMapper = perfumeResponseDtoMapper;
    }

    @PostMapping
    public PerfumeResponseDto add(@RequestBody @Valid PerfumeRequestDto perfumeRequestDto) {
        Perfume perfume = perfumeService.add(perfumeRequestDtoMapper.mapToModel(perfumeRequestDto));
        return perfumeResponseDtoMapper.mapToDto(perfume);
    }

    @GetMapping
    public List<PerfumeResponseDto> getAll() {
        return perfumeService.getAll()
                .stream()
                .map(perfumeResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
