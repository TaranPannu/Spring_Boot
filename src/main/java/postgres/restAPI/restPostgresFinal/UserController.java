package postgres.restAPI.restPostgresFinal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserRepo repo;
	
	@CrossOrigin
	@PostMapping("/addUser")
	public ResponseEntity<?> getuser(@RequestBody UserModel user) {
		System.out.println("Got the register request");
		
		repo.save(user);
		
		List<UserModel> users = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if (users.size()>=1){
			Map<String, Object> response = new HashMap<>();
	        response.put("userExists", true);
	        
	        return ResponseEntity.ok(response);
		}else {
			Map<String, Object> response = new HashMap<>();
			response.put("userExists", false);
	        
	        return ResponseEntity.ok(response);
		}
	}
	
	
	@CrossOrigin
	@PostMapping("/getLoginInfo")
	public ResponseEntity<?> getuser_login(@RequestBody UserModel user) {
		List<UserModel> users = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		System.out.println("Got the login request");
		
		if (users.size()>=1){
			Map<String, Object> response = new HashMap<>();
	        response.put("userExists", true);
	        response.put("name", users.get(0).getName());
	        response.put("email", users.get(0).getEmail());
	        return ResponseEntity.ok(response);
		}else {
			Map<String, Object> response = new HashMap<>();
	        response.put("userExists", true);
	        return ResponseEntity.ok(response);
	        
		}
		
		
	}
}
