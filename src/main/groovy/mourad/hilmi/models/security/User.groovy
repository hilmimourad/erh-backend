package mourad.hilmi.models.security

import org.springframework.data.annotation.Id

/**
 * Created by moura on 5/20/2017.
 */

class User {
    @Id
    String id;

    String email;
    String fullName;
    String password;
    List<Role> roles;
}
