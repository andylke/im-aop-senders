package im.aop.senders.advice.afterthrowing;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link SendAfterThrowingConfiguration}.
 *
 * @author Andy Lian
 */
class SendAfterThrowingConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendAfterThrowingConfiguration.class)
          .withBean(AopSendersProperties.class);

  @Test
  void sendAfterThrowingAdviceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterThrowingAdvice.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterThrowingAdvice.class);
        });
  }

  @Test
  void sendAfterThrowingServiceNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterThrowingService.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterThrowingService.class);
        });
  }
}
