package im.aop.senders.advice.aftercommit;

import static org.assertj.core.api.Assertions.assertThat;

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

import im.aop.senders.AopSendersProperties;

/**
 * Tests for {@link SendToAfterCommitAdvice}.
 *
 * @author Andy Lian
 */
@ExtendWith(OutputCaptureExtension.class)
class SendToAfterCommitAdviceTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendToAfterCommitAdviceTestConfiguration.class)
          .withBean(SendToAfterCommitAdvice.class)
          .withBean(AopSendersProperties.class);

  @EnableAspectJAutoProxy
  @TestConfiguration(proxyBeanMethods = false)
  static class SendToAfterCommitAdviceTestConfiguration {

    @Bean
    public SendToAfterCommitService executeAfterCommitService(
        final AopSendersProperties aopSendersProperties) {
      return new SendToAfterCommitService(aopSendersProperties) {

        @Override
        public void sendToAfterCommit(
            JoinPoint joinPoint, SendToAfterCommit sendToAfterCommit, Object returnedValue) {
          LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType())
              .info("joinPoint={}, returnedValue={}", joinPoint, returnedValue);
        }
      };
    }
  }

  static class TestMethodContext {

    @SendToAfterCommit
    public void methodWithoutParameter() {}

    @SendToAfterCommit
    public void methodWithParameter(String foo) {}

    @SendToAfterCommit
    public String methodWithResult() {
      return "foo";
    }

    @SendToAfterCommit
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
                      "joinPoint=execution(void "
                          + TestMethodContext.class.getName()
                          + ".methodWithoutParameter())")
                  .contains("returnedValue=null");
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
                      "joinPoint=execution(void "
                          + TestMethodContext.class.getName()
                          + ".methodWithParameter(String))")
                  .contains("returnedValue=null");
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
                      "joinPoint=execution(String "
                          + TestMethodContext.class.getName()
                          + ".methodWithResult())")
                  .contains("returnedValue=foo");
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
                      "joinPoint=execution(String "
                          + TestMethodContext.class.getName()
                          + ".toString())")
                  .contains("returnedValue=" + TestMethodContext.class.getName());
            });
  }
}
