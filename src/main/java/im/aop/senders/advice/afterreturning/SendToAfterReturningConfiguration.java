package im.aop.senders.advice.afterreturning;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendToAfterCommit}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendToAfterReturningConfiguration {

  @Bean
  public SendToAfterReturningAdvice sendToAfterReturningAdvice() {
    return new SendToAfterReturningAdvice();
  }

  @Bean
  public SendToAfterReturningService sendToAfterReturningService(
      final AopSendersProperties aopExecutorsProperties) {
    return new SendToAfterReturningService(aopExecutorsProperties);
  }
}
