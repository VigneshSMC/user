package com.davincicell.user.repo;

import com.davincicell.user.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserData, Long>{
    UserData findByUsername(String username);
}
