package im.aop.senders.advice.beforecommit;

import static org.assertj.core.api.Assertions.assertThat;

import im.aop.senders.AopSendersProperties;
import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Tests for {@link SendBeforeCommitAdvice}.
 *
 * @author Andy Lian
 */
@ExtendWith(OutputCaptureExtension.class)
class SendBeforeCommitAdviceTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendBeforeCommitAdviceTestConfiguration.class)
          .withBean(SendBeforeCommitAdvice.class)
          .withBean(AopSendersProperties.class);

  @EnableAspectJAutoProxy
  @TestConfiguration(proxyBeanMethods = false)
  static class SendBeforeCommitAdviceTestConfiguration {

    @Bean
    public SendBeforeCommitService sendBeforeService(
        final AopSendersProperties aopSendersProperties) {
      return new SendBeforeCommitService(aopSendersProperties) {
        @Override
        public void sendBeforeCommit(JoinPoint joinPoint, SendBeforeCommit sendBeforeCommit) {
          LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType())
              .info("{}", joinPoint);
        }
      };
    }
  }

  static class TestMethodContext {

    @SendBeforeCommit
    public void methodWithoutParameter() {}

    @SendBeforeCommit
    public void methodWithParameter(String foo) {}

    @SendBeforeCommit
    public String methodWithResult() {
      return "foo";
    }

    @SendBeforeCommit
    @Override
    public String toString() {
      return super.toString();
    }
  }

  @Test
  void methodWithoutParameter_annotatedOnMethod(final CapturedOutput capturedOutput) {
    runner
        .withBean(TestMethodContext.class)
        .run(
            context -> {
              final TestMethodContext methodContext = context.getBean(TestMethodContext.class);
              methodContext.methodWithoutParameter();

              assertThat(capturedOutput)
                  .contains(
                      "execution(void "
                          + TestMethodContext.class.getName()
                          + ".methodWithoutParameter())");
            });
  }

  @Test
  void methodWithParameter_annotatedOnMethod(final CapturedOutput capturedOutput) {
    runner
        .withBean(TestMethodContext.class)
        .run(
            context -> {
              final TestMethodContext methodContext = context.getBean(TestMethodContext.class);
              methodContext.methodWithParameter("foo");

              assertThat(capturedOutput)
                  .contains(
                      "execution(void "
                          + TestMethodContext.class.getName()
                          + ".methodWithParameter(String))");
            });
  }

  @Test
  void methodWithResult_annotatedOnMethod(final CapturedOutput capturedOutput) {
    runner
        .withBean(TestMethodContext.class)
        .run(
            context -> {
              final TestMethodContext methodContext = context.getBean(TestMethodContext.class);
              methodContext.methodWithResult();

              assertThat(capturedOutput)
                  .contains(
                      "execution(String "
                          + TestMethodContext.class.getName()
                          + ".methodWithResult())");
            });
  }

  @Test
  void toString_annotatedOnMethod(final CapturedOutput capturedOutput) {
    runner
        .withBean(TestMethodContext.class)
        .run(
            context -> {
              final TestMethodContext methodContext = context.getBean(TestMethodContext.class);
              methodContext.toString();

              assertThat(capturedOutput)
                  .contains(
                      "execution(String " + TestMethodContext.class.getName() + ".toString())");
            });
  }
}
