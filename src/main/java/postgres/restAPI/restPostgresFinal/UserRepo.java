package postgres.restAPI.restPostgresFinal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Integer>{
	public List<UserModel> findByEmailAndPassword(String email, String Password);
}
