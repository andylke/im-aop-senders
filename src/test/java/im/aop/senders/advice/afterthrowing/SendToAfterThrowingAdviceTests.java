package im.aop.senders.advice.afterthrowing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
 * Tests for {@link SendToAfterThrowingAdvice}.
 *
 * @author Andy Lian
 */
@ExtendWith(OutputCaptureExtension.class)
class SendToAfterThrowingAdviceTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(ExecuteAfterThrowingAdviceTestConfiguration.class)
          .withBean(SendToAfterThrowingAdvice.class)
          .withBean(AopSendersProperties.class);

  @EnableAspectJAutoProxy
  @TestConfiguration(proxyBeanMethods = false)
  static class ExecuteAfterThrowingAdviceTestConfiguration {

    @Bean
    public SendToAfterThrowingService ExecuteAfterThrowingService(
        final AopSendersProperties aopSendersProperties) {
      return new SendToAfterThrowingService(aopSendersProperties) {

        @Override
        public void sendToAfterThrowing(
            JoinPoint joinPoint, SendToAfterThrowing sendToAfterThrowing, Throwable throwable) {
          LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType())
              .info("joinPoint={}, thrownException={}", joinPoint, throwable.getClass().getName());
        }
      };
    }
  }

  static class TestMethodContext {

    @SendToAfterThrowing
    public void methodWithoutParameter() {
      throw new RuntimeException();
    }

    @SendToAfterThrowing
    public void methodWithParameter(String foo) {
      throw new RuntimeException();
    }

    @SendToAfterThrowing
    public String methodWithResult() {
      throw new RuntimeException();
    }

    @SendToAfterThrowing
    @Override
    public String toString() {
      throw new RuntimeException();
    }
  }

  @Test
  void methodWithoutParameter_annotatedOnMethod(final CapturedOutput capturedOutput) {
    runner
        .withBean(TestMethodContext.class)
        .run(
            context -> {
              final TestMethodContext methodContext = context.getBean(TestMethodContext.class);

              assertThrows(RuntimeException.class, methodContext::methodWithoutParameter);
              assertThat(capturedOutput)
                  .contains(
                      "joinPoint=execution(void "
                          + TestMethodContext.class.getName()
                          + ".methodWithoutParameter())")
                  .contains("thrownException=" + RuntimeException.class.getName());
            });
  }

  @Test
  void methodWithParameter_annotatedOnMethod(final CapturedOutput capturedOutput) {
    runner
        .withBean(TestMethodContext.class)
        .run(
            context -> {
              final TestMethodContext methodContext = context.getBean(TestMethodContext.class);
              assertThrows(RuntimeException.class, () -> methodContext.methodWithParameter("foo"));
              assertThat(capturedOutput)
                  .contains(
                      "joinPoint=execution(void "
                          + TestMethodContext.class.getName()
                          + ".methodWithParameter(String))")
                  .contains("thrownException=" + RuntimeException.class.getName());
            });
  }

  @Test
  void methodWithResult_annotatedOnMethod(final CapturedOutput capturedOutput) {
    runner
        .withBean(TestMethodContext.class)
        .run(
            context -> {
              final TestMethodContext methodContext = context.getBean(TestMethodContext.class);
              assertThrows(RuntimeException.class, methodContext::methodWithResult);
              assertThat(capturedOutput)
                  .contains(
                      "joinPoint=execution(String "
                          + TestMethodContext.class.getName()
                          + ".methodWithResult())")
                  .contains("thrownException=" + RuntimeException.class.getName());
            });
  }

  @Test
  void toString_annotatedOnMethod(final CapturedOutput capturedOutput) {
    runner
        .withBean(TestMethodContext.class)
        .run(
            context -> {
              final TestMethodContext methodContext = context.getBean(TestMethodContext.class);
              assertThrows(RuntimeException.class, methodContext::toString);
              assertThat(capturedOutput)
                  .contains(
                      "joinPoint=execution(String "
                          + TestMethodContext.class.getName()
                          + ".toString())")
                  .contains("thrownException=" + RuntimeException.class.getName());
            });
  }
}
