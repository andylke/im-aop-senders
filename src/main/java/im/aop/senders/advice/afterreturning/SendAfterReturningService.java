package im.aop.senders.advice.afterreturning;

import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendAfterReturning}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendAfterReturningService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendAfterReturning(
      JoinPoint joinPoint, SendAfterReturning sendAfterReturning, Object returnValue) {}
}
