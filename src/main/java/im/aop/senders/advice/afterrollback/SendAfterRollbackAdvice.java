package im.aop.senders.advice.afterrollback;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring's AOP Advice for {@link SendAfterRollback}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendAfterRollbackAdvice {

  @Autowired private SendAfterRollbackService sendAfterRollbackService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendAfterRollback)", argNames = "sendAfterRollback")
  void sendAfterRollbackMethodContext(final SendAfterRollback sendAfterRollback) {}

  @AfterReturning(
      value = "publicMethod() && sendAfterRollbackMethodContext(sendAfterRollback)",
      argNames = "joinPoint, sendAfterRollback, returnValue",
      returning = "returnValue")
  void sendAfterRollbackMethodContext(
      final JoinPoint joinPoint,
      final SendAfterRollback sendAfterRollback,
      final Object returnValue) {
    sendAfterRollbackService.sendAfterRollback(joinPoint, sendAfterRollback, returnValue);
  }
}
