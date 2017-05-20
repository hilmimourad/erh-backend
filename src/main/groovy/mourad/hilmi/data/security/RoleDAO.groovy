package mourad.hilmi.data.security

import mourad.hilmi.models.security.Role
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by moura on 5/20/2017.
 */
interface RoleDAO extends MongoRepository<Role,String> {

    Role findByName(String name)
}