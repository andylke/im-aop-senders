package im.aop.senders.advice.before;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link SendBeforeConfiguration}.
 *
 * @author Andy Lian
 */
class SendBeforeConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendBeforeConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendBeforeAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendBeforeAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendBeforeAdvice.class);
        });
  }

  @Test
  void sendBeforeServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendBeforeService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendBeforeService.class);
        });
  }
}
