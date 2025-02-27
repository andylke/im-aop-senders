package im.aop.senders.advice.aftercommit;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link SendAfterCommitConfiguration}.
 *
 * @author Andy Lian
 */
class SendAfterCommitConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendAfterCommitConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendAfterCommitAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterCommitAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterCommitAdvice.class);
        });
  }

  @Test
  void sendAfterCommitServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterCommitService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterCommitService.class);
        });
  }
}
