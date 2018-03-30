package commerce.users;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select * from users where user_name = ?1", nativeQuery = true)
    User findUserByUserName(String chars);

    @Query(value = "select * from users where email = ?1", nativeQuery = true)
    User findUserByEmail(String chars);
}
