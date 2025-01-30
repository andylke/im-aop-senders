package im.aop.senders.advice.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring's AOP Advice for {@link SendBefore}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendBeforeAdvice {

  @Autowired private SendBeforeService sendBeforeService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendBefore)", argNames = "sendBefore")
  void sendBeforeMethodContext(final SendBefore sendBefore) {}

  @Before(
      value = "publicMethod() && sendBeforeMethodContext(sendBefore)",
      argNames = "joinPoint, sendBefore")
  void sendBeforeMethodContext(final JoinPoint joinPoint, final SendBefore sendBefore) {
    sendBeforeService.sendBefore(joinPoint, sendBefore);
  }
}
