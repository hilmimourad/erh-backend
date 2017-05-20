package mourad.hilmi.business.security

import mourad.hilmi.commons.hashing.Hasher
import mourad.hilmi.data.security.UserDAO
import mourad.hilmi.models.security.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by moura on 5/20/2017.
 */
@Component
class AuthenticationProcess {
    @Autowired UserDAO userDAO
    @Autowired Hasher hasher

    User authenticate(String email, String password){
        def user = userDAO.findByEmail(email)

        if(user == null) return null

        if(user.password != hasher.hash(password)) return null

        user.password = null;

        return user
    }
}
