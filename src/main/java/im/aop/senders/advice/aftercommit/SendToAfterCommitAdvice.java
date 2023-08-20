package im.aop.senders.advice.aftercommit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring's AOP Advice for {@link SendToAfterCommit}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendToAfterCommitAdvice {

  @Autowired private SendToAfterCommitService sendToAfterCommitService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendToAfterCommit)", argNames = "sendToAfterCommit")
  void sendToAfterCommitMethodContext(final SendToAfterCommit sendToAfterCommit) {}

  @AfterReturning(
      value = "publicMethod() && sendToAfterCommitMethodContext(sendToAfterCommit)",
      argNames = "joinPoint, sendToAfterCommit, returnValue",
      returning = "returnValue")
  void sendToAfterCommitMethodContext(
      final JoinPoint joinPoint,
      final SendToAfterCommit sendToAfterCommit,
      final Object returnValue) {
    sendToAfterCommitService.sendToAfterCommit(joinPoint, sendToAfterCommit, returnValue);
  }
}
