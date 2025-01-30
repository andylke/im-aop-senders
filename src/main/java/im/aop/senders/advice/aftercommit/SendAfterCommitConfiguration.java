package im.aop.senders.advice.aftercommit;

import im.aop.senders.AopSendersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link SendAfterCommit}.
 *
 * @author Andy Lian
 */
@Configuration(proxyBeanMethods = false)
public class SendAfterCommitConfiguration {

  @Bean
  public SendAfterCommitAdvice sendAfterCommitAdvice() {
    return new SendAfterCommitAdvice();
  }

  @Bean
  public SendAfterCommitService sendAfterCommitService(
      final AopSendersProperties aopExecutorsProperties) {
    return new SendAfterCommitService(aopExecutorsProperties);
  }
}
