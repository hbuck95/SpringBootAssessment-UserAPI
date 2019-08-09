package com.bae.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT u FROM User u WHERE u.memberId = :memberId")
	User findByMemberId(@Param("memberId") int memberId);

}