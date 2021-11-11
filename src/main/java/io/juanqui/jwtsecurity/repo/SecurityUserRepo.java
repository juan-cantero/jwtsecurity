package io.juanqui.jwtsecurity.repo;

import io.juanqui.jwtsecurity.domain.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityUserRepo extends JpaRepository<SecurityUser,Long> {
    SecurityUser findByUsername(String username);
}
