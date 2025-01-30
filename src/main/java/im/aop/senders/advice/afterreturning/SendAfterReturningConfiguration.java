package im.aop.senders.advice.afterreturning;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendAfterReturning}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendAfterReturningConfiguration {

  @Bean
  public SendAfterReturningAdvice sendAfterReturningAdvice() {
    return new SendAfterReturningAdvice();
  }

  @Bean
  public SendAfterReturningService sendAfterReturningService(
      final AopSendersProperties aopExecutorsProperties) {
    return new SendAfterReturningService(aopExecutorsProperties);
  }
}
