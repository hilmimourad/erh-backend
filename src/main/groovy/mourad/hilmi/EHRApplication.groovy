package mourad.hilmi

import mourad.hilmi.business.setup.SetupWizard
import mourad.hilmi.commons.jwt.JWTConfig
import mourad.hilmi.data.security.RoleDAO
import mourad.hilmi.models.security.Role
import mourad.hilmi.models.security.SecurityModelsConstants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by moura on 5/20/2017.
 */
@SpringBootApplication
class EHRApplication implements CommandLineRunner {

    @Autowired private SetupWizard setupWizard;

    @Autowired JWTConfig config


    static void main(String[] args){
        SpringApplication.run(EHRApplication.class,args)
    }

    @Override
    void run(String... args) throws Exception {
      setupWizard.setup()
        println "SECRET" + config.secret
    }

}
