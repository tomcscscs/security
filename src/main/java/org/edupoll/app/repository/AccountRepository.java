package org.edupoll.app.repository;

import org.edupoll.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String>{

}
