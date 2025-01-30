package im.aop.senders;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.advice.aftercommit.SendAfterCommitConfiguration;
import im.aop.senders.advice.afterreturning.SendAfterReturningConfiguration;
import im.aop.senders.advice.afterthrowing.SendAfterThrowingConfiguration;
import im.aop.senders.advice.before.SendBeforeConfiguration;
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
  void sendBeforeConfigurationNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendBeforeConfiguration.class))
              .isNotNull()
              .isExactlyInstanceOf(SendBeforeConfiguration.class);
        });
  }

  @Test
  void sendAfterReturningConfigurationNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterReturningConfiguration.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterReturningConfiguration.class);
        });
  }

  @Test
  void sendAfterThrowingConfigurationNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterThrowingConfiguration.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterThrowingConfiguration.class);
        });
  }

  @Test
  void sendAfterCommitConfigurationNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(SendAfterCommitConfiguration.class))
              .isNotNull()
              .isExactlyInstanceOf(SendAfterCommitConfiguration.class);
        });
  }
}
