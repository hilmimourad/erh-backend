package mourad.hilmi.commons.jwt

/**
 * Created by moura on 5/20/2017.
 */
interface JWTHelper {

    String tokenize(String payload)
    String deTokenize(String token)
}