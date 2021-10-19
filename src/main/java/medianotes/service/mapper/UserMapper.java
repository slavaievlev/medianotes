package medianotes.service.mapper;

import medianotes.dto.user.UserWithRolesDto;
import medianotes.entity.Role;
import medianotes.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserWithRolesDto mapUserToUserWithRolesDto(User user) {
        return new UserWithRolesDto(
                user.getId(),
                user.getEmail(),
                user.getRoles().stream().map(Role::getCode).collect(Collectors.toList())
        );
    }

    public List<UserWithRolesDto> mapUserToUserWithRolesDto(Collection<User> users) {
        return users.stream()
                .map(this::mapUserToUserWithRolesDto)
                .distinct()
                .collect(Collectors.toList());
    }
}
