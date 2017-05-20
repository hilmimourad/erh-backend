package mourad.hilmi.commons.jwt

import jdk.nashorn.internal.objects.annotations.Setter
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

import java.awt.ComponentOrientation

/**
 * Created by moura on 5/20/2017.
 */
@Component
@ConfigurationProperties("jwt")
class JWTConfig {
    String secret
}
