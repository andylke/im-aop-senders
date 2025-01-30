package im.aop.senders.advice.afterreturning;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link SendAfterReturningConfiguration}.
 *
 * @author Andy Lian
 */
class SendAfterReturningConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendAfterReturningConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendBeforeAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterReturningAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterReturningAdvice.class);
        });
  }

  @Test
  void sendBeforeServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterReturningService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterReturningService.class);
        });
  }
}
