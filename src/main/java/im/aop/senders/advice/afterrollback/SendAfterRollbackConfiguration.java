package im.aop.senders.advice.afterrollback;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendAfterRollback}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendAfterRollbackConfiguration {

  @Bean
  public SendAfterRollbackAdvice sendAfterRollbackAdvice() {
    return new SendAfterRollbackAdvice();
  }

  @Bean
  public SendAfterRollbackService sendAfterRollbackService(
      final AopSendersProperties aopExecutorsProperties) {
    return new SendAfterRollbackService(aopExecutorsProperties);
  }
}
