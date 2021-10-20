package medianotes.controller;

import medianotes.dto.user.UserWithRolesDto;
import medianotes.dto.user.filter.UserFilterDto;
import medianotes.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{email}/roles")
    public void editRoles(@PathVariable String email,
                          @RequestBody Collection<String> newRoleCodes) {
        Integer userId = userService.getId(email);

        userService.editRole(userId, newRoleCodes);
    }

    @GetMapping
    public List<UserWithRolesDto> getUsers() {
        return userService.getUsers();
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public List<UserWithRolesDto> getUsers(@RequestBody Collection<UserFilterDto> filters) {
        return userService.getUsers(filters);
    }
}
