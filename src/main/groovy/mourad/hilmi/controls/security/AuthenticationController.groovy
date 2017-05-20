package mourad.hilmi.controls.security

import com.sun.org.apache.xpath.internal.operations.Bool
import mourad.hilmi.business.security.AuthenticationProcess
import mourad.hilmi.commons.jwt.JWTHelper
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
    @Autowired JWTHelper jwtHelper

    @RequestMapping(value='/authenticate',method = RequestMethod.POST)
    AuthenticationWrapper.Response authenticate(@RequestBody AuthenticationWrapper.Request payload){
        def response = authenticationProcess.authenticate(payload.email, payload.password)

        if(response == null) return null

        response.id = null
        def token = jwtHelper.tokenize(response.toString())
        new AuthenticationWrapper.Response(token: token,user: response)
    }

    @RequestMapping(value = '/checkToken',method = RequestMethod.POST)
    Boolean checkToken(@RequestBody String token) {
        def response = jwtHelper.deTokenize(token)
        response !=  null
    }
}
