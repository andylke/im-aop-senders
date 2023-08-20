package im.aop.senders.advice.aftercommit;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendToAfterCommit}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendToAfterCommitConfiguration {

  @Bean
  public SendToAfterCommitAdvice sendToAfterCommitAdvice() {
    return new SendToAfterCommitAdvice();
  }

  @Bean
  public SendToAfterCommitService sendToAfterCommitService(
      final AopSendersProperties aopExecutorsProperties) {
    return new SendToAfterCommitService(aopExecutorsProperties);
  }
}
