package im.aop.senders.advice.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring's AOP Advice for {@link SendToBefore}.
 *
 * @author Andy Lian
 */
@Aspect
public class SendToBeforeAdvice {

  @Autowired private SendToBeforeService sendToBeforeService;

  @Pointcut("execution(public * *(..))")
  void publicMethod() {}

  @Pointcut("execution(String *.toString())")
  void toStringMethod() {}

  @Pointcut(value = "@annotation(sendToBefore)", argNames = "sendToBefore")
  void sendToBeforeMethodContext(final SendToBefore sendToBefore) {}

  @Before(
      value = "publicMethod() && sendToBeforeMethodContext(sendToBefore)",
      argNames = "joinPoint, sendToBefore")
  void sendToBeforeMethodContext(final JoinPoint joinPoint, final SendToBefore sendToBefore) {
    sendToBeforeService.sendToBefore(joinPoint, sendToBefore);
  }
}
