package medianotes.service.impl;

import medianotes.dto.user.UserWithRolesDto;
import medianotes.dto.user.filter.UserFilterDto;
import medianotes.entity.Role;
import medianotes.entity.User;
import medianotes.repository.RoleRepository;
import medianotes.repository.UserRepository;
import medianotes.repository.specification.UserSpecification;
import medianotes.service.UserService;
import medianotes.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class JpaUserService implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public JpaUserService(UserRepository userRepository,
                          RoleRepository roleRepository,
                          UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Integer getId(String email) {
        return userRepository.findOneByEmail(email).getId();
    }

    @Transactional
    @Override
    public void editRole(Integer userId, Collection<String> roleCodes) {
        User user = userRepository.findById(userId).orElseThrow();

        Set<Role> newRoles = roleRepository.findAllByCodeIn(roleCodes);

        user.setRoles(newRoles);

        userRepository.save(user);
    }

    @Override
    public List<UserWithRolesDto> getUsers() {
        List<User> users = userRepository.findAllWithRoles();
        return userMapper.mapUserToUserWithRolesDto(users);
    }

    @Override
    public List<UserWithRolesDto> getUsers(Collection<UserFilterDto> filters) {
        List<User> users = userRepository.findAll(UserSpecification.findUsers(filters));
        return userMapper.mapUserToUserWithRolesDto(users);
    }
}
