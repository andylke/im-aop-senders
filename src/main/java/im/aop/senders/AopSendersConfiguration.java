package im.aop.senders;

import im.aop.senders.advice.aftercommit.SendAfterCommitConfiguration;
import im.aop.senders.advice.afterreturning.SendAfterReturningConfiguration;
import im.aop.senders.advice.afterthrowing.SendAfterThrowingConfiguration;
import im.aop.senders.advice.before.SendBeforeConfiguration;
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
@Import({
  SendBeforeConfiguration.class,
  SendAfterReturningConfiguration.class,
  SendAfterThrowingConfiguration.class,
  SendAfterCommitConfiguration.class
})
public class AopSendersConfiguration {}
