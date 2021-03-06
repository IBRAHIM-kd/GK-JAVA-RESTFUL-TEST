package org.cca.com.GKJAVARESTFULTEST.repository;

import org.cca.com.GKJAVARESTFULTEST.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long>{
    UserDetail findByUsername(String username);

}
