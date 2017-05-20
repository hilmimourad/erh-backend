package mourad.hilmi.controls.security

import mourad.hilmi.business.security.AuthenticationProcess
import mourad.hilmi.models.security.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by moura on 5/20/2017.
 */
@RestController
@RequestMapping('/security')
class AuthenticationController {
    @Autowired AuthenticationProcess authenticationProcess

    @RequestMapping(value='/authenticate',method = RequestMethod.POST)
    User authentify(@RequestBody AuthenticationRequest payload){
        def response = authenticationProcess.authenticate(payload.email, payload.password)
        response
    }
}
