package mourad.hilmi.controls.security

import mourad.hilmi.models.security.Role
import mourad.hilmi.models.security.User

/**
 * Created by moura on 5/20/2017.
 */
class AuthenticationWrapper {

    static class Request {
        String email;
        String password;
    }

    static class Response {
        String token
        User user
    }


}
