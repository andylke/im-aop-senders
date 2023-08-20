package im.aop.senders;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.advice.afterreturning.SendToAfterReturningConfiguration;
import im.aop.senders.advice.afterthrowing.SendToAfterThrowingConfiguration;
import im.aop.senders.advice.before.SendToBeforeConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link AopSendersConfiguration}.
 *
 * @author Andy Lian
 */
class AopSendersConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner().withUserConfiguration(AopSendersConfiguration.class);

  @Test
  void aopSendersPropertiesNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(AopSendersProperties.class))
              .isNotNull()
              .isExactlyInstanceOf(AopSendersProperties.class);
        });
  }

  @Test
  void sendToBeforeConfigurationNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendToBeforeConfiguration.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToBeforeConfiguration.class);
        });
  }


  @Test
  void sendToAfterReturningConfigurationNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendToAfterReturningConfiguration.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToAfterReturningConfiguration.class);
        });
  }


  @Test
  void sendToAfterThrowingConfigurationNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendToAfterThrowingConfiguration.class))
              .isNotNull()
              .isExactlyInstanceOf(SendToAfterThrowingConfiguration.class);
        });
  }
}
