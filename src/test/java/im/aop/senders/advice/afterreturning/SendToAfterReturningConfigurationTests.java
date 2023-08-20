package im.aop.senders.advice.afterreturning;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link SendToAfterCommitConfiguration}.
 *
 * @author Andy Lian
 */
class SendToAfterReturningConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendToAfterReturningConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendToBeforeAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendToAfterReturningAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToAfterReturningAdvice.class);
        });
  }

  @Test
  void sendToBeforeServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendToAfterReturningService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToAfterReturningService.class);
        });
  }
}
