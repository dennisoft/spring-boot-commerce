package commerce.users;

import java.util.List;

public interface UserImplementation{
    User findUserByUserName(String chars);
    User findUserByEmail(String email);
}
