package core.converter;

import core.domain.BaseEntity;
import core.dto.BaseDto;

/**
 * Created by radu.
 */

public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {
    Model convertDtoToModel(Dto dto);
    Dto convertModelToDto(Model model);
}

