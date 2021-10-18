package medianotes.repository;

import medianotes.entity.User;
import medianotes.entity.projection.UserIdProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends
        JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);

    UserIdProjection findOneByEmail(String email);

    @EntityGraph("User.roles")
    @Query("select u from User u")
    List<User> findAllWithRoles();
}
