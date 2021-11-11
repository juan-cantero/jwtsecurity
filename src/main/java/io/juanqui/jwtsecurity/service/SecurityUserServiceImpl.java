package io.juanqui.jwtsecurity.service;

import io.juanqui.jwtsecurity.domain.Role;
import io.juanqui.jwtsecurity.domain.SecurityUser;
import io.juanqui.jwtsecurity.repo.RoleRepo;
import io.juanqui.jwtsecurity.repo.SecurityUserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SecurityUserServiceImpl implements SecurityUserService{
    private final SecurityUserRepo securityUserRepo;
    private  final RoleRepo roleRepo;

    @Override
    public SecurityUser saveSecurityUser(SecurityUser securityUser) {
        log.info("saving new user {} to database", securityUser.getName());
        return securityUserRepo.save(securityUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to database ",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding role {} to user {} to database ",roleName,username);

        SecurityUser securityUser = securityUserRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        securityUser.getRoles().add(role);
    }

    @Override
    public SecurityUser getSecurityUser(String username) {
        log.info("fetching user {}", username);
        return securityUserRepo.findByUsername(username);
    }

    @Override
    public List<SecurityUser> getSecurityUsers() {
        log.info("fetching all the users");
        return securityUserRepo.findAll();
    }
}
