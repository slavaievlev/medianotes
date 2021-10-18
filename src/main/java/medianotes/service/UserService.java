package medianotes.service;

import medianotes.dto.user.UserWithRolesDto;
import medianotes.dto.user.filter.UserFilterDto;

import java.util.Collection;
import java.util.List;

public interface UserService {

    Integer getId(String email);

    void editRole(Integer userId, Collection<String> roleCodes);

    List<UserWithRolesDto> getUsers();

    List<UserWithRolesDto> getUsers(Collection<UserFilterDto> filters);
}
