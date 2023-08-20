package im.aop.senders;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link AopSendersAutoConfiguration}.
 *
 * @author Andy Lian
 */
class AopSendersAutoConfigurationTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withConfiguration(AutoConfigurations.of(AopSendersAutoConfiguration.class));

  @Test
  void aopSendersConfigurationNotNull() {
    runner.run(
        (context) -> {
          assertThat(context.getBean(AopSendersConfiguration.class))
              .isNotNull()
              .isExactlyInstanceOf(AopSendersConfiguration.class);
        });
  }
}
