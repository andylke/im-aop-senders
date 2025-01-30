package im.aop.senders.advice.before;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendBefore}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendBeforeConfiguration {

  @Bean
  public SendBeforeAdvice sendBeforeAdvice() {
    return new SendBeforeAdvice();
  }

  @Bean
  public SendBeforeService sendBeforeService(final AopSendersProperties aopExecutorsProperties) {
    return new SendBeforeService(aopExecutorsProperties);
  }
}
