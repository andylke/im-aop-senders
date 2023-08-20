package im.aop.senders.advice.afterreturning;


import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendToAfterCommit}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendToAfterReturningService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendToAfterReturning(JoinPoint joinPoint,
      SendToAfterReturning sendToAfterReturning, Object returnValue) {
  }
}
