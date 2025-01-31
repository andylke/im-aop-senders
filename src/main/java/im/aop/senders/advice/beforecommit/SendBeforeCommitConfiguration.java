package im.aop.senders.advice.beforecommit;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendBeforeCommit}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendBeforeCommitConfiguration {

  @Bean
  public SendBeforeCommitAdvice sendBeforeCommitAdvice() {
    return new SendBeforeCommitAdvice();
  }

  @Bean
  public SendBeforeCommitService sendBeforeCommitService(
      final AopSendersProperties aopExecutorsProperties) {
    return new SendBeforeCommitService(aopExecutorsProperties);
  }
}
