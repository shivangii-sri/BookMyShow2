package com.BookMyShow.service.Mapper;

import com.BookMyShow.dtos.UserDto;
import com.BookMyShow.entities.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true),unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMyShowMapper {

    BookMyShowMapper INSTANCE= Mappers.getMapper(BookMyShowMapper.class);

    UserDto toUserDto(User user);

}
