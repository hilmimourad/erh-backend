package mourad.hilmi.commons.hashing

import org.springframework.stereotype.Component

import java.security.MessageDigest

/**
 * Created by moura on 5/20/2017.
 */
@Component
class SHA256Hash implements Hasher {

    @Override
    String hash(String word) {
        MessageDigest.getInstance("SHA-256")
                .digest(word.getBytes("UTF-8")).encodeBase64().toString()
    }
}
