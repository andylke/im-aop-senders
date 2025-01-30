package im.aop.senders.advice.afterthrowing;

import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendAfterThrowing}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendAfterThrowingService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendAfterThrowing(
      JoinPoint joinPoint, SendAfterThrowing sendAfterThrowing, final Throwable throwable) {}
}
