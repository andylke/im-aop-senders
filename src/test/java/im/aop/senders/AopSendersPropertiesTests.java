package im.aop.senders;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link AopSendersProperties}.
 *
 * @author Andy Lian
 */
class AopSendersPropertiesTests {

  @TestConfiguration(proxyBeanMethods = false)
  @EnableConfigurationProperties({AopSendersProperties.class})
  static class AopLoggersPropertiesTestConfiguration {

  }

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(AopLoggersPropertiesTestConfiguration.class);

  @Test
  void enabled_defaultValue() {
    runner.run(
        (context) -> {
          final AopSendersProperties properties = context.getBean(AopSendersProperties.class);
          assertThat(properties.isEnabled()).isTrue();
        });
  }

  @Test
  void enabled_givenPropertyValue() {
    runner
        .withPropertyValues(AopSendersProperties.PREFIX + ".enabled=false")
        .run(
            (context) -> {
              final AopSendersProperties properties =
                  context.getBean(AopSendersProperties.class);
              assertThat(properties.isEnabled()).isFalse();
            });
  }
}
