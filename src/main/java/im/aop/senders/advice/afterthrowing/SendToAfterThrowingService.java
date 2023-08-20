package im.aop.senders.advice.afterthrowing;


import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendToAfterThrowing}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendToAfterThrowingService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendToAfterThrowing(JoinPoint joinPoint,
      SendToAfterThrowing sendToAfterThrowing, final Throwable throwable) {
  }
}
