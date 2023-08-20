package im.aop.senders.advice.before;


import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendToBefore}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendToBeforeService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendToBefore(JoinPoint joinPoint, SendToBefore sendToBefore) {
  }
}
