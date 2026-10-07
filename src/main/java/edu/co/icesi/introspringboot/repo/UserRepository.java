package edu.co.icesi.introspringboot.repo;

import edu.co.icesi.introspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findDistinctByUserRoles_Role_RolePermissions_Permission_Name
            (
                    String permissionName
            );


    Optional<User> findByUsername(String username);
}
