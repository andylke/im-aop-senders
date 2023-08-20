package im.aop.senders.advice.afterthrowing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring's AOP Advice for {@link SendToAfterThrowing}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendToAfterThrowingAdvice {

  @Autowired private SendToAfterThrowingService sendToAfterThrowingService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendToAfterThrowing)", argNames = "sendToAfterThrowing")
  void sendToAfterThrowingMethodContext(final SendToAfterThrowing sendToAfterThrowing) {}

  @AfterThrowing(
      value = "publicMethod() && sendToAfterThrowingMethodContext(sendToAfterThrowing)",
      argNames = "joinPoint, sendToAfterThrowing, throwable",
      throwing = "throwable")
  void sendToAfterThrowingMethodContext(
      final JoinPoint joinPoint,
      final SendToAfterThrowing sendToAfterThrowing,
      final Throwable throwable) {
    sendToAfterThrowingService.sendToAfterThrowing(joinPoint, sendToAfterThrowing, throwable);
  }
}
