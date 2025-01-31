package im.aop.senders.advice.beforecommit;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link SendBeforeCommitConfiguration}.
 *
 * @author Andy Lian
 */
class SendBeforeCommitConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendBeforeCommitConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendBeforeCommitAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendBeforeCommitAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendBeforeCommitAdvice.class);
        });
  }

  @Test
  void sendBeforeCommitServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendBeforeCommitService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendBeforeCommitService.class);
        });
  }
}
