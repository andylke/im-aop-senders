package im.aop.senders.advice.afterreturning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring's AOP Advice for {@link SendAfterReturning}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendAfterReturningAdvice {

  @Autowired private SendAfterReturningService sendAfterReturningService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendAfterReturning)", argNames = "sendAfterReturning")
  void sendAfterReturningMethodContext(final SendAfterReturning sendAfterReturning) {}

  @AfterReturning(
      value = "publicMethod() && sendAfterReturningMethodContext(sendAfterReturning)",
      argNames = "joinPoint, sendAfterReturning, returnValue",
      returning = "returnValue")
  void sendAfterReturningMethodContext(
      final JoinPoint joinPoint,
      final SendAfterReturning sendAfterReturning,
      final Object returnValue) {
    sendAfterReturningService.sendAfterReturning(joinPoint, sendAfterReturning, returnValue);
  }
}
