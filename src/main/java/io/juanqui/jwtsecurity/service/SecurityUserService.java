package io.juanqui.jwtsecurity.service;

import io.juanqui.jwtsecurity.domain.Role;
import io.juanqui.jwtsecurity.domain.SecurityUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SecurityUserService {
    SecurityUser saveSecurityUser(SecurityUser securityUser);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    SecurityUser getSecurityUser(String username);
    List<SecurityUser> getSecurityUsers();

}
