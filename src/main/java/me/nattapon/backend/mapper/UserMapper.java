package me.nattapon.backend.mapper;

import me.nattapon.backend.entity.User;
import me.nattapon.backend.model.MRegisterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    MRegisterResponse toRegisterResponse(User user);

}
