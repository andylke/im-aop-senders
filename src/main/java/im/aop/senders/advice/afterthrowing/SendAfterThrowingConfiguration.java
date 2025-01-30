package im.aop.senders.advice.afterthrowing;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendAfterThrowing}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendAfterThrowingConfiguration {

  @Bean
  public SendAfterThrowingAdvice sendAfterThrowingAdvice() {
    return new SendAfterThrowingAdvice();
  }

  @Bean
  public SendAfterThrowingService sendAfterThrowingService(
      final AopSendersProperties aopExecutorsProperties) {
    return new SendAfterThrowingService(aopExecutorsProperties);
  }
}
