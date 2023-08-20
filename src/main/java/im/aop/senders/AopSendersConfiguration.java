package im.aop.senders;

import im.aop.senders.advice.afterreturning.SendToAfterReturningConfiguration;
import im.aop.senders.advice.afterthrowing.SendToAfterThrowingConfiguration;
import im.aop.senders.advice.before.SendToBeforeConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration for AOP Senders.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({AopSendersProperties.class})
@Import({SendToBeforeConfiguration.class, SendToAfterReturningConfiguration.class,
    SendToAfterThrowingConfiguration.class})
public class AopSendersConfiguration {

}
