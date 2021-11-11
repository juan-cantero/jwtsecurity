package io.juanqui.jwtsecurity.api;

import io.juanqui.jwtsecurity.domain.Role;
import io.juanqui.jwtsecurity.domain.SecurityUser;
import io.juanqui.jwtsecurity.service.SecurityUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SecurityUserResource {
    @Autowired
    private SecurityUserService securityUserService;

    @GetMapping("/users")
    public ResponseEntity<List<SecurityUser>> getSecurityUser() {
        return ResponseEntity.ok().body(securityUserService.getSecurityUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<SecurityUser> saveUser(@RequestBody SecurityUser securityUser) {
        URI uri =
                URI.create(ServletUriComponentsBuilder
                        .fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(securityUserService.saveSecurityUser(securityUser));

    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri =
                URI.create(ServletUriComponentsBuilder
                        .fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(securityUserService.saveRole(role));

    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm roleToUserForm) {
        securityUserService.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRoleName());
        return ResponseEntity.ok().build();

    }


}


@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
