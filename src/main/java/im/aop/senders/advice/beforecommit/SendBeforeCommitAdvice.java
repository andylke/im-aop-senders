package im.aop.senders.advice.beforecommit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring's AOP Advice for {@link SendBeforeCommit}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendBeforeCommitAdvice {

  @Autowired private SendBeforeCommitService sendBeforeCommitService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendBeforeCommit)", argNames = "sendBeforeCommit")
  void sendBeforeCommitMethodContext(final SendBeforeCommit sendBeforeCommit) {}

  @Before(
      value = "publicMethod() && sendBeforeCommitMethodContext(sendBeforeCommit)",
      argNames = "joinPoint, sendBeforeCommit")
  void sendBeforeCommitMethodContext(
      final JoinPoint joinPoint, final SendBeforeCommit sendBeforeCommit) {
    sendBeforeCommitService.sendBeforeCommit(joinPoint, sendBeforeCommit);
  }
}
