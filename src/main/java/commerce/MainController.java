package commerce;

import commerce.users.User;
import commerce.errors.UserErrors;
import commerce.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping(path="/commerce")
public class MainController {
	@Autowired
	private UserRepository userRepository;

    @RequestMapping(method=RequestMethod.POST, value="/users/register")
    public @ResponseBody ResponseEntity<?> save(@Valid @RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path="/users/check")
    public @ResponseBody ResponseEntity<UserErrors> checkUser(@RequestParam(required = false) String email, @RequestParam(required = false) String username){
        if (email != null){
            User users = userRepository.findUserByEmail(email);
            UserErrors response = new UserErrors();

            if (users == null) {
                response.setResponseCode("404.100");
                response.setResponseMsg("Email not found.");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                response.setResponseCode("200.100");
                response.setResponseMsg("Email Exists");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } else if (username != null){
            User user = userRepository.findUserByUserName(username);
            UserErrors response = new UserErrors();

            if (user == null) {
                response.setResponseCode("404.000");
                response.setResponseMsg("Username not found.");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                response.setResponseCode("200.000");
                response.setResponseMsg("Username exists");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } else if (username == null) {
            UserErrors response = new UserErrors();
            response.setResponseCode("500.000");
            response.setResponseMsg("Username not provided.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            UserErrors response = new UserErrors();
            response.setResponseCode("500.000");
            response.setResponseMsg("email not provided.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping(path="/users/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
