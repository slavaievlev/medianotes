package medianotes.service;

import medianotes.dto.authentication.UserAuthenticationInfoDto;
import medianotes.dto.user.UserWithRolesDto;
import medianotes.dto.user.filter.UserFilterDto;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Integer getId(String email);

    void editRole(Integer userId, Collection<String> roleCodes);

    List<UserWithRolesDto> getUsers();

    List<UserWithRolesDto> getUsers(Collection<UserFilterDto> filters);

    Optional<UserAuthenticationInfoDto> findAuthenticationInfo(String email);
}
