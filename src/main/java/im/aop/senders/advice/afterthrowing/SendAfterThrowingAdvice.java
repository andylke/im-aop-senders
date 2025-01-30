package im.aop.senders.advice.afterthrowing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring's AOP Advice for {@link SendAfterThrowing}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendAfterThrowingAdvice {

  @Autowired private SendAfterThrowingService sendAfterThrowingService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendAfterThrowing)", argNames = "sendAfterThrowing")
  void sendAfterThrowingMethodContext(final SendAfterThrowing sendAfterThrowing) {}

  @AfterThrowing(
      value = "publicMethod() && sendAfterThrowingMethodContext(sendAfterThrowing)",
      argNames = "joinPoint, sendAfterThrowing, throwable",
      throwing = "throwable")
  void sendAfterThrowingMethodContext(
      final JoinPoint joinPoint,
      final SendAfterThrowing sendAfterThrowing,
      final Throwable throwable) {
    sendAfterThrowingService.sendAfterThrowing(joinPoint, sendAfterThrowing, throwable);
  }
}
