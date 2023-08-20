package im.aop.senders.advice.afterthrowing;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link SendToAfterThrowingConfiguration}.
 *
 * @author Andy Lian
 */
class SendToAfterThrowingConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendToAfterThrowingConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendToAfterThrowingAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(
              SendToAfterThrowingAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToAfterThrowingAdvice.class);
        });
  }

  @Test
  void sendToAfterThrowingServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(
              SendToAfterThrowingService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToAfterThrowingService.class);
        });
  }
}
