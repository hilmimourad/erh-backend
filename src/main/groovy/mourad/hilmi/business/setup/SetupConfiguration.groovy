package mourad.hilmi.business.setup

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by moura on 5/20/2017.
 */
@Component
@ConfigurationProperties("setup")
class SetupConfiguration {

    String email
    String password
    String fullName
}
