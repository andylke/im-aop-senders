package im.aop.senders.advice.aftercommit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import im.aop.senders.AopSendersProperties;

/**
 * Tests for {@link SendToAfterCommitConfiguration}.
 *
 * @author Andy Lian
 */
class SendToAfterCommitConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendToAfterCommitConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendToBeforeAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendToAfterCommitAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToAfterCommitAdvice.class);
        });
  }

  @Test
  void sendToBeforeServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendToAfterCommitService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToAfterCommitService.class);
        });
  }
}
