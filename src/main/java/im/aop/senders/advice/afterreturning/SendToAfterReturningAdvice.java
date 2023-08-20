package im.aop.senders.advice.afterreturning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import im.aop.senders.advice.aftercommit.SendToAfterCommit;

/**
 * Spring's AOP Advice for {@link SendToAfterCommit}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendToAfterReturningAdvice {

  @Autowired private SendToAfterReturningService sendToAfterReturningService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendToAfterReturning)", argNames = "sendToAfterReturning")
  void sendToAfterReturningMethodContext(final SendToAfterReturning sendToAfterReturning) {}

  @AfterReturning(
      value = "publicMethod() && sendToAfterReturningMethodContext(sendToAfterReturning)",
      argNames = "joinPoint, sendToAfterReturning, returnValue",
      returning = "returnValue")
  void sendToAfterReturningMethodContext(
      final JoinPoint joinPoint,
      final SendToAfterReturning sendToAfterReturning,
      final Object returnValue) {
    sendToAfterReturningService.sendToAfterReturning(joinPoint, sendToAfterReturning, returnValue);
  }
}
