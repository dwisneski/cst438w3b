package cst438.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u order by name, sequence")
	List<User> findAllOrderbyNameSequence( );

}
