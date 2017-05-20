package mourad.hilmi.commons.jwt

import com.nimbusds.jose.JWSAlgorithm
import com.nimbusds.jose.JWSHeader
import com.nimbusds.jose.JWSObject
import com.nimbusds.jose.JWSSigner
import com.nimbusds.jose.JWSVerifier
import com.nimbusds.jose.Payload
import com.nimbusds.jose.crypto.MACSigner
import com.nimbusds.jose.crypto.MACVerifier
import mourad.hilmi.commons.exceptions.ExceptionsHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

/**
 * Created by moura on 5/20/2017.
 */
@Component
class NimbusJWT implements JWTHelper {

    @Autowired JWTConfig config
    @Autowired ExceptionsHandler exceptionsHandler
    @Override
    String tokenize(String payload) {

        Payload tokenPayload = new Payload(payload)

        JWSHeader tokenHeader = new JWSHeader(JWSAlgorithm.HS256)

        JWSObject token = new JWSObject(tokenHeader,tokenPayload)

        JWSSigner signer = new MACSigner(config.secret.getBytes())

        token.sign(signer)

        token.serialize()
    }

    @Override
    String deTokenize(String token) {
        try {
            def parsedToken = JWSObject.parse(token)
            JWSVerifier verifier = new MACVerifier(config.secret.getBytes())
            if(parsedToken.verify(verifier)){
                return parsedToken.payload.toString()
            }
            return null
        }catch(Exception e){
            exceptionsHandler.handle(e)
            return null
        }
    }
}
