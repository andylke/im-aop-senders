package im.aop.senders.advice.afterrollback;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link SendAfterRollbackConfiguration}.
 *
 * @author Andy Lian
 */
class SendAfterRollbackConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendAfterRollbackConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendAfterRollbackAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterRollbackAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterRollbackAdvice.class);
        });
  }

  @Test
  void sendAfterRollbackServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterRollbackService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterRollbackService.class);
        });
  }
}
