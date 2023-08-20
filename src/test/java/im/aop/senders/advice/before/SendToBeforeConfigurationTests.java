package im.aop.senders.advice.before;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link SendToBeforeConfiguration}.
 *
 * @author Andy Lian
 */
class SendToBeforeConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendToBeforeConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendToBeforeAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendToBeforeAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToBeforeAdvice.class);
        });
  }

  @Test
  void sendToBeforeServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendToBeforeService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToBeforeService.class);
        });
  }
}
