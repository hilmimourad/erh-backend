package mourad.hilmi.data.security

import mourad.hilmi.models.security.User
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by moura on 5/20/2017.
 */
interface UserDAO extends MongoRepository<User,String>  {
    User findByEmail(String email);
}
