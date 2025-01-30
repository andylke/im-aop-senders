package im.aop.senders.advice.aftercommit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring's AOP Advice for {@link SendAfterCommit}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendAfterCommitAdvice {

  @Autowired private SendAfterCommitService sendAfterCommitService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendAfterCommit)", argNames = "sendAfterCommit")
  void sendAfterCommitMethodContext(final SendAfterCommit sendAfterCommit) {}

  @AfterReturning(
      value = "publicMethod() && sendAfterCommitMethodContext(sendAfterCommit)",
      argNames = "joinPoint, sendAfterCommit, returnValue",
      returning = "returnValue")
  void sendAfterCommitMethodContext(
      final JoinPoint joinPoint, final SendAfterCommit sendAfterCommit, final Object returnValue) {
    sendAfterCommitService.sendAfterCommit(joinPoint, sendAfterCommit, returnValue);
  }
}
