package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
		
	@Query("select a from Account a where a.userid = :userid")
	public Account findByUserId(@Param("userid") String userid);
	
	@Query("select a from Account a where a.userid = :userid and a.password = :password")
	public Account findByUserIdAndPassword(@Param("userid") String userid, @Param("password") String password);

}
