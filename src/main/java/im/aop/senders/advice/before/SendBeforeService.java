package im.aop.senders.advice.before;

import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendBefore}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendBeforeService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendBefore(JoinPoint joinPoint, SendBefore sendBefore) {}
}
