package im.aop.senders;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration Auto-configuration} for AOP
 * Senders.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(
    prefix = AopSendersProperties.PREFIX,
    name = "enabled",
    havingValue = "true",
    matchIfMissing = true)
@Import(AopSendersConfiguration.class)
public class AopSendersAutoConfiguration {

}
