package commerce.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFunctions implements UserImplementation{
    @Autowired
    private UserRepository repo;

    @Override
    public User findUserByUserName(String username){
        User users = repo.findUserByUserName(username);
        return users;
    }

    @Override
    public User findUserByEmail(String email){
        User users = repo.findUserByEmail(email);
        return users;
    }
}
