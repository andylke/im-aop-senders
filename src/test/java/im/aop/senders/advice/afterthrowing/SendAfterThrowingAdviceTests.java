package im.aop.senders.advice.afterthrowing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
 * Tests for {@link SendAfterThrowingAdvice}.
 *
 * @author Andy Lian
 */
@ExtendWith(OutputCaptureExtension.class)
class SendAfterThrowingAdviceTests {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withUserConfiguration(SendAfterThrowingAdviceTestConfiguration.class)
          .withBean(SendAfterThrowingAdvice.class)
          .withBean(AopSendersProperties.class);

  @EnableAspectJAutoProxy
  @TestConfiguration(proxyBeanMethods = false)
  static class SendAfterThrowingAdviceTestConfiguration {

    @Bean
    public SendAfterThrowingService sendAfterThrowingService(
        final AopSendersProperties aopSendersProperties) {
      return new SendAfterThrowingService(aopSendersProperties) {

        @Override
        public void sendAfterThrowing(
            JoinPoint joinPoint, SendAfterThrowing sendAfterThrowing, Throwable throwable) {
          LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType())
              .info("joinPoint={}, thrownException={}", joinPoint, throwable.getClass().getName());
        }
      };
    }
  }

  static class TestMethodContext {

    @SendAfterThrowing
    public void methodWithoutParameter() {
      throw new RuntimeException();
    }

    @SendAfterThrowing
    public void methodWithParameter(String foo) {
      throw new RuntimeException();
    }

    @SendAfterThrowing
    public String methodWithResult() {
      throw new RuntimeException();
    }

    @SendAfterThrowing
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
