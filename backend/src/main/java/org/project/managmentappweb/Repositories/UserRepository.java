package org.project.managmentappweb.Repositories;

import org.project.managmentappweb.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

    User findByEmail(String email);

    User findByVerificationToken(String token);
}