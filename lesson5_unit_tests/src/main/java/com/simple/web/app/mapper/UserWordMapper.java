package com.simple.web.app.mapper;

import com.simple.web.app.dto.UserWordDto;
import com.simple.web.app.entity.UserWord;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserWordMapper {

    List<UserWord> mapDtosToEntities(List<UserWordDto> itemDtoList);

    List<UserWordDto> mapEntitiesToDtos(List<UserWord> itemList);
}
