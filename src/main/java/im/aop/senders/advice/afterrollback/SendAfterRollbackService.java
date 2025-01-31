package im.aop.senders.advice.afterrollback;

import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendAfterRollback}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendAfterRollbackService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendAfterRollback(
      JoinPoint joinPoint, SendAfterRollback sendAfterRollback, Object returnValue) {}
}
