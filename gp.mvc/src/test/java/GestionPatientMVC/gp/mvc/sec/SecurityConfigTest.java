package GestionPatientMVC.gp.mvc.sec;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@ContextConfiguration(classes = {SecurityConfig.class, AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class SecurityConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private AuthenticationTrustResolver authenticationTrustResolver;

    @MockBean
    private ContentNegotiationStrategy contentNegotiationStrategy;

    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @Autowired
    private SecurityConfig securityConfig;

    /**
     * Method under test: {@link SecurityConfig#passwordEncoder()}
     */
    @Test
    void testPasswordEncoder() {
        assertTrue(securityConfig.passwordEncoder() instanceof BCryptPasswordEncoder);
    }
}

