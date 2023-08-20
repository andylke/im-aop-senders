package im.aop.senders.advice.before;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendToBefore}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendToBeforeConfiguration {

  @Bean
  public SendToBeforeAdvice sendToBeforeAdvice() {
    return new SendToBeforeAdvice();
  }

  @Bean
  public SendToBeforeService sendToBeforeService(
      final AopSendersProperties aopExecutorsProperties) {
    return new SendToBeforeService(aopExecutorsProperties);
  }
}
