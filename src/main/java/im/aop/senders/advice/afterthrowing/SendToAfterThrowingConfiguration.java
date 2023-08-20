package im.aop.senders.advice.afterthrowing;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendToAfterThrowing}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendToAfterThrowingConfiguration {

  @Bean
  public SendToAfterThrowingAdvice sendToAfterThrowingAdvice() {
    return new SendToAfterThrowingAdvice();
  }

  @Bean
  public SendToAfterThrowingService sendToAfterThrowingService(
      final AopSendersProperties aopExecutorsProperties) {
    return new SendToAfterThrowingService(aopExecutorsProperties);
  }
}
